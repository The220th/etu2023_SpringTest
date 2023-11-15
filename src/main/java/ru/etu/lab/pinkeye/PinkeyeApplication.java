package ru.etu.lab.pinkeye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PinkeyeApplication
{
	/**
	 * http://127.0.0.1:8080/hospital/pinkeye/patient_id
	 * */

	public static void main(String[] args) {
		SpringApplication.run(PinkeyeApplication.class, args);
	}

}
