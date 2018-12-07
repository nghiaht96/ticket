/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.dxc.ticket.api;

import java.util.List;
import com.dxc.ticket.api.model.Ticket;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Api(value = "v1", description = "the v1 API")
public interface V1Api {

    @ApiOperation(value = "Delete Ticket", nickname = "deleteTicket", notes = "", response = String.class, tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Deleted succsessfully", response = String.class),
        @ApiResponse(code = 400, message = "Invalid idTicket supplied"),
        @ApiResponse(code = 404, message = "Ticket not found"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/v1/tickets/{idTicket}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<String> deleteTicket(@ApiParam(value = "The idTicket that needs to be deleted",required=true) @PathVariable("idTicket") String idTicket);


    @ApiOperation(value = "Get ticket by idTicket", nickname = "getTicketByIdTicket", notes = "", response = Ticket.class, tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "succesfull operation", response = Ticket.class),
        @ApiResponse(code = 400, message = "Invalid idTicket supplied"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/v1/tickets/{idTicket}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Ticket> getTicketByIdTicket(@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket);


    @ApiOperation(value = "Get total borrowing book of ticket", nickname = "getTotalBorrowingBook", notes = "Get total borrowing book of ticket", response = String.class, tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class) })
    @RequestMapping(value = "/v1/tickets/{idTicket}/limit",
        method = RequestMethod.GET)
    ResponseEntity<String> getTotalBorrowingBook(@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket);


    @ApiOperation(value = "Return Book", nickname = "returnBook", notes = "", response = String.class, responseContainer = "List", tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class, responseContainer = "List") })
    @RequestMapping(value = "/v1/tickets/{idTicket}/returnBook",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<List<String>> returnBook(@ApiParam(value = "" ,required=true )  @Valid @RequestBody List<String> listIsbn,@ApiParam(value = "",required=true) @PathVariable("idTicket") String idTicket);


    @ApiOperation(value = "search ticket by isbn of book", nickname = "searchTicketByIsbn", notes = "search ticket by isbn of book", response = Ticket.class, responseContainer = "List", tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Ticket.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/v1/tickets/countTicketByIsbn",
        method = RequestMethod.GET)
    ResponseEntity<List<Ticket>> searchTicketByIsbn(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "isbn", required = true) String isbn);


    @ApiOperation(value = "Upsert ticket", nickname = "upsertTicket", notes = "", response = String.class, tags={ "ticket", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 400, message = "Bad request, validation error"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(value = "/v1/tickets/",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> upsertTicket(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Ticket ticket);

}
