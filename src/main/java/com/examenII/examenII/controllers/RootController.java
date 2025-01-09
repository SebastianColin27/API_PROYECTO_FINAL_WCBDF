package com.examenII.examenII.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("API Running - Access /api/v1/employees for endpoints");
    }

    @GetMapping("/error")
    public ResponseEntity<String> handleError() {
        return ResponseEntity.status(404).body("Page not found");
    }
}