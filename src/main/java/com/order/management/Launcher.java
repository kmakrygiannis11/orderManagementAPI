package com.order.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication(scanBasePackages = "com.order.management")
public class Launcher {

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
	
	@GetMapping("/")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Welcome to "+ appName +" !");
	}

}
