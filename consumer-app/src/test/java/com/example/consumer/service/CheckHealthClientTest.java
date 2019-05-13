package com.example.consumer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureStubRunner(
        ids = "com.example:producer-app:+:stubs",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CheckHealthClientTest {

    @Autowired
    private Environment environment;

    /**
     * https://github.com/spring-cloud/spring-cloud-contract/issues/147
     *
     * stubrunner.runningstubs.<artifact-name>.port
     */
    @Test
    public void shouldReturnUp() {

        String port = environment.getProperty("stubrunner.runningstubs.producer-app.port");

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject("http://localhost:" +port + "/producer/health", String.class);

        assertEquals("UP", response);
    }
}