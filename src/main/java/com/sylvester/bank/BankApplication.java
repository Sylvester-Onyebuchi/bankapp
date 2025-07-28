package com.sylvester.bank;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Java Bank App",
        description = "Backend Rest APIs for Banks",
        version = "v1.0",
        contact = @Contact(
                name = "Sylvester Onah",
                email = "sylvesteroyonah@gmail.com",
               url = "http://github.com/Sylvester-Onyebuchi/bank-app"
        )

))
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

}
