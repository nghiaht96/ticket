package com.dxc.ticket.service;

import com.dxc.ticket.api.model.TicketDetail;
import com.dxc.ticket.common.StorageError;
import com.dxc.ticket.entity.TicketDetailEntity;
import com.dxc.ticket.entity.TicketEntity;
import com.dxc.ticket.exception.StorageException;
import com.dxc.ticket.repository.TicketDetailRepository;
import com.dxc.ticket.repository.TicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TicketDetailService {
    @Autowired
    private TicketDetailRepository ticketDetailRepository;

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ObjectMapper objectMapper;

    private static final int FEE_PER_DATE = 3000;

    public String getTotalBorrowingBook(String isbn){
        int count = ticketDetailRepository.getTotalBorrowingBook(isbn);
        return String.valueOf(count);
    }

    @Transactional
    public List<String> returnBook(String idTicket, List<String> listIsbn){
        List<String> ret = new ArrayList<>();
        for(String isbn : listIsbn){
            if(ticketDetailRepository.returnBook(idTicket, isbn) <= 0) throw new StorageException(StorageError.TICKETDETAIL_NOT_FOUND, isbn);
            else ret.add(isbn);
        }
        return ret;
    }

    @Transactional
    public List<String> upsertMultiTicketDetail(List<TicketDetail> ticketDetails, String idTicket) {
        List<String> listDetailId = new ArrayList<>();
        for (TicketDetail ticketDetail : ticketDetails) {
            dateInputValidate(ticketDetail.getBorrowDate().toDate(), ticketDetail.getReturnDate().toDate());
            TicketDetailEntity oldTicketDetailEntity = ticketDetailRepository.searchByIdTicketAndIsbn(idTicket, ticketDetail.getIsbn());
            if (oldTicketDetailEntity == null) {
                listDetailId.add(insertTicketDeitailEntity(ticketDetail, idTicket) + " inserted");
            } else {
                listDetailId.add(updateTicketDetailEntity(ticketDetail, oldTicketDetailEntity) + "updated");
            }
        }
        return listDetailId;
    }

    @Transactional
    public int deleteTicketDetail(String idTicket) {
        int count = ticketDetailRepository.deleteTicketDetail(idTicket);
        if (count <= 0) {
        }
        return count;
    }

    private void dateInputValidate(Date borrowingDate, Date returnDate) {
        if (returnDate.getTime() - borrowingDate.getTime() < 0) {
            throw new StorageException(StorageError.DATEINPUT_NOT_VALIDATION, "borrowingDate > returnDate");
        }
    }

    @Transactional
    private String insertTicketDeitailEntity(TicketDetail ticketDetail, String idTicket) {
        String id = UUID.randomUUID().toString();
        TicketDetailEntity ticketDetailEntity = ticketDetail2TicketDetailEntity(ticketDetail);
        ticketDetailEntity.setId(id);
        ticketDetailEntity.setCreateDate(new Date());
        ticketDetailEntity.setTicketEntity(ticketRepository.findOne(idTicket));
        ticketDetailEntity.setReturnStatus(false);
        ticketDetailRepository.saveAndFlush(ticketDetailEntity);
        return id;
    }

    @Transactional
    private String updateTicketDetailEntity(TicketDetail ticketDetail, TicketDetailEntity oldTicketDetailEntity) {
        String id = oldTicketDetailEntity.getId();
        Date createDate = oldTicketDetailEntity.getCreateDate();
        TicketEntity ticketEntity = oldTicketDetailEntity.getTicketEntity();
        boolean returnStatus = oldTicketDetailEntity.isReturnStatus();
        oldTicketDetailEntity = ticketDetail2TicketDetailEntity(ticketDetail);
        oldTicketDetailEntity.setId(id);
        oldTicketDetailEntity.setCreateDate(createDate);
        oldTicketDetailEntity.setTicketEntity(ticketEntity);
        oldTicketDetailEntity.setReturnStatus(returnStatus);
        ticketDetailRepository.save(oldTicketDetailEntity);
        return oldTicketDetailEntity.getId();
    }

    private TicketDetailEntity ticketDetail2TicketDetailEntity(TicketDetail ticketDetail) {

        TicketDetailEntity ticketDetailEntity = new TicketDetailEntity();
        ticketDetailEntity.setIsbn(ticketDetail.getIsbn());
        ticketDetailEntity.setBorrowingDate(ticketDetail.getBorrowDate().toDate());
        ticketDetailEntity.setReturnDate(ticketDetail.getReturnDate().toDate());

        ticketDetailEntity.setFee(TimeUnit.DAYS.convert(Math.abs(ticketDetailEntity.getReturnDate().getTime() - ticketDetailEntity.getBorrowingDate().getTime()), TimeUnit.MILLISECONDS) * FEE_PER_DATE);
        ticketDetailEntity.setDeleted(false);
        ticketDetailEntity.setModifiedDate(new Date());
        return ticketDetailEntity;
    }

    protected TicketDetail ticketDetailEntity2TicketDetail(TicketDetailEntity ticketDetailEntity){
        TicketDetail ticketDetail = new TicketDetail();
        ticketDetail.setId(ticketDetailEntity.getId());
        ticketDetail.setIsbn(ticketDetailEntity.getIsbn());
        ticketDetail.setReturnStatus(ticketDetailEntity.isReturnStatus());
        ticketDetail.setBorrowDate(new LocalDate(ticketDetailEntity.getBorrowingDate()));
        ticketDetail.setReturnDate(new LocalDate(ticketDetailEntity.getReturnDate()));
        ticketDetail.setIdTicket(ticketDetailEntity.getTicketEntity().getId());
        ticketDetail.setFee(ticketDetailEntity.getFee());
        return ticketDetail;
    }

}
