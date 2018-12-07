package com.dxc.ticket.api;

import java.util.List;
import com.dxc.ticket.api.model.Ticket;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * A delegate to be called by the {@link V1ApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface V1ApiDelegate {

    /**
     * @see V1Api#deleteTicket
     */
    ResponseEntity<String> deleteTicket(String idTicket);

    /**
     * @see V1Api#getTicketByIdTicket
     */
    ResponseEntity<Ticket> getTicketByIdTicket(String idTicket);

    /**
     * @see V1Api#getTotalBorrowingBook
     */
    ResponseEntity<String> getTotalBorrowingBook(String idTicket);

    /**
     * @see V1Api#returnBook
     */
    ResponseEntity<List<String>> returnBook(List<String> listIsbn,
        String idTicket);

    /**
     * @see V1Api#searchTicketByIsbn
     */
    ResponseEntity<List<Ticket>> searchTicketByIsbn(String isbn);

    /**
     * @see V1Api#upsertTicket
     */
    ResponseEntity<String> upsertTicket(Ticket ticket);

}
