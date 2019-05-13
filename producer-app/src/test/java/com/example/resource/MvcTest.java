package com.example.resource;

import com.example.producer.resource.HealthCheckResource;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

public class MvcTest {

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new HealthCheckResource());
    }
}
