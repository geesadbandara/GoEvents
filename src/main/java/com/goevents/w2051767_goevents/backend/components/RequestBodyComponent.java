package com.goevents.w2051767_goevents.backend.components;

public class RequestBodyComponent {
    private int maxTicketPool;
    private int totalTicketPool;
    private int releaseRate;
    private int retrievalRate;

   public RequestBodyComponent(){

   }

    public int getMaxTicketPool() {
        return maxTicketPool;
    }

    public void setMaxTicketPool(int maxTicketPool) {
        this.maxTicketPool = maxTicketPool;
    }

    public int getTotalTicketPool() {
        return totalTicketPool;
    }

    public void setTotalTicketPool(int totalTicketPool) {
        this.totalTicketPool = totalTicketPool;
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
}
