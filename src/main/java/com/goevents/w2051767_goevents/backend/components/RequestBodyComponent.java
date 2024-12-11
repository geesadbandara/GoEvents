package com.goevents.w2051767_goevents.backend.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestBodyComponent {
    private int maxPool;
    private int totalPool;
    private int releaseRate;
    private int retrievalRate;

    @Autowired
    public RequestBodyComponent(@Value("0") int maxPool,@Value("0") int totalPool,@Value("0") int releaseRate,@Value("0") int retrievalRate) {
        this.maxPool = maxPool;
        this.totalPool = totalPool;
        this.releaseRate = releaseRate;
        this.retrievalRate = retrievalRate;
    }



    public int getMaxPool() {
        return maxPool;
    }

    public void setMaxPool(int maxPool) {
        this.maxPool = maxPool;
    }

    public int getTotalPool() {
        return totalPool;
    }

    public void setTotalPool(int totalPool) {
        this.totalPool = totalPool;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    @Override
    public String toString() {
        return "RequestBodyComponent{" +
                "maxPool=" + maxPool +
                ", totalPool=" + totalPool +
                ", releaseRate=" + releaseRate +
                ", retrievalRate=" + retrievalRate +
                '}';
    }
}
