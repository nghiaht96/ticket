package com.dxc.ticket.delegate;

import com.dxc.ticket.api.V1ApiDelegate;
import com.dxc.ticket.api.model.Ticket;
import com.dxc.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.xml.transform.OutputKeys;
import java.math.BigDecimal;
import java.util.List;

@Component
public class V1Delegate implements V1ApiDelegate {
    @Autowired
    private TicketService ticketService;

    @Override
    public ResponseEntity<Integer> countTicketByIsbn(String isbn) {
        return ResponseEntity.ok(ticketService.countTicketByIsbn(isbn));
    }

    @Override
    public ResponseEntity<String> deleteTicket(String idTicket) {
        return ResponseEntity.ok(ticketService.deleteTicket(idTicket));
    }

    @Override
    public ResponseEntity<Ticket> getTicketByIdTicket(String idTicket) {
        return ResponseEntity.ok(ticketService.getTicketByIdTicket(idTicket));
    }

    @Override
    public ResponseEntity<Void> setLimitBorrowingBook(String idTicket, Integer limitBookNumber) {
        ticketService.setLimitBorrowingBook(idTicket, limitBookNumber);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> statisticsIncome(String type) {
        return ResponseEntity.ok(ticketService.statisticsIncome(type));
    }

    @Override
    public ResponseEntity<String> statisticsNumberBorrowingTicket(String type) {
        return ResponseEntity.ok(ticketService.statisticsNumberBorrowingTicket(type));
    }

    @Override
    public ResponseEntity<String> upsertTicket(Ticket ticket) {
        return ResponseEntity.ok(ticketService.upsertTicket(ticket));
    }
}
