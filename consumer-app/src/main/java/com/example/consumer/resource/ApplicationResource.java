package com.example.consumer.resource;

import com.example.consumer.service.HealthCheckClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ApplicationResource {

    private final HealthCheckClient client;

    public ApplicationResource(HealthCheckClient checkClient) {
        this.client = checkClient;
    }

    @RequestMapping("/provider-status")
    public String getProducerStatus() {
        return client.checkHealth();
    }

}
