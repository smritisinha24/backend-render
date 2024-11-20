package com.CME.backend.service;

import com.CME.backend.dto.AggregateFunctionDTO;
import com.CME.backend.dto.CombinedStockDataDTO;
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


    private void validateDbSource(String dbsource) {
        if (!"clickhouse".equalsIgnoreCase(dbsource) && !"postgres".equalsIgnoreCase(dbsource)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid dbsource parameter. Use 'clickhouse' or 'postgres'."
            );
        }
    }

    // Fetch all stocks data
    public List<StockData> getAllStockData(String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findAllStockData();
        }
        return stockDataRepository.findAll();
    }

    // Fetch specific stock data using symbol
    public StockData getStockDataBySymbol(String symbol, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findStockDataBySymbol(symbol);
        }
        return stockDataRepository.findBySymbolIgnoreCase(symbol);
    }

    // Fetch specific trade info using symbol
    public List<TradeInfo> getTradeInfoBySymbol(String symbol, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findTradeInfoBySymbol(symbol);
        } else {
            return tradeInfoRepository.findTradeInfo(symbol);
        }
    }

    // Fetch specific instrument info using symbol
    public Instrument getInstrumentById(String instrumentId, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findInstrumentByInstrumentId(instrumentId);
        }
        else {
            return instrumentRepository.findByInstrumentIdIgnoreCase(instrumentId);
        }
    }

    // Fetch combined data for a specific symbol
    public List<CombinedStockDataDTO> getCombinedDataBySymbol(String symbol, String dbsource) {
        validateDbSource(dbsource);

        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.findCombinedDataBySymbol(symbol);
        } else {
            return combinedDataRepository.getCombinedDataBySymbol(symbol);
        }
    }

    public List<AggregateFunctionDTO> getTradeStats(String dbsource, LocalDate startDate, LocalDate endDate) {
        if ("clickhouse".equalsIgnoreCase(dbsource)) {
            return clickhouseRepository.getAggregateTradeStats(startDate, endDate);
        } else if ("postgres".equalsIgnoreCase(dbsource)) {
            return aggregateRepository.getAggregateTradeStats(startDate, endDate);
        } else {
            throw new IllegalArgumentException("Invalid dbsource. Use 'clickhouse' or 'postgres'.");
        }
    }}
