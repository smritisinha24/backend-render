package com.CME.backend.service;

import com.CME.backend.dto.TradeAggregateDTO;
import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.dto.IndustryAggregateDTO;
import com.CME.backend.model.Instrument;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;
import com.CME.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StockDataRepository stockDataRepository;

    @Autowired
    private TradeInfoRepository tradeInfoRepository;

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private ClickhouseRepository clickhouseRepository;

    @Autowired
    private CombinedDataRepository combinedDataRepository;

    @Autowired
    private AggregateRepository aggregateRepository;


    //  Checking if the database source provided is either clickhouse or postgres only
    private void validateDbSource(String dbsource) {
        if (!"clickhouse".equalsIgnoreCase(dbsource) && !"postgres".equalsIgnoreCase(dbsource)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid dbsource parameter. Use 'clickhouse' or 'postgres'."
            );
        }
    }

    // Fetch all stocks data from stock data table
    public List<StockData> getAllStockData(String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findAllStockData();
        } else {
            return stockDataRepository.findAll();
        }
    }

    // Fetch specific stock data using symbol
    public StockData getStockDataBySymbol(String symbol, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findStockDataBySymbol(symbol);
        } else {
            return stockDataRepository.findStockDataBySymbol(symbol);
        }
    }

    // Fetch specific trade info using Instrument ID
    public List<TradeInfo> getTradeInfoByInstrumentId(String instrumentid, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findTradeInfoByInstrumentId(instrumentid);
        } else {
            return tradeInfoRepository.findTradeInfoByInstrumentId(instrumentid);
        }
    }

    // Fetch specific instrument info using Instrument ID
    public Instrument getInstrumentById(String instrumentId, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findInstrumentInfoByInstrumentId(instrumentId);
        } else {
            return instrumentRepository.findInstrumentInfoByInstrumentId(instrumentId);
        }
    }

    // Fetch combined data for a specific symbol
    public List<CombinedStockDataDTO> getCombinedDataBySymbol(String symbol, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findCombinedDataBySymbol(symbol);
        } else {
            return combinedDataRepository.findCombinedDataBySymbol(symbol);
        }
    }

    //    Fetch trade specific aggregated statistics from trade_info table using startDate and endDate
    public List<TradeAggregateDTO> getTradeStats(String dbsource, LocalDate startDate, LocalDate endDate) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.getTradeAggregateStats(startDate, endDate);
        } else {
            return aggregateRepository.getTradeAggregateStats(startDate, endDate);
        }
    }

    //    Fetch industry specific aggregated statistics from trade_info table using startDate and endDate
    public List<IndustryAggregateDTO> getIndustryStats(String dbsource, LocalDate startDate, LocalDate endDate) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.getIndustryAggregateStats(startDate, endDate);
        } else {
            return aggregateRepository.getIndustryAggregateStats(startDate, endDate);
        }
    }
}