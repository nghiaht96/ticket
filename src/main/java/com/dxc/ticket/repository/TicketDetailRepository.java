package com.dxc.ticket.repository;

import com.dxc.ticket.entity.Reports.*;
import com.dxc.ticket.entity.TicketDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketDetailRepository  extends JpaRepository<TicketDetailEntity,String> {
    @Query("select t from TicketDetailEntity t where t.ticketId = ?1 and t.id = ?2")
    TicketDetailEntity searchByIdTicketAndIsbn(String ticketId, String isbn);

    @Modifying(clearAutomatically = true)
    @Query("update TicketDetailEntity t set t.deleted = true, t.modifiedDate = now() where t.ticketId = ?1 and t.deleted = false")
    int deleteTicketDetail(String idTicket);

    @Query("select weekofyear(d.borrowingDate) as week ,sum(d.fee) as income from TicketDetailEntity d group by weekofyear(d.borrowingDate)")
    Collection<IncomeWeekly> statisticIncomeWeekly();

    @Query("select month(d.borrowingDate) as month ,sum(d.fee) as income from TicketDetailEntity d group by month(d.borrowingDate)")
    Collection<IncomeMonthly> statisticIncomeMonthly();

    @Query("select year(d.borrowingDate) as year ,sum(d.fee) as income from TicketDetailEntity d group by year(d.borrowingDate)")
    Collection<IncomeYearly> statisticIncomeYearly();

    @Query("select count(t.id) as NumberBorrowingTicket, weekofyear(t.createDate) as week from TicketEntity t where t.deleted = false group by weekofyear(t.createDate)")
    Collection<NumberBorrowingTicketWeekly> statisticNumberBorrowingTicketWeekly();

    @Query("select count(t.id) as NumberBorrowingTicket, month(t.createDate) as month from TicketEntity t where t.deleted = false group by month(t.createDate)")
    Collection<NumberBorrowingTicketMonthly> statisticNumberBorrowingTicketMonthly();

    @Query("select count(t.id) as NumberBorrowingTicket, year(t.createDate) as week from TicketEntity t where t.deleted = false group by year(t.createDate)")
    Collection<NumberBorrowingTicketYearly> statisticNumberBorrowingTicketYearly();

    @Query("select count(t.id) from TicketDetailEntity t where t.isbn = ?1 and t.deleted = false")
    int countTotalNumberBorrowingBook(String isbn);
}
