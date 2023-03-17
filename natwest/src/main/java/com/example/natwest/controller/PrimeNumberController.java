package com.example.natwest.controller;

import com.example.natwest.dto.PrimeNumberDto;
import com.example.natwest.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class PrimeNumberController {

    @Autowired
    private PrimeNumberService primeNumberService;

    @GetMapping(value = "primes/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrimeNumberDto> getPrimeNumbers(@PathVariable int number) {
        return ResponseEntity.ok(primeNumberService.getPrimeNumbers(number));
    }
}
