package com.CME.backend.repository;

import com.CME.backend.dto.TradeAggregateDTO;
import com.CME.backend.dto.IndustryAggregateDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AggregateRepository {

    private final JdbcTemplate jdbcTemplate;

    public AggregateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
            LIMIT 100;
        """;

        return jdbcTemplate.query(query, new Object[]{startDate, endDate}, (rs, rowNum) -> new TradeAggregateDTO(
                rs.getString("instrument_id"),
                rs.getDate("trade_date").toLocalDate(),
                rs.getBigDecimal("avg_price"),
                rs.getBigDecimal("total_volume"),
                rs.getBigDecimal("max_price")
        ));
    }

    // New method for industry-based aggregate stats
    public List<IndustryAggregateDTO> getIndustryAggregateStats(LocalDate startDate, LocalDate endDate) {
        String query = """
        SELECT
            industry,
            date_trunc('month', trade_date) AS trade_month,  -- Postgres version of toStartOfMonth
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
        LIMIT 100;
    """;

        return jdbcTemplate.query(query, new Object[]{startDate, endDate}, (rs, rowNum) -> new IndustryAggregateDTO(
                rs.getString("industry"),
                rs.getDate("trade_month").toLocalDate(),
                rs.getBigDecimal("avg_traded_value"),
                rs.getBigDecimal("total_traded_volume"),
                rs.getBigDecimal("max_traded_value")
        ));
    }
}
