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
 * Ticket
 */
@Validated

public class Ticket   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("idticket")
  private String idticket = null;

  @JsonProperty("ticketDetails")
  private Object ticketDetails = null;

  @JsonProperty("totalFee")
  private BigDecimal totalFee = null;

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

  public Ticket idticket(String idticket) {
    this.idticket = idticket;
    return this;
  }

  /**
   * Get idticket
   * @return idticket
  **/
  @ApiModelProperty(example = "0", value = "")


  public String getIdticket() {
    return idticket;
  }

  public void setIdticket(String idticket) {
    this.idticket = idticket;
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
        Objects.equals(this.idticket, ticket.idticket) &&
        Objects.equals(this.ticketDetails, ticket.ticketDetails) &&
        Objects.equals(this.totalFee, ticket.totalFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idticket, ticketDetails, totalFee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idticket: ").append(toIndentedString(idticket)).append("\n");
    sb.append("    ticketDetails: ").append(toIndentedString(ticketDetails)).append("\n");
    sb.append("    totalFee: ").append(toIndentedString(totalFee)).append("\n");
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

