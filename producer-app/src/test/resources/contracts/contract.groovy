org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/producer/health'
    }
    response {
        status 200
        body("UP")
    }
}