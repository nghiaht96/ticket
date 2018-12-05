package com.dxc.ticket.repository;

import com.dxc.ticket.entity.TicketDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDetailRepository  extends JpaRepository<TicketDetailEntity,String> {

    @Query("select t from TicketDetailEntity t where t.ticketId = ?1 and t.id = ?2")
    TicketDetailEntity searchByIdTicketAndIdDetail(String ticketId, String id);
}
