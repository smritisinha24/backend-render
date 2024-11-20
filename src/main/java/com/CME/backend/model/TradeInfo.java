package com.CME.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trade_info")
public class TradeInfo {

    @Id
    @Column(name = "trade_id")
    private String tradeId;

    @Column(name = "instrument_id")
    private String instrumentId;

    @Column(name = "traded_volume_lakhs")
    private BigDecimal tradedVolumeLakhs;

    @Column(name = "traded_value_cr")
    private BigDecimal tradedValueCr;

    @Column(name = "total_market_cap_cr")
    private BigDecimal totalMarketCapCr;

    @Column(name = "ffm_cap")
    private BigDecimal ffmCap;

    @Column(name = "impact_cost")
    private BigDecimal impactCost;

    @Column(name = "percent_deliverable_traded_quantity")
    private BigDecimal percentDeliverableTradedQuantity;

    @Column(name = "applicable_margin_rate")
    private BigDecimal applicableMarginRate;

    @Column(name = "face_value")
    private BigDecimal faceValue;

    @Column(name = "trade_date")
    private LocalDate tradeDate;

    public LocalDate getTradeDate() { return tradeDate; }

    public void setTradeDate(LocalDate tradeDate) { this.tradeDate = tradeDate; }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

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

    public BigDecimal getFfmCap() {
        return ffmCap;
    }

    public void setFfmCap(BigDecimal ffmCap) {
        this.ffmCap = ffmCap;
    }

    public BigDecimal getImpactCost() {
        return impactCost;
    }

    public void setImpactCost(BigDecimal impactCost) {
        this.impactCost = impactCost;
    }

    public BigDecimal getPercentDeliverableTradedQuantity() {
        return percentDeliverableTradedQuantity;
    }

    public void setPercentDeliverableTradedQuantity(BigDecimal percentDeliverableTradedQuantity) {
        this.percentDeliverableTradedQuantity = percentDeliverableTradedQuantity;
    }

    public BigDecimal getApplicableMarginRate() {
        return applicableMarginRate;
    }

    public void setApplicableMarginRate(BigDecimal applicableMarginRate) {
        this.applicableMarginRate = applicableMarginRate;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }
}