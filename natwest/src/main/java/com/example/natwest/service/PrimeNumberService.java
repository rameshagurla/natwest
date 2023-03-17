package com.example.natwest.service;

import com.example.natwest.dto.PrimeNumberDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeNumberService {

    public PrimeNumberDto getPrimeNumbers(final int number) {
        PrimeNumberDto primeNumberDto = new PrimeNumberDto();
        primeNumberDto.setInitial(number);
        primeNumberDto.setPrimes(IntStream.rangeClosed(2, number)
                .filter(n -> checkIfPrime(n)).boxed()
                .collect(Collectors.toList()));
        return primeNumberDto;
    }

    private boolean checkIfPrime(final int number) {
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }
}
