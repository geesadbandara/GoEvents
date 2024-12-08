package com.goevents.w2051767_goevents.backend.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfigComponent {
    protected static int maxTicketPoolSize;
    protected static int totalTicketPool;
    protected static int ticketRetrievalRate;
    protected static int ticketReleaseRate;

    @Autowired
    public SystemConfigComponent(@Value("0") int maxTicketPoolSize,@Value("0") int totalTicketPool,@Value("0") int ticketRetrievalRate,@Value("0") int ticketReleaseRate) {
        SystemConfigComponent.maxTicketPoolSize = maxTicketPoolSize;
        SystemConfigComponent.totalTicketPool = totalTicketPool;
        SystemConfigComponent.ticketRetrievalRate = ticketRetrievalRate;
        SystemConfigComponent.ticketReleaseRate = ticketReleaseRate;

    }

    public static int getMaxTicketPoolSize() {
        return maxTicketPoolSize;
    }

    public static void setMaxTicketPoolSize(int maxTicketPoolSize) {
        SystemConfigComponent.maxTicketPoolSize = maxTicketPoolSize;
    }

    public static int getTotalTicketPool() {
        return totalTicketPool;
    }

    public static void setTotalTicketPool(int totalTicketPool) {
        SystemConfigComponent.totalTicketPool = totalTicketPool;
    }

    public static int getTicketRetrievalRate() {
        return ticketRetrievalRate;
    }

    public static void setTicketRetrievalRate(int ticketRetrievalRate) {
        SystemConfigComponent.ticketRetrievalRate = ticketRetrievalRate;
    }

    public static int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public static void setTicketReleaseRate(int ticketReleaseRate) {
        SystemConfigComponent.ticketReleaseRate = ticketReleaseRate;
    }
}
