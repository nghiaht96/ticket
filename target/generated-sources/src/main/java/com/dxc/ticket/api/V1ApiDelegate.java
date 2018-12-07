package com.dxc.ticket.api;

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
     * @see V1Api#countTicketByIsbn
     */
    ResponseEntity<Integer> countTicketByIsbn(String isbn);

    /**
     * @see V1Api#deleteTicket
     */
    ResponseEntity<String> deleteTicket(String idTicket);

    /**
     * @see V1Api#getTicketByIdTicket
     */
    ResponseEntity<Ticket> getTicketByIdTicket(String idTicket);

    /**
     * @see V1Api#setLimitBorrowingBook
     */
    ResponseEntity<Void> setLimitBorrowingBook(String idTicket,
        Integer limitBookNumber);

    /**
     * @see V1Api#statisticsIncome
     */
    ResponseEntity<String> statisticsIncome(String type);

    /**
     * @see V1Api#statisticsNumberBorrowingTicket
     */
    ResponseEntity<String> statisticsNumberBorrowingTicket(String type);

    /**
     * @see V1Api#upsertTicket
     */
    ResponseEntity<String> upsertTicket(Ticket ticket);

}
