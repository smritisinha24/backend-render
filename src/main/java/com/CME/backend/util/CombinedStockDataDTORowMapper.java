package com.CME.backend.util;

import com.CME.backend.dto.CombinedStockDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CombinedStockDataDTORowMapper implements RowMapper<CombinedStockDataDTO> {

        private static final Logger logger = LoggerFactory.getLogger(CombinedStockDataDTORowMapper.class);

        @Override
        public CombinedStockDataDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                CombinedStockDataDTO dto = new CombinedStockDataDTO();

                // Mapping StockData fields
                dto.setSymbol(rs.getString("s_symbol"));
                dto.setPrevClose(rs.getBigDecimal("prev_close"));
                dto.setIep(rs.getBigDecimal("iep"));
                dto.setChng(rs.getBigDecimal("chng"));
                dto.setPctChng(rs.getBigDecimal("pct_chng"));
                dto.setFinalValue(rs.getBigDecimal("final_value"));
                dto.setFinalQuantity(rs.getInt("final_quantity"));
                dto.setValue(rs.getBigDecimal("value"));
                dto.setFfmCap(rs.getBigDecimal("s_ffm_cap"));  // Add this line to set ffm_cap
                dto.setWeek52High(rs.getBigDecimal("s_week_52_high"));
                dto.setWeek52Low(rs.getBigDecimal("s_week_52_low"));
                dto.setFinalPrice(rs.getBigDecimal("final_price"));
                dto.setDayHigh(rs.getBigDecimal("day_high"));
                dto.setDayLow(rs.getBigDecimal("day_low"));

                // Mapping TradeInfo fields
                dto.setTradeId(rs.getString("trade_id"));
                dto.setTradedVolumeLakhs(rs.getBigDecimal("traded_volume_lakhs"));
                dto.setTradedValueCr(rs.getBigDecimal("traded_value_cr"));
                dto.setTotalMarketCapCr(rs.getBigDecimal("total_market_cap_cr"));
                dto.setImpactCost(rs.getBigDecimal("impact_cost"));
                dto.setPercentDeliverableTradedQuantity(rs.getBigDecimal("percent_deliverable_traded_quantity"));
                dto.setApplicableMarginRate(rs.getBigDecimal("applicable_margin_rate"));
                dto.setFaceValue(rs.getBigDecimal("face_value"));

                // Mapping Instrument fields
                dto.setUpperBand(rs.getBigDecimal("upper_band"));
                dto.setLowerBand(rs.getBigDecimal("lower_band"));
                dto.setPriceBand(rs.getString("price_band"));
                dto.setDailyVolatility(rs.getBigDecimal("daily_volatility"));
                dto.setAnnualisedVolatility(rs.getBigDecimal("annualised_volatility"));
                dto.setTickSize(rs.getBigDecimal("tick_size"));
                dto.setLongName(rs.getString("long_name"));
                dto.setIndustry(rs.getString("industry"));
                dto.setStockExchange(rs.getString("stock_exchange"));
                dto.setPeRatio(rs.getBigDecimal("pe_ratio"));
                dto.setDividendYield(rs.getBigDecimal("dividend_yield"));
                dto.setRoe(rs.getBigDecimal("roe"));

                return dto;
        }
}
