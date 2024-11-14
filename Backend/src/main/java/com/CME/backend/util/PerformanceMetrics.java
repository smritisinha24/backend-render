package com.CME.backend.util;

public class PerformanceMetrics {
    private long startTime;
    private long endTime;
    private int queryCount;
    private long totalBytesProcessed;

    public void startSession() {
        this.startTime = System.currentTimeMillis();
        this.queryCount = 0;
        this.totalBytesProcessed = 0;
    }

    public void endQuery(long dataSizeInBytes) {
        this.endTime = System.currentTimeMillis();
        this.queryCount++;
        this.totalBytesProcessed += dataSizeInBytes;
    }

    public long getReadSpeed() {
        return endTime - startTime;
    }

    public double getThroughput() {
        long elapsedTimeInMillis = endTime - startTime;
        return (elapsedTimeInMillis > 0) ? (double) totalBytesProcessed / (elapsedTimeInMillis / 1000.0) : 0;
    }

    public void resetMetrics() {
        this.startTime = 0;
        this.endTime = 0;
        this.queryCount = 0;
        this.totalBytesProcessed = 0;
    }
}
