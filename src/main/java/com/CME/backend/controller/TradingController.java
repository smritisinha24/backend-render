package com.CME.backend.controller;

import com.CME.backend.dto.CombinedStockDataDTO;
import com.CME.backend.model.Instrument;
import com.CME.backend.model.StockData;
import com.CME.backend.model.TradeInfo;
import com.CME.backend.service.TradingService;
import com.CME.backend.util.PerformanceMetrics;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TradingController {
    @Autowired
    private TradingService tradingService;

    private PerformanceMetrics performanceMetrics = new PerformanceMetrics();
    private ObjectMapper objectMapper = new ObjectMapper();

    // Endpoint to fetch all stock data
    @GetMapping("/stocks")
    public ResponseEntity<Map<String, Object>> getAllStockData(@RequestParam String dbsource) {
        performanceMetrics.startSession();
        List<StockData> stockData = tradingService.getAllStockData(dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);
        Map<String, Object> response = new HashMap<>();
        response.put("data", stockData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific stock data by symbol
    @GetMapping("/stocks/{symbol}")
    public ResponseEntity<Map<String, Object>> getStockData(@PathVariable String symbol,
                                                            @RequestParam String dbsource) {
        performanceMetrics.startSession();
        StockData stockData = tradingService.getStockDataBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(stockData);
        performanceMetrics.endQuery(dataSize);
        Map<String, Object> response = new HashMap<>();
        response.put("data", stockData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific trade information for a symbol
    @GetMapping("/trades/{symbol}")
    public ResponseEntity<Map<String, Object>> getTradeInfo(@PathVariable String symbol,
                                                            @RequestParam String dbsource) {
        performanceMetrics.startSession();
        List<TradeInfo> tradeInfo = tradingService.getTradeInfoBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(tradeInfo);
        performanceMetrics.endQuery(dataSize);
        Map<String, Object> response = new HashMap<>();
        response.put("data", tradeInfo);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch specific instrument information for a symbol
    @GetMapping("/instruments/{instrumentId}")
    public ResponseEntity<Map<String, Object>> getInstrumentInfo(@PathVariable String instrumentId,
                                                                 @RequestParam String dbsource) {
        performanceMetrics.startSession();
        Instrument instrumentInfo = tradingService.getInstrumentById(instrumentId,dbsource);
        long dataSize = calculateDataSize(instrumentInfo);
        performanceMetrics.endQuery(dataSize);
        Map<String, Object> response = new HashMap<>();
        response.put("data", instrumentInfo);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Endpoint to fetch combined data for a symbol
    @GetMapping("/combined/{symbol}")
    public ResponseEntity<Map<String, Object>> getCombinedData(@PathVariable String symbol,
                                                               @RequestParam String dbsource) {
        performanceMetrics.startSession();
        List<CombinedStockDataDTO> combinedData = tradingService.getCombinedDataBySymbol(symbol, dbsource);
        long dataSize = calculateDataSize(combinedData);
        performanceMetrics.endQuery(dataSize);
        Map<String, Object> response = new HashMap<>();
        response.put("data", combinedData);
        response.put("performanceMetrics", getPerformanceMetrics());

        return ResponseEntity.ok(response);
    }

    // Method to calculate data size in bytes
    private long calculateDataSize(Object data) {
        try {
            return objectMapper.writeValueAsBytes(data).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Method to get performance metrics as a map and reset them
    private Map<String, Object> getPerformanceMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("readSpeed", performanceMetrics.getReadSpeed() + " ms");
        metrics.put("throughput", performanceMetrics.getThroughput() + " bytes/sec");
        performanceMetrics.resetMetrics();
        return metrics;
    }
}
