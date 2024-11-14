package com.CME.backend.repository;

import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.util.CombinedStockDataDTORowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CombinedDataRepository {

    private final JdbcTemplate jdbcTemplate;

    public CombinedDataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CombinedStockDataDTO> getCombinedDataBySymbol(String symbol) {
        String query = "SELECT \n" +
                "    s.symbol AS s_symbol, s.prev_close, s.iep, s.chng, s.pct_chng, s.final_value, s.final_quantity, \n" +
                "    s.value, s.ffm_cap as s_ffm_cap, s.week_52_high AS s_week_52_high, s.week_52_low AS s_week_52_low, \n" +
                "    s.final_price, s.day_high, s.day_low, \n" +
                "    t.trade_id, t.traded_volume_lakhs, t.traded_value_cr, t.total_market_cap_cr, t.impact_cost, \n" +
                "    t.percent_deliverable_traded_quantity, t.applicable_margin_rate, t.face_value, \n" +
                "    i.week_52_high AS i_week_52_high, i.week_52_low AS i_week_52_low, i.upper_band, i.lower_band, \n" +
                "    i.price_band, i.daily_volatility, i.annualised_volatility, i.tick_size, i.long_name, \n" +
                "    i.industry, i.stock_exchange, i.pe_ratio, i.dividend_yield, i.roe \n" +
                "FROM " +
                "    stock_data s JOIN trade_info t ON s.symbol = t.instrument_id " +
                "JOIN instrument i ON t.instrument_id = i.instrument_id " +
                "WHERE s.symbol = ?";

        return jdbcTemplate.query(query, new Object[]{symbol}, new CombinedStockDataDTORowMapper());
    }
}
