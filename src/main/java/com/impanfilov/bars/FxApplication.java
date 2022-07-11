package com.impanfilov.bars;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()
public class FxApplication {

    public static void main(String[] args) {
        javafx.application.Application.launch(JavaFxApplication.class, args);
    }

}

