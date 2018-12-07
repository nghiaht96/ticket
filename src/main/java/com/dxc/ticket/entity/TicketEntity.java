package com.dxc.ticket.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="ticket")
public class TicketEntity {
    @Id
    @Column(name = "id",length = 36)
    private String id;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

    @Column(name = "userName",nullable = false)
    private String userName;

    @Column(name = "limitBook",columnDefinition = "integer default 3")
    private int limitBook;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<TicketDetailEntity> ticketDetailEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLimitBook() {
        return limitBook;
    }

    public void setLimitBook(int limitBook) {
        this.limitBook = limitBook;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<TicketDetailEntity> getTicketDetailEntities() {
        return ticketDetailEntities;
    }

    public void setTicketDetailEntities(List<TicketDetailEntity> ticketDetailEntities) {
        this.ticketDetailEntities = ticketDetailEntities;
    }
}
