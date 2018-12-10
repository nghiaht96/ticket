package com.dxc.ticket.service;

import com.dxc.ticket.api.model.Ticket;
import com.dxc.ticket.api.model.TicketDetail;
import com.dxc.ticket.common.StorageError;
import com.dxc.ticket.entity.TicketEntity;
import com.dxc.ticket.exception.StorageException;
import com.dxc.ticket.repository.TicketDetailRepository;
import com.dxc.ticket.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketDetailRepository ticketDetailRepository;

    @Autowired
    private TicketDetailService ticketDetailService;

    private static final int LIMIT_BOOK_DEFAULT = 3;

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketEntity.class);

    @Transactional
    public String upsertTicket(Ticket ticket) {
        String idTicket = "";
        List<String> listDetailId = new ArrayList<>();
        TicketEntity oldTicket = ticketRepository.findOne(ticket.getId());
        if (oldTicket == null) {
            idTicket = insertTicket(ticket);
            listDetailId = ticketDetailService.upsertMultiTicketDetail(ticket.getTicketDetails(), idTicket);
            return idTicket + " inserted";
        }
        idTicket = updateTicket(ticket, oldTicket);
        listDetailId = ticketDetailService.upsertMultiTicketDetail(ticket.getTicketDetails(), idTicket);
        return idTicket;
    }

    public Ticket getTicketByIdTicket(String idTicket){
        if(idTicket.length() != 36) throw new StorageException(StorageError.ID_NOT_VALIDATION, idTicket);
        Ticket ticket = new Ticket();
        TicketEntity  ticketEntity = ticketRepository.findOne(idTicket);
        if(ticketEntity == null) throw new StorageException(StorageError.TICKET_NOT_FOUND, idTicket);
        ticket = convertTicketEntityToTicket(ticketEntity);
        return ticket;
    }

    @Transactional
    public String deleteTicket(String idTicket) {
        int count = ticketRepository.deleteTicket(idTicket);
        if (count <= 0) throw new StorageException(StorageError.TICKET_NOT_FOUND, idTicket);
        ticketDetailService.deleteTicketDetail(idTicket);
        return idTicket;
    }

    @Transactional
    private String insertTicket(Ticket ticket) {
        if (ticket.getTicketDetails().size() > LIMIT_BOOK_DEFAULT)
            throw new StorageException(StorageError.LIMITBOOK_NOT_VALIDATION);
        String id = UUID.randomUUID().toString();
        ticket.setId(id);
        TicketEntity ticketEntity = convertTicketToEntity(ticket);
        ticketEntity.setCreateDate(new Date());
        ticketEntity.setModifiedDate(new Date());
        ticketEntity.setDeleted(false);
        ticketEntity.setLimitBook(LIMIT_BOOK_DEFAULT);
        ticketRepository.saveAndFlush(ticketEntity);
        return id;
    }

    @Transactional
    private String updateTicket(Ticket ticket, TicketEntity oldTicket) {
        if (ticket.getTicketDetails().size() > oldTicket.getLimitBook())
            throw new StorageException(StorageError.LIMITBOOK_NOT_VALIDATION);
        Date createDate = oldTicket.getCreateDate();
        int limitBook = oldTicket.getLimitBook();
        oldTicket = convertTicketToEntity(ticket);
        oldTicket.setDeleted(false);
        oldTicket.setModifiedDate(new Date());
        oldTicket.setCreateDate(createDate);
        oldTicket.setLimitBook(limitBook);
        ticketRepository.saveAndFlush(oldTicket);
        return oldTicket.getId();
    }

    public String statisticsIncome(String type){
        switch (type){
            case "WEEKLY":
                return ticketDetailRepository.statisticIncomeWeekly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
            case "MONTHLY":
                return ticketDetailRepository.statisticIncomeMonthly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
            case "YEARLY":
                return ticketDetailRepository.statisticIncomeYearly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
        }
        return null;
    }

    public String statisticsNumberBorrowingTicket(String type){
        switch (type){
            case "WEEKLY":
                return ticketDetailRepository.statisticNumberBorrowingTicketWeekly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
            case "MONTHLY":
                return ticketDetailRepository.statisticNumberBorrowingTicketMonthly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
            case "YEARLY":
                return ticketDetailRepository.statisticNumberBorrowingTicketYearly()
                        .stream()
                        .map(t -> t.toString())
                        .collect(Collectors.joining(",\n", "[\n", "\n]"));
        }
        return null;
    }

    private TicketEntity convertTicketToEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setId(ticket.getId());
        ticketEntity.setUserName(ticket.getUsername());
        return ticketEntity;
    }

    private Ticket convertTicketEntityToTicket(TicketEntity ticketEntity){
        Ticket ticket = new Ticket();
        ticket.setId(ticketEntity.getId());
        ticket.setLimitBook(ticketEntity.getLimitBook());
        ticket.setUsername(ticketEntity.getUserName());
        ticket.setTotalFee(ticketEntity.getTotalFee());
        ticket.setTicketDetails(ticketEntity.getTicketDetailEntities()
                .stream()
                .map(t -> ticketDetailService.ticketDetailEntity2TicketDetail(t))
                .collect(Collectors.toList()));
        return ticket;
    }
}
