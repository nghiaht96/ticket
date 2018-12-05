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
 * TicketDetail
 */
@Validated

public class TicketDetail   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("idBook")
  private String idBook = null;

  @JsonProperty("idTicket")
  private String idTicket = null;

  @JsonProperty("borrowDate")
  private LocalDate borrowDate = null;

  @JsonProperty("returnDate")
  private LocalDate returnDate = null;

  @JsonProperty("fee")
  private BigDecimal fee = null;

  public TicketDetail id(String id) {
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

  public TicketDetail idBook(String idBook) {
    this.idBook = idBook;
    return this;
  }

  /**
   * Get idBook
   * @return idBook
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getIdBook() {
    return idBook;
  }

  public void setIdBook(String idBook) {
    this.idBook = idBook;
  }

  public TicketDetail idTicket(String idTicket) {
    this.idTicket = idTicket;
    return this;
  }

  /**
   * Get idTicket
   * @return idTicket
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getIdTicket() {
    return idTicket;
  }

  public void setIdTicket(String idTicket) {
    this.idTicket = idTicket;
  }

  public TicketDetail borrowDate(LocalDate borrowDate) {
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

  public TicketDetail returnDate(LocalDate returnDate) {
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

  public TicketDetail fee(BigDecimal fee) {
    this.fee = fee;
    return this;
  }

  /**
   * Get fee
   * @return fee
  **/
  @ApiModelProperty(example = "3.5", value = "")

  @Valid

  public BigDecimal getFee() {
    return fee;
  }

  public void setFee(BigDecimal fee) {
    this.fee = fee;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TicketDetail ticketDetail = (TicketDetail) o;
    return Objects.equals(this.id, ticketDetail.id) &&
        Objects.equals(this.idBook, ticketDetail.idBook) &&
        Objects.equals(this.idTicket, ticketDetail.idTicket) &&
        Objects.equals(this.borrowDate, ticketDetail.borrowDate) &&
        Objects.equals(this.returnDate, ticketDetail.returnDate) &&
        Objects.equals(this.fee, ticketDetail.fee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idBook, idTicket, borrowDate, returnDate, fee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idBook: ").append(toIndentedString(idBook)).append("\n");
    sb.append("    idTicket: ").append(toIndentedString(idTicket)).append("\n");
    sb.append("    borrowDate: ").append(toIndentedString(borrowDate)).append("\n");
    sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
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

