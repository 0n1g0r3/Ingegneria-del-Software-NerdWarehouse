package com.example.NerdWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class NerdWarehouseApplication {

	public static void main(String[] args) {

		SpringApplication.run(NerdWarehouseApplication.class, args);
		System.out.println("Swagger documentation is running at: http://localhost:8010/swagger-ui/index.html");

	}

}
