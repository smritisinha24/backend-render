package com.CME.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "stock_data")
public class StockData {
    @Id
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "prev_close")
    private BigDecimal prevClose;

    @Column(name = "iep")
    private BigDecimal iep;

    @Column(name = "chng")
    private BigDecimal chng;

    @Column(name = "pct_chng")
    private BigDecimal pctChng;

    @Column(name = "final_value")
    private BigDecimal finalValue;

    @Column(name = "final_quantity")
    private Integer finalQuantity;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "ffm_cap")
    private BigDecimal ffmCap;

    @Column(name = "week_52_high")
    private BigDecimal week52High;

    @Column(name = "week_52_low")
    private BigDecimal week52Low;

    @Column(name = "final_price")
    private BigDecimal finalPrice;

    @Column(name = "day_high")
    private BigDecimal dayHigh;

    @Column(name = "day_low")
    private BigDecimal dayLow;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(BigDecimal prevClose) {
        this.prevClose = prevClose;
    }

    public BigDecimal getIep() {
        return iep;
    }

    public void setIep(BigDecimal iep) {
        this.iep = iep;
    }

    public BigDecimal getChng() {
        return chng;
    }

    public void setChng(BigDecimal chng) {
        this.chng = chng;
    }

    public BigDecimal getPctChng() {
        return pctChng;
    }

    public void setPctChng(BigDecimal pctChng) {
        this.pctChng = pctChng;
    }

    public BigDecimal getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(BigDecimal finalValue) {
        this.finalValue = finalValue;
    }

    public Integer getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(Integer finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getFfmCap() {
        return ffmCap;
    }

    public void setFfmCap(BigDecimal ffmCap) {
        this.ffmCap = ffmCap;
    }

    public BigDecimal getWeek52High() {
        return week52High;
    }

    public void setWeek52High(BigDecimal week52High) {
        this.week52High = week52High;
    }

    public BigDecimal getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(BigDecimal week52Low) {
        this.week52Low = week52Low;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }


}
