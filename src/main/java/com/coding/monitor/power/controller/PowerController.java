package com.coding.monitor.power.controller;

import com.coding.monitor.power.service.PowerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guanweiming
 */
@RequestMapping("power")
@RestController
public class PowerController {
    private final PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @GetMapping("monitor")
    public String monitor(
            @RequestParam(defaultValue = "6640404", required = false) String orgNo,
            @RequestParam(defaultValue = "66103", required = false) String provinceNo) {
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return powerService.check(orgNo,provinceNo,dateStr,dateStr);
    }
}
