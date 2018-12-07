package com.dxc.ticket.repository;

import com.dxc.ticket.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,String> {

    @Modifying(clearAutomatically = true)
    @Query("update TicketEntity t set t.deleted = true, t.modifiedDate = now() where t.id = ?1 and t.deleted = false")
    int deleteTicket(String idTicket);

}
