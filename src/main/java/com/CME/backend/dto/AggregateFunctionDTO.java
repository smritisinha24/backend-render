package com.CME.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AggregateFunctionDTO {
    private String instrumentId;
    private LocalDate tradeDate;
    private BigDecimal avgPrice;
    private BigDecimal totalVolume;
    private BigDecimal maxPrice;

    public AggregateFunctionDTO(String instrumentId, LocalDate tradeDate, BigDecimal avgPrice, BigDecimal totalVolume, BigDecimal maxPrice) {
        this.instrumentId = instrumentId;
        this.tradeDate = tradeDate;
        this.avgPrice = avgPrice;
        this.totalVolume = totalVolume;
        this.maxPrice = maxPrice;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(BigDecimal totalVolume) {
        this.totalVolume = totalVolume;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}