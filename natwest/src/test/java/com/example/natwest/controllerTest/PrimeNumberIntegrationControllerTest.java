package com.example.natwest.controllerTest;

import com.example.natwest.controller.PrimeNumberController;
import com.example.natwest.dto.PrimeNumberDto;
import com.example.natwest.service.PrimeNumberService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(PrimeNumberController.class)
public class PrimeNumberIntegrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrimeNumberService primeNumberService;

    @Test
    void shouldgetPrimeNumbers_between1and10() throws Exception {
        BDDMockito.given(this.primeNumberService.getPrimeNumbers(10))
                .willReturn(new PrimeNumberDto(10, Arrays.asList(2,3,5,7)));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.initial").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[0]").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[1]").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[2]").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[3]").value(7));
    }

    @Test
    void shouldgetPrimeNumbers_between1and20() throws Exception {
        BDDMockito.given(this.primeNumberService.getPrimeNumbers(20))
                .willReturn(new PrimeNumberDto(20, Arrays.asList(2,3,5,7,11,13,17,19)));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/primes/20"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.initial").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[0]").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[1]").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[2]").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[3]").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[4]").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[5]").value(13))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[6]").value(17))
                .andExpect(MockMvcResultMatchers.jsonPath("$.primes[7]").value(19));
    }
}
