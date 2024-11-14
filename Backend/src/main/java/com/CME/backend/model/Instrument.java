package com.CME.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "instrument")
public class Instrument {

    @Id
    @Column(name = "instrument_id")
    private String instrumentId;

    @Column(name = "week_52_high")
    private BigDecimal week52High;

    @Column(name = "week_52_low")
    private BigDecimal week52Low;

    @Column(name = "upper_band")
    private BigDecimal upperBand;

    @Column(name = "lower_band")
    private BigDecimal lowerBand;

    @Column(name = "price_band")
    private String priceBand;

    @Column(name = "daily_volatility")
    private BigDecimal dailyVolatility;

    @Column(name = "annualised_volatility")
    private BigDecimal annualisedVolatility;

    @Column(name = "tick_size")
    private BigDecimal tickSize;

    @Column(name = "long_name")
    private String longName;

    @Column(name = "industry")
    private String industry;

    @Column(name = "stock_exchange")
    private String stockExchange;

    @Column(name = "pe_ratio")
    private BigDecimal peRatio;

    @Column(name = "dividend_yield")
    private BigDecimal dividendYield;

    @Column(name = "roe")
    private BigDecimal roe;

    // Getters and Setters
    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
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

    public BigDecimal getUpperBand() {
        return upperBand;
    }

    public void setUpperBand(BigDecimal upperBand) {
        this.upperBand = upperBand;
    }

    public BigDecimal getLowerBand() {
        return lowerBand;
    }

    public void setLowerBand(BigDecimal lowerBand) {
        this.lowerBand = lowerBand;
    }

    public String getPriceBand() {
        return priceBand;
    }

    public void setPriceBand(String priceBand) {
        this.priceBand = priceBand;
    }

    public BigDecimal getDailyVolatility() {
        return dailyVolatility;
    }

    public void setDailyVolatility(BigDecimal dailyVolatility) {
        this.dailyVolatility = dailyVolatility;
    }

    public BigDecimal getAnnualisedVolatility() {
        return annualisedVolatility;
    }

    public void setAnnualisedVolatility(BigDecimal annualisedVolatility) {
        this.annualisedVolatility = annualisedVolatility;
    }

    public BigDecimal getTickSize() {
        return tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(BigDecimal peRatio) {
        this.peRatio = peRatio;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public void setRoe(BigDecimal roe) {
        this.roe = roe;
    }
}
