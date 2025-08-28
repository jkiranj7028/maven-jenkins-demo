package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    private static final DateTimeFormatter F = DateTimeFormatter.ISO_INSTANT;

    @GetMapping("/time")
    public String time() {
        return F.format(Instant.now());
    }
}
