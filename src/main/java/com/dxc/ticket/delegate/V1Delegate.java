package com.dxc.ticket.delegate;

import com.dxc.ticket.api.V1ApiDelegate;
import com.dxc.ticket.api.model.Ticket;
import com.dxc.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class V1Delegate implements V1ApiDelegate {
    @Autowired
    private TicketService ticketService;


    @Override
    public ResponseEntity<String> deleteTicket(String idTicket) {
        return ResponseEntity.ok(ticketService.deleteTicket(idTicket));
    }

    @Override
    public ResponseEntity<Ticket> getTicketByIdTicket(String idTicket) {
        return null;
    }

    @Override
    public ResponseEntity<String> getTotalBorrowingBook(String idTicket) {
        return null;
    }

    @Override
    public ResponseEntity<List<Ticket>> searchTicketByIsbn(String isbn) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsertTicket(Ticket ticket) {
        return ResponseEntity.ok(ticketService.upsertTicket(ticket));
    }
}
