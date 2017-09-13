package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionController {
    @RequestMapping("/{msg}")
    public String toIndex(ModelMap map, @PathVariable String msg) {
        map.put("key", msg);
        return "index";
    }
}
