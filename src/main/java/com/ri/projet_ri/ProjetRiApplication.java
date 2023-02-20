package com.ri.projet_ri;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class ProjetRiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetRiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("el");
		try {
			ProcessBuilder builder = new ProcessBuilder("python",
					System.getProperty("user.dir") + "\\PythonScripts\\script.py", "1", "4");
			Process process = builder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader readers = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			String lines = null;
			while ((lines=reader.readLine()) != null){
				System.out.println("lines "+lines);
			}

			while ((lines=readers.readLine()) != null){
				System.out.println("Error lines"+lines);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
