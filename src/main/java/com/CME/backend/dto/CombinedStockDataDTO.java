package com.CME.backend.dto;

import com.CME.backend.model.Instrument;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CombinedStockDataDTO {
    private String symbol;
    private BigDecimal prevClose;
    private BigDecimal iep;
    private BigDecimal chng;
    private BigDecimal pctChng;
    private BigDecimal finalValue;
    private Integer finalQuantity;
    private BigDecimal value;
    private BigDecimal ffmCap;
    private BigDecimal week52High;
    private BigDecimal week52Low;
    private BigDecimal finalPrice;
    private BigDecimal dayHigh;
    private BigDecimal dayLow;

    // Instrument related fields
    private BigDecimal upperBand;
    private BigDecimal lowerBand;
    private String priceBand;
    private BigDecimal dailyVolatility;
    private BigDecimal annualisedVolatility;
    private BigDecimal tickSize;
    private String longName;
    private String industry;
    private String stockExchange;
    private BigDecimal peRatio;
    private BigDecimal dividendYield;
    private BigDecimal roe;

    // Trade Info fields
    private String tradeId;
    private BigDecimal percentDeliverableTradedQuantity;
    private BigDecimal applicableMarginRate;
    private BigDecimal faceValue;
    private String instrumentId;
    private BigDecimal tradedVolumeLakhs;
    private BigDecimal tradedValueCr;
    private BigDecimal totalMarketCapCr;
    private BigDecimal impactCost;
    private LocalDate tradeDate; // New field



    public CombinedStockDataDTO() {
    }

    // Constructor combining all fields
    public CombinedStockDataDTO(StockData stockData, Instrument instrument, TradeInfo tradeInfo) {
        this.symbol = stockData.getSymbol();
        this.prevClose = stockData.getPrevClose();
        this.iep = stockData.getIep();
        this.chng = stockData.getChng();
        this.pctChng = stockData.getPctChng();
        this.finalValue = stockData.getFinalValue();
        this.finalQuantity = stockData.getFinalQuantity();
        this.value = stockData.getValue();
        this.ffmCap = stockData.getFfmCap();
        this.week52High = stockData.getWeek52High();
        this.week52Low = stockData.getWeek52Low();
        this.finalPrice = stockData.getFinalPrice();
        this.dayHigh = stockData.getDayHigh();
        this.dayLow = stockData.getDayLow();

        this.upperBand = instrument.getUpperBand();
        this.lowerBand = instrument.getLowerBand();
        this.priceBand = instrument.getPriceBand();
        this.dailyVolatility = instrument.getDailyVolatility();
        this.annualisedVolatility = instrument.getAnnualisedVolatility();
        this.tickSize = instrument.getTickSize();
        this.longName = instrument.getLongName();
        this.industry = instrument.getIndustry();
        this.stockExchange = instrument.getStockExchange();
        this.peRatio = instrument.getPeRatio();
        this.dividendYield = instrument.getDividendYield();
        this.roe = instrument.getRoe();

        this.tradeId = tradeInfo.getTradeId();
        this.percentDeliverableTradedQuantity = tradeInfo.getPercentDeliverableTradedQuantity();
        this.applicableMarginRate = tradeInfo.getApplicableMarginRate();
        this.faceValue = tradeInfo.getFaceValue();
        this.instrumentId = instrument.getInstrumentId();
        this.tradedVolumeLakhs = tradeInfo.getTradedVolumeLakhs();
        this.tradedValueCr = tradeInfo.getTradedValueCr();
        this.totalMarketCapCr = tradeInfo.getTotalMarketCapCr();
        this.impactCost = tradeInfo.getImpactCost();
        this.tradeDate = tradeInfo.getTradeDate();
    }

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

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
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

    public String getTradeId() { return tradeId; }
    public void setTradeId(String tradeId) { this.tradeId = tradeId; }

    public BigDecimal getPercentDeliverableTradedQuantity() { return percentDeliverableTradedQuantity; }
    public void setPercentDeliverableTradedQuantity(BigDecimal percentDeliverableTradedQuantity) {
        this.percentDeliverableTradedQuantity = percentDeliverableTradedQuantity;
    }

    public BigDecimal getApplicableMarginRate() { return applicableMarginRate; }

    public void setApplicableMarginRate(BigDecimal applicableMarginRate) {
        this.applicableMarginRate = applicableMarginRate;
    }

    public BigDecimal getFaceValue() { return faceValue; }
    public void setFaceValue(BigDecimal faceValue) { this.faceValue = faceValue; }

    public String getInstrumentId() { return instrumentId; }
    public void setInstrumentId(String instrumentId) { this.instrumentId = instrumentId; }

    public BigDecimal getTradedVolumeLakhs() {
        return tradedVolumeLakhs;
    }

    public void setTradedVolumeLakhs(BigDecimal tradedVolumeLakhs) {
        this.tradedVolumeLakhs = tradedVolumeLakhs;
    }

    public BigDecimal getTradedValueCr() {
        return tradedValueCr;
    }

    public void setTradedValueCr(BigDecimal tradedValueCr) {
        this.tradedValueCr = tradedValueCr;
    }

    public BigDecimal getTotalMarketCapCr() {
        return totalMarketCapCr;
    }

    public void setTotalMarketCapCr(BigDecimal totalMarketCapCr) {
        this.totalMarketCapCr = totalMarketCapCr;
    }

    public BigDecimal getImpactCost() {
        return impactCost;
    }

    public void setImpactCost(BigDecimal impactCost) {
        this.impactCost = impactCost;
    }
}