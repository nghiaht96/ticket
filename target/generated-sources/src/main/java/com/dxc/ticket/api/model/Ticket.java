package com.dxc.ticket.api.model;

import java.util.Objects;
import com.dxc.ticket.api.model.TicketDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
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
  @Valid
  private List<TicketDetail> ticketDetails = null;

  @JsonProperty("totalFee")
  private Double totalFee = null;

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

  public Ticket ticketDetails(List<TicketDetail> ticketDetails) {
    this.ticketDetails = ticketDetails;
    return this;
  }

  public Ticket addTicketDetailsItem(TicketDetail ticketDetailsItem) {
    if (this.ticketDetails == null) {
      this.ticketDetails = new ArrayList<TicketDetail>();
    }
    this.ticketDetails.add(ticketDetailsItem);
    return this;
  }

  /**
   * Get ticketDetails
   * @return ticketDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TicketDetail> getTicketDetails() {
    return ticketDetails;
  }

  public void setTicketDetails(List<TicketDetail> ticketDetails) {
    this.ticketDetails = ticketDetails;
  }

  public Ticket totalFee(Double totalFee) {
    this.totalFee = totalFee;
    return this;
  }

  /**
   * Get totalFee
   * @return totalFee
  **/
  @ApiModelProperty(example = "10.0", value = "")


  public Double getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Double totalFee) {
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
        Objects.equals(this.totalFee, ticket.totalFee) &&
        Objects.equals(this.limitBook, ticket.limitBook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, ticketDetails, totalFee, limitBook);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ticket {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    ticketDetails: ").append(toIndentedString(ticketDetails)).append("\n");
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

