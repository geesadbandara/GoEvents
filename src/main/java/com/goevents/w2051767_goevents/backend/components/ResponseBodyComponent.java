package com.goevents.w2051767_goevents.backend.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResponseBodyComponent {
    int totalPool;
    String displayLog;
    @Autowired
    public ResponseBodyComponent(@Value("0") int totalTicketPool,@Value("Waiting..") String displayLog) {
        this.totalPool = totalTicketPool;
        this.displayLog = displayLog;
    }

    public int getTotalTicketPool() {
        return totalPool;
    }

    public void setTotalTicketPool(int totalTicketPool) {
        this.totalPool = totalTicketPool;
    }

    public String getDisplayLog() {
        return displayLog;
    }

    public void setDisplayLog(String displayLog) {
        this.displayLog = displayLog;
    }
}
