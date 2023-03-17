package com.example.natwest.serviceTest;

import com.example.natwest.dto.PrimeNumberDto;
import com.example.natwest.service.PrimeNumberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrimeNumberServiceTest {

    @InjectMocks
    PrimeNumberService primeNumberService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrimeNumbers_between1to10() {
        PrimeNumberDto primeNumberDtoService = primeNumberService.getPrimeNumbers(10);
        Assert.assertEquals(4, primeNumberDtoService.getPrimes().size());
        Assert.assertTrue(primeNumberDtoService.getPrimes().contains(3));
        Assert.assertFalse(primeNumberDtoService.getPrimes().contains(9)); // not prime
    }

    @Test
    public void testPrimeNumbers_between1to100() {
        PrimeNumberDto primeNumberDtoService = primeNumberService.getPrimeNumbers(100);
        Assert.assertEquals(25, primeNumberDtoService.getPrimes().size());
        Assert.assertTrue(primeNumberDtoService.getPrimes().contains(59));
        Assert.assertFalse(primeNumberDtoService.getPrimes().contains(27)); // not prime
    }
}
