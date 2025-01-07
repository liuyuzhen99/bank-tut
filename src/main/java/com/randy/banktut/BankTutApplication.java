package com.randy.banktut;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "The Java Bank tutorial application",
                description = "Backend Rest APIs for bank-tut",
                version = "v1.0",
                contact = @Contact(
                        name = "Randy Liu",
                        email = "liuyuzhenbmjt@gmail.com",
                        url = "https://github.com/liuyuzhen99/bank-tut"
                ),
                license = @License(
                        name = "Randy Liu",
                        url = "https://github.com/liuyuzhen99/bank-tut"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "The Java Bank tutorial App Documentation",
                url = "https://github.com/liuyuzhen99/bank-tut"
        )
)
public class BankTutApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankTutApplication.class, args);
    }

}
