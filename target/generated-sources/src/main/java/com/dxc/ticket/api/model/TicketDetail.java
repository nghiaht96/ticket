package com.dxc.ticket.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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

  @JsonProperty("isbn")
  private String isbn = null;

  @JsonProperty("idTicket")
  private String idTicket = null;

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

  public TicketDetail isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * Get isbn
   * @return isbn
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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
        Objects.equals(this.isbn, ticketDetail.isbn) &&
        Objects.equals(this.idTicket, ticketDetail.idTicket) &&
        Objects.equals(this.fee, ticketDetail.fee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isbn, idTicket, fee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketDetail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    idTicket: ").append(toIndentedString(idTicket)).append("\n");
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

