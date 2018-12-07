package com.dxc.ticket.repository;

import com.dxc.ticket.entity.TicketDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDetailRepository  extends JpaRepository<TicketDetailEntity,String> {

    @Query("select t from TicketDetailEntity t where t.ticketId = ?1 and t.id = ?2")
    TicketDetailEntity searchByIdTicketAndIsbn(String ticketId, String isbn);

    @Modifying(clearAutomatically = true)
    @Query("update TicketDetailEntity t set t.deleted = true, t.modifiedDate = now() where t.ticketId = ?1 and t.deleted = false")
    int deleteTicketDetail(String idTicket);

    @Modifying(clearAutomatically = true)
    @Query("update TicketDetailEntity t set t.returnStatus = true, t.modifiedDate = now() where t.ticketId = ?1 and t.isbn = ?2 and t.deleted = false")
    int returnBook(String idTicket, String Isbn);
}
