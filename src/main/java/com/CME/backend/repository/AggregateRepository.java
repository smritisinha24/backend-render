package com.CME.backend.repository;

import com.CME.backend.dto.AggregateFunctionDTO;
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

    public List<AggregateFunctionDTO> getAggregateTradeStats(LocalDate startDate, LocalDate endDate) {
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
            LIMIT 100000;
        """;

        return jdbcTemplate.query(query, new Object[]{startDate, endDate}, (rs, rowNum) -> new AggregateFunctionDTO(
                rs.getString("instrument_id"),
                rs.getDate("trade_date").toLocalDate(),
                rs.getBigDecimal("avg_price"),
                rs.getBigDecimal("total_volume"),
                rs.getBigDecimal("max_price")
        ));
    }
}
