package com.oocl.todolistapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cors")
public class CORSController {
    @GetMapping
    public String corsRequest() {
        return "cors testing success";
    }
}
