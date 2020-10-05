package com.softwarefoundation.fooddeliverypedidoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodDeliveryPedidoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryPedidoApiApplication.class, args);
	}

}
