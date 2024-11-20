package com.CME.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IndustryAggregateDTO {
    private String industry;
    private LocalDate tradeMonth;
    private BigDecimal avgTradedValue;
    private BigDecimal totalTradedVolume;
    private BigDecimal maxTradedValue;

    public IndustryAggregateDTO(String industry, LocalDate tradeMonth, BigDecimal avgTradedValue,
                                BigDecimal totalTradedVolume, BigDecimal maxTradedValue) {
        this.industry = industry;
        this.tradeMonth = tradeMonth;
        this.avgTradedValue = avgTradedValue;
        this.totalTradedVolume = totalTradedVolume;
        this.maxTradedValue = maxTradedValue;
    }

    // Getters and Setters
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public LocalDate getTradeMonth() {
        return tradeMonth;
    }

    public void setTradeMonth(LocalDate tradeMonth) {
        this.tradeMonth = tradeMonth;
    }

    public BigDecimal getAvgTradedValue() {
        return avgTradedValue;
    }

    public void setAvgTradedValue(BigDecimal avgTradedValue) {
        this.avgTradedValue = avgTradedValue;
    }

    public BigDecimal getTotalTradedVolume() {
        return totalTradedVolume;
    }

    public void setTotalTradedVolume(BigDecimal totalTradedVolume) {
        this.totalTradedVolume = totalTradedVolume;
    }

    public BigDecimal getMaxTradedValue() {
        return maxTradedValue;
    }

    public void setMaxTradedValue(BigDecimal maxTradedValue) {
        this.maxTradedValue = maxTradedValue;
    }
}
