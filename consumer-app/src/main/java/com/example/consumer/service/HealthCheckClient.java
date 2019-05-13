package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "check-health-client", url = "http://localhost:8082/producer")
public interface HealthCheckClient {

    @GetMapping("health")
    String checkHealth();

}
