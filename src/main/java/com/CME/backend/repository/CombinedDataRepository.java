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

    //   fetch combined data from all three tables(Stock_data, trade_info and instruments) by joining tables using symbol and instrument id
    public List<CombinedStockDataDTO> findCombinedDataBySymbol(String symbol) {
        String query = """           
            SELECT 
                s.symbol AS s_symbol, s.prev_close, s.iep, s.chng, s.pct_chng, s.final_value, s.final_quantity, 
                s.value, s.ffm_cap AS s_ffm_cap, s.week_52_high AS s_week_52_high, s.week_52_low AS s_week_52_low, 
                s.final_price, s.day_high, s.day_low, 
                t.trade_id, t.instrument_id AS t_instrumentId, t.traded_volume_lakhs, t.traded_value_cr, 
                t.total_market_cap_cr, t.impact_cost, t.percent_deliverable_traded_quantity, 
                t.applicable_margin_rate, t.face_value, 
                i.week_52_high AS i_week_52_high, i.week_52_low AS i_week_52_low, i.upper_band, i.lower_band, 
                i.price_band, i.daily_volatility, i.annualised_volatility, i.tick_size, i.long_name, 
                i.industry, i.stock_exchange, i.pe_ratio, i.dividend_yield, i.roe 
            FROM 
                stock_data s 
            JOIN 
                trade_info t ON s.symbol = t.instrument_id 
            JOIN 
                instrument i ON t.instrument_id = i.instrument_id 
            WHERE 
                LOWER(s.symbol) = LOWER(?)
            """;

        return jdbcTemplate.query(query, new Object[]{symbol}, new CombinedStockDataDTORowMapper());
    }
}
