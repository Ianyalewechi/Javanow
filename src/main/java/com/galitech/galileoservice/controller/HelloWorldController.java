package com.galitech.galileoservice.controller;

import com.galitech.galileoservice.domain.PersonRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String postMessage(@RequestBody PersonRequest request) {
        return "My name is " + request.getName() + " and my occupation is " + request.getOccupation() + ", my age is  " + request.getAge();
    }

    @PostMapping(value = "/messageRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRequest> postMessageRequest(@RequestBody PersonRequest request) {
        return ResponseEntity.ok(request);
    }
}
