package io.vertx.example;


import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Configuration
@RestController
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootVertxDemo {

    @Autowired
    private StaticServer staticServer;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootVertxDemo.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(staticServer);
    }

    @GetMapping("/")
    public ResponseEntity<String> myCustomCheck() {
        String message = "Testing my healh check function";
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
    }
}
