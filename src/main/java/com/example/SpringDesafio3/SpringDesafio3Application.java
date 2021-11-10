package com.example.SpringDesafio3;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringDesafio3.Services.Cliente;
import com.example.SpringDesafio3.Services.ClienteInter;

@SpringBootApplication
public class SpringDesafio3Application implements CommandLineRunner {
	@Autowired
	private ClienteInter clienteInter;

	public static void main(String[] args) {
		SpringApplication.run(SpringDesafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Agregar datos prueba
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("JoséAntonio");
		cliente1.setApellido("Ramos Chamorro");
		cliente1.setFechaNacimiento(Date.valueOf("2021-01-01"));
		cliente1.setDni("123456789");
		clienteInter.insertar(cliente1);
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("José");
		cliente2.setApellido("Ramos ");
		cliente2.setFechaNacimiento(Date.valueOf("2021-01-01"));
		cliente2.setDni("176543289");
		clienteInter.insertar(cliente2);
		
		
	//listar todo
		clienteInter.listaTodo();

	}

}
