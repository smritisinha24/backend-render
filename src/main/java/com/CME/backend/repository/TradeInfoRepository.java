package com.CME.backend.repository;

import com.CME.backend.model.TradeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeInfoRepository extends JpaRepository<TradeInfo, String> {
    // Fetch trade information for a specific instrument ID from trade_info table.
    @Query(value = "SELECT * FROM trade_info WHERE instrument_id = :instrumentId", nativeQuery = true)
    List<TradeInfo> findTradeInfoByInstrumentId(String instrumentId);
}