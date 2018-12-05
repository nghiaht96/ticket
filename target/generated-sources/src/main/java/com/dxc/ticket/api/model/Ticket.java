package com.dxc.ticket.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.joda.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ticket
 */
@Validated

public class Ticket   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("ticketDetails")
  private Object ticketDetails = null;

  @JsonProperty("borrowDate")
  private LocalDate borrowDate = null;

  @JsonProperty("returnDate")
  private LocalDate returnDate = null;

  @JsonProperty("totalFee")
  private BigDecimal totalFee = null;

  @JsonProperty("limitBook")
  private Integer limitBook = null;

  public Ticket id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Ticket username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Ticket ticketDetails(Object ticketDetails) {
    this.ticketDetails = ticketDetails;
    return this;
  }

  /**
   * Get ticketDetails
   * @return ticketDetails
  **/
  @ApiModelProperty(value = "")


  public Object getTicketDetails() {
    return ticketDetails;
  }

  public void setTicketDetails(Object ticketDetails) {
    this.ticketDetails = ticketDetails;
  }

  public Ticket borrowDate(LocalDate borrowDate) {
    this.borrowDate = borrowDate;
    return this;
  }

  /**
   * Get borrowDate
   * @return borrowDate
  **/
  @ApiModelProperty(example = "2019-1-1", value = "")

  @Valid

  public LocalDate getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(LocalDate borrowDate) {
    this.borrowDate = borrowDate;
  }

  public Ticket returnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
    return this;
  }

  /**
   * Get returnDate
   * @return returnDate
  **/
  @ApiModelProperty(example = "2019-1-3", value = "")

  @Valid

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public Ticket totalFee(BigDecimal totalFee) {
    this.totalFee = totalFee;
    return this;
  }

  /**
   * Get totalFee
   * @return totalFee
  **/
  @ApiModelProperty(example = "10.0", value = "")

  @Valid

  public BigDecimal getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(BigDecimal totalFee) {
    this.totalFee = totalFee;
  }

  public Ticket limitBook(Integer limitBook) {
    this.limitBook = limitBook;
    return this;
  }

  /**
   * Get limitBook
   * @return limitBook
  **/
  @ApiModelProperty(example = "3", value = "")


  public Integer getLimitBook() {
    return limitBook;
  }

  public void setLimitBook(Integer limitBook) {
    this.limitBook = limitBook;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return Objects.equals(this.id, ticket.id) &&
        Objects.equals(this.username, ticket.username) &&
        Objects.equals(this.ticketDetails, ticket.ticketDetails) &&
        Objects.equals(this.borrowDate, ticket.borrowDate) &&
        Objects.equals(this.returnDate, ticket.returnDate) &&
        Objects.equals(this.totalFee, ticket.totalFee) &&
        Objects.equals(this.limitBook, ticket.limitBook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, ticketDetails, borrowDate, returnDate, totalFee, limitBook);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    ticketDetails: ").append(toIndentedString(ticketDetails)).append("\n");
    sb.append("    borrowDate: ").append(toIndentedString(borrowDate)).append("\n");
    sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
    sb.append("    totalFee: ").append(toIndentedString(totalFee)).append("\n");
    sb.append("    limitBook: ").append(toIndentedString(limitBook)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

