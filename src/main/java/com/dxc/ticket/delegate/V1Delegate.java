package com.dxc.ticket.delegate;

import com.dxc.ticket.api.V1ApiDelegate;
import com.dxc.ticket.api.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class V1Delegate implements V1ApiDelegate {
    @Override
    public ResponseEntity<String> deleteTicket(String idTicket) {
        return null;
    }

    @Override
    public ResponseEntity<Ticket> getTicketByIdTicket(String idTicket) {
        return null;
    }

    @Override
    public ResponseEntity<String> upsertTicket(Ticket ticket) {
        return null;
    }
}
