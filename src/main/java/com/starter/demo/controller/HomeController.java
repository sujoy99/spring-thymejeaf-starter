package com.starter.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HomeController {
    private static final Logger LOG =   LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/hi")
    public String home() {
        LOG.info("SJ :: ---GET Controller---");
        LOG.warn("SJ :: -- WARN");
        LOG.trace("SJ :: -- TRACE");
        LOG.error("SJ :: -- ERROR");
        LOG.debug("SJ :: -- DEBUG");
        return "hi";
    }
}
