package com.CME.backend.repository;

import com.CME.backend.dto.TradeAggregateDTO;
import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.dto.IndustryAggregateDTO;
import com.CME.backend.model.Instrument;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;
import com.CME.backend.util.CombinedStockDataDTORowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ClickhouseRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClickhouseRepository(@Qualifier("clickhouseJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Fetch all records from stock_data table.
    public List<StockData> findAllStockData() {
        String sql = """
                    SELECT symbol, prev_close, iep, chng, pct_chng, final_value, final_quantity, value,
                           ffm_cap, week_52_high, week_52_low, final_price, day_high, day_low
                    FROM stock_data
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalValue(rs.getBigDecimal("final_value"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setWeek52High(rs.getBigDecimal("week_52_high"));
            stockData.setWeek52Low(rs.getBigDecimal("week_52_low"));
            stockData.setFinalPrice(rs.getBigDecimal("final_price"));
            stockData.setDayHigh(rs.getBigDecimal("day_high"));
            stockData.setDayLow(rs.getBigDecimal("day_low"));
            return stockData;
        });
    }


    //    Fetch stock data for a specific symbol from stock_data table.
    public StockData findStockDataBySymbol(String symbol) {
        String sql = """
                    SELECT symbol, prev_close, iep, chng, pct_chng, final_value, final_quantity, value,
                           ffm_cap, week_52_high, week_52_low, final_price, day_high, day_low
                    FROM stock_data
                    WHERE LOWER(symbol) = LOWER(?)
                """;
        List<StockData> result = jdbcTemplate.query(sql, new Object[]{symbol}, (rs, rowNum) -> {
            StockData stockData = new StockData();
            stockData.setSymbol(rs.getString("symbol"));
            stockData.setPrevClose(rs.getBigDecimal("prev_close"));
            stockData.setIep(rs.getBigDecimal("iep"));
            stockData.setChng(rs.getBigDecimal("chng"));
            stockData.setPctChng(rs.getBigDecimal("pct_chng"));
            stockData.setFinalValue(rs.getBigDecimal("final_value"));
            stockData.setFinalQuantity(rs.getInt("final_quantity"));
            stockData.setValue(rs.getBigDecimal("value"));
            stockData.setFfmCap(rs.getBigDecimal("ffm_cap"));
            stockData.setWeek52High(rs.getBigDecimal("week_52_high"));
            stockData.setWeek52Low(rs.getBigDecimal("week_52_low"));
            stockData.setFinalPrice(rs.getBigDecimal("final_price"));
            stockData.setDayHigh(rs.getBigDecimal("day_high"));
            stockData.setDayLow(rs.getBigDecimal("day_low"));
            return stockData;
        });
        return result.isEmpty() ? null : result.get(0);
    }


    //    Fetch trade information for a specific instrument ID from trade_info table.
    public List<TradeInfo> findTradeInfoByInstrumentId(String instrumentId) {
        String sql = """
                    SELECT trade_id, instrument_id, traded_volume_lakhs, traded_value_cr, total_market_cap_cr,
                           ffm_cap, impact_cost, percent_deliverable_traded_quantity,
                           applicable_margin_rate, face_value
                    FROM trade_info
                    WHERE LOWER(instrument_id) = LOWER(?)
                """;
        return jdbcTemplate.query(sql, new Object[]{instrumentId}, (rs, rowNum) -> {
            TradeInfo tradeInfo = new TradeInfo();
            tradeInfo.setTradeId(rs.getString("trade_id"));
            tradeInfo.setInstrumentId(rs.getString("instrument_id"));
            tradeInfo.setTradedVolumeLakhs(rs.getBigDecimal("traded_volume_lakhs"));
            tradeInfo.setTradedValueCr(rs.getBigDecimal("traded_value_cr"));
            tradeInfo.setTotalMarketCapCr(rs.getBigDecimal("total_market_cap_cr"));
            tradeInfo.setFfmCap(rs.getBigDecimal("ffm_cap"));
            tradeInfo.setImpactCost(rs.getBigDecimal("impact_cost"));
            tradeInfo.setPercentDeliverableTradedQuantity(rs.getBigDecimal("percent_deliverable_traded_quantity"));
            tradeInfo.setApplicableMarginRate(rs.getBigDecimal("applicable_margin_rate"));
            tradeInfo.setFaceValue(rs.getBigDecimal("face_value"));

            return tradeInfo;
        });
    }


    //      Fetch instrument data for a specific instrument ID from instrument table.
    public Instrument findInstrumentInfoByInstrumentId(String instrumentId) {
        String sql = """
                    SELECT instrument_id, week_52_high, week_52_low, upper_band, lower_band, price_band,
                           daily_volatility, annualised_volatility, tick_size, long_name, industry,
                           stock_exchange, pe_ratio, dividend_yield, roe
                    FROM instrument
                    WHERE LOWER(instrument_id) = LOWER(?)
                """;
        List<Instrument> result = jdbcTemplate.query(sql, new Object[]{instrumentId}, (rs, rowNum) -> {
            Instrument instrument = new Instrument();
            instrument.setInstrumentId(rs.getString("instrument_id"));
            instrument.setWeek52High(rs.getBigDecimal("week_52_high"));
            instrument.setWeek52Low(rs.getBigDecimal("week_52_low"));
            instrument.setUpperBand(rs.getBigDecimal("upper_band"));
            instrument.setLowerBand(rs.getBigDecimal("lower_band"));
            instrument.setPriceBand(rs.getString("price_band"));
            instrument.setDailyVolatility(rs.getBigDecimal("daily_volatility"));
            instrument.setAnnualisedVolatility(rs.getBigDecimal("annualised_volatility"));
            instrument.setTickSize(rs.getBigDecimal("tick_size"));
            instrument.setLongName(rs.getString("long_name"));
            instrument.setIndustry(rs.getString("industry"));
            instrument.setStockExchange(rs.getString("stock_exchange"));
            instrument.setPeRatio(rs.getBigDecimal("pe_ratio"));
            instrument.setDividendYield(rs.getBigDecimal("dividend_yield"));
            instrument.setRoe(rs.getBigDecimal("roe"));
            return instrument;
        });
        return result.isEmpty() ? null : result.get(0);
    }


    //   fetch combined data from all three tables(Stock_data, trade_info and instruments) by joining tables using symbol and instrument id
    public List<CombinedStockDataDTO> findCombinedDataBySymbol(String symbol) {
        String sql = """
                SELECT
                    s.symbol AS s_symbol,s.prev_close,s.iep,s.chng,s.pct_chng,s.final_value,s.final_quantity,s.value,s.ffm_cap AS s_ffm_cap,s.week_52_high AS s_week_52_high,s.week_52_low AS s_week_52_low,s.final_price,s.day_high,s.day_low,
                    t.trade_id,t.instrument_id AS t_instrumentId, t.traded_volume_lakhs,t.traded_value_cr,t.total_market_cap_cr,t.impact_cost,t.percent_deliverable_traded_quantity,t.applicable_margin_rate,t.face_value,
                    i.upper_band,i.lower_band,i.price_band,i.daily_volatility,i.annualised_volatility,i.tick_size,i.long_name,i.industry,i.stock_exchange,i.pe_ratio,i.dividend_yield,i.roe
                FROM stock_data s JOIN trade_info t ON s.symbol = t.instrument_id
                JOIN instrument i ON t.instrument_id = i.instrument_id
                WHERE s.symbol = ?
                """;

        return jdbcTemplate.query(sql, new CombinedStockDataDTORowMapper(), symbol);
    }


    //    Fetch trade specific aggregated statistics from trade_info table using startDate and endDate
    public List<TradeAggregateDTO> getTradeAggregateStats(LocalDate startDate, LocalDate endDate) {
        String query = """
            SELECT
                instrument_id,
                trade_date,
                AVG(traded_value_cr) AS avg_price,
                SUM(traded_volume_lakhs) AS total_volume,
                MAX(traded_value_cr) AS max_price
            FROM
                trade_info
            WHERE
                trade_date BETWEEN ? AND ?
            GROUP BY
                instrument_id, trade_date
            ORDER BY
                trade_date ASC, instrument_id ASC
            LIMIT 100
        """;

        return jdbcTemplate.query(query, (rs, rowNum) -> new TradeAggregateDTO(
                rs.getString("instrument_id"),
                rs.getDate("trade_date").toLocalDate(),
                rs.getBigDecimal("avg_price"),
                rs.getBigDecimal("total_volume"),
                rs.getBigDecimal("max_price")
        ), startDate, endDate);
    }


    //    Fetch industry specific aggregated statistics from trade_info table using startDate and endDate
    public List<IndustryAggregateDTO> getIndustryAggregateStats(LocalDate startDate, LocalDate endDate) {
        String query = """
        SELECT
            industry,
            toStartOfMonth(trade_date) AS trade_month,
            AVG(traded_value_cr) AS avg_traded_value,
            SUM(traded_volume_lakhs) AS total_traded_volume,
            MAX(traded_value_cr) AS max_traded_value
        FROM
            trade_info
        INNER JOIN
            instrument USING (instrument_id)
        WHERE
            trade_date BETWEEN ? AND ?
        GROUP BY
            industry, trade_month
        ORDER BY
            trade_month ASC, industry ASC
        LIMIT 100
    """;

        return jdbcTemplate.query(query, (rs, rowNum) -> new IndustryAggregateDTO(
                rs.getString("industry"),
                rs.getDate("trade_month").toLocalDate(),
                rs.getBigDecimal("avg_traded_value"),
                rs.getBigDecimal("total_traded_volume"),
                rs.getBigDecimal("max_traded_value")
        ), startDate, endDate);
    }

}