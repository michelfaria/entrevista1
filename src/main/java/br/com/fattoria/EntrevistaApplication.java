package br.com.fattoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.fattoria")
public class EntrevistaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntrevistaApplication.class, args);
    }
}
