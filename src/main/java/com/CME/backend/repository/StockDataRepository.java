package com.CME.backend.repository;

import com.CME.backend.model.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, String> {
    // Fetch stock data for a specific symbol from stock_data table.
    StockData findStockDataBySymbol(String symbol);
}
