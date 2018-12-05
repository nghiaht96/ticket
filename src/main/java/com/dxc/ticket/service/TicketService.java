package com.dxc.ticket.service;

import com.dxc.ticket.api.model.Ticket;
import com.dxc.ticket.api.model.TicketDetail;
import com.dxc.ticket.entity.TicketEntity;
import com.dxc.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketDetailService ticketDetailService;

    @Transactional
    public String upsertTicket(Ticket ticket){

        String idTicket = "";
        List<String> listDetailId = new ArrayList<>();
        TicketEntity oldTicket = ticketRepository.findOne(ticket.getId());
        if(oldTicket == null)
        {
            idTicket = insertTicket(ticket);
            listDetailId = ticketDetailService.upsertTicketDetail(ticket.getTicketDetails(),idTicket);
            return idTicket + " inserted";
        }
        idTicket = updateTicket(ticket,oldTicket);
        listDetailId = ticketDetailService.upsertTicketDetail(ticket.getTicketDetails(),idTicket);
        return idTicket;
    }

    @Transactional
    private String insertTicket(Ticket ticket){
        String id = UUID.randomUUID().toString();
        ticket.setId(id);
        TicketEntity ticketEntity = convertTicketToEntity(ticket);
        ticketEntity.setCreateDate(new Date());
        ticketEntity.setModifiedDate(new Date());
        ticketEntity.setDeleted(false);
        ticketRepository.saveAndFlush(ticketEntity);
        return id;
    }

    @Transactional
    private String updateTicket(Ticket ticket,TicketEntity oldTicket){
        Date createDate = oldTicket.getCreateDate();
        oldTicket = convertTicketToEntity(ticket);
        oldTicket.setDeleted(false);
        oldTicket.setModifiedDate(new Date());
        ticketRepository.saveAndFlush(oldTicket);
        return oldTicket.getId();
    }

    private TicketEntity convertTicketToEntity(Ticket ticket){
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setId(ticket.getId());
        ticketEntity.setLimitBook(ticket.getLimitBook());
        ticketEntity.setUserName(ticket.getUsername());
        ticketEntity.setTotalFee(ticket.getTotalFee());
        return ticketEntity;
    }
}
