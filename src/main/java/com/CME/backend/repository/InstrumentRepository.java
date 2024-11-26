package com.CME.backend.repository;

import com.CME.backend.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    // Fetch instrument data for a specific instrument ID from instrument table.
    Instrument findInstrumentInfoByInstrumentId(String instrumentId);
}
