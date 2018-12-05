package com.dxc.ticket.service;

import com.dxc.ticket.api.model.Ticket;
import com.dxc.ticket.api.model.TicketDetail;
import com.dxc.ticket.entity.TicketDetailEntity;
import com.dxc.ticket.repository.TicketDetailRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketDetailService {
    @Autowired
    private TicketDetailRepository ticketDetailRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Transactional
    public List<String> upsertTicketDetail(List<TicketDetail> ticketDetails, String idTicket){
        List<String> listDetailId = new ArrayList<>();
        for(TicketDetail ticketDetail : ticketDetails){
            TicketDetailEntity oldTicketDetailEntity = ticketDetailRepository.searchByIdTicketAndIdDetail(idTicket,ticketDetail.getId());
            if(oldTicketDetailEntity == null){
                listDetailId.add(insertDetail(ticketDetail,idTicket) + " inserted");
            }
            else{
                listDetailId.add(updateDetail(ticketDetail,oldTicketDetailEntity) + "updated");
            }
        }
        return listDetailId;
    }


    @Transactional
    private String insertDetail(TicketDetail ticketDetail,String idTicket){
        String id = UUID.randomUUID().toString();
        TicketDetailEntity ticketDetailEntity = convertToTicketDetailEntity(ticketDetail);
        ticketDetailEntity.setId(id);
        ticketDetailEntity.setCreateDate(new Date());
        ticketDetailEntity.setModifiedDate(new Date());
        ticketDetailEntity.setDeleted(false);
        ticketDetailEntity.setFee(30000);
        ticketDetailEntity.setTicketId(idTicket);
        ticketDetailRepository.saveAndFlush(ticketDetailEntity);
        return id;
    }

    @Transactional
    private String updateDetail(TicketDetail ticketDetail,TicketDetailEntity oldTicketDetail){
        oldTicketDetail.setReturnDate(ticketDetail.getReturnDate().toDate());
        oldTicketDetail.setBorrowingDate(ticketDetail.getBorrowDate().toDate());
        oldTicketDetail.setModifiedDate(new Date());
        oldTicketDetail.setIsbn(ticketDetail.getIsbn());
        oldTicketDetail.setDeleted(false);
        ticketDetailRepository.save(oldTicketDetail);
        return oldTicketDetail.getId();
    }

    private TicketDetailEntity convertToTicketDetailEntity(TicketDetail ticketDetail){
        TicketDetailEntity ticketDetailEntity = new TicketDetailEntity();
        ticketDetailEntity.setIsbn(ticketDetail.getIsbn());
        ticketDetailEntity.setBorrowingDate(ticketDetail.getBorrowDate().toDate());
        ticketDetailEntity.setReturnDate(ticketDetail.getReturnDate().toDate());
        return ticketDetailEntity;
    }

}
