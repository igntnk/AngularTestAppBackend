package dev.vorsty;

import dev.vorsty.repositories.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VorstyApplication {

	private static Initializer initiator;

	@Autowired
	public void setinitialloader(Initializer initiator){
		VorstyApplication.initiator = initiator;
	}

	public static void main(String[] args) {
		SpringApplication.run(VorstyApplication.class, args);

		initiator.initial();
	}

}
