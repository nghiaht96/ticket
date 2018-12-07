package com.dxc.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Statistic {

    private Double income;

    private Integer week;

    @Override
    public String toString() {
        return "{" +
                "week = " + week +
                ", income = " + income +
                '}';
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }


}
