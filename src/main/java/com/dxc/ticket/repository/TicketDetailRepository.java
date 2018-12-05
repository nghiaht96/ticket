package com.dxc.ticket.repository;

import com.dxc.ticket.entity.TicketDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDetailRepository  extends JpaRepository<TicketDetailEntity,String> {
}
