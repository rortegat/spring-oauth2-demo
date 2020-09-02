package com.example.oauth2ClientDemo.schedule;

import com.example.oauth2ClientDemo.async.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleService {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    @Autowired
    AsyncService asyncService;

    //@Scheduled(fixedRate = 2000, initialDelay = 2000)
    @Scheduled(cron = "0/10 * 6-21 * * ?")
    public void scheduledTask(){
        log.info("Sent at: {}", dtf.format(LocalDateTime.now()));
        asyncService.requestMessage();
    }
}
