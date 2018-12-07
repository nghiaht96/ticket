package com.dxc.ticket.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TicketDetail")
public class TicketDetailEntity {
    @Id
    @Column(name = "id",length = 36)
    private String id;

    @Column(name = "isbn", length = 36)
    private String isbn;

    @Column(name = "borrowingDate")
    private Date borrowingDate;

    @Column(name = "returnDate")
    private Date returnDate;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

    @Column(name = "fee")
    private double fee;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "returnStatus")
    private boolean returnStatus;

    @Column(name = "ticketId",insertable = false,updatable = false)
    private String ticketId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketId")
    private TicketEntity ticketEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String bookId) {
        this.isbn = bookId;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }
}
