package com.dxc.ticket.api;

import java.util.List;
import com.dxc.ticket.api.model.Ticket;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class V1ApiController implements V1Api {

    private final V1ApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public V1ApiController(V1ApiDelegate delegate) {
        this.delegate = delegate;
    }
    public ResponseEntity<String> deleteTicket(@ApiParam(value = "The idTicket that needs to be deleted",required=true) @PathVariable("idTicket") String idTicket) {
        return delegate.deleteTicket(idTicket);
    }

    public ResponseEntity<Ticket> getTicketByIdTicket(@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket) {
        return delegate.getTicketByIdTicket(idTicket);
    }

    public ResponseEntity<String> getTotalBorrowingBook(@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket) {
        return delegate.getTotalBorrowingBook(idTicket);
    }

    public ResponseEntity<List<String>> returnBook(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<String> listIsbn,@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket) {
        return delegate.returnBook(listIsbn, idTicket);
    }

    public ResponseEntity<List<Ticket>> searchTicketByIsbn(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "isbn", required = true) String isbn) {
        return delegate.searchTicketByIsbn(isbn);
    }

    public ResponseEntity<String> upsertTicket(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Ticket ticket) {
        return delegate.upsertTicket(ticket);
    }

}
