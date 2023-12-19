package com.alidev.cashtrack.controller;

import com.alidev.cashtrack.service.RevenueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/revenues")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService){
        this.revenueService = revenueService;
    }
}
