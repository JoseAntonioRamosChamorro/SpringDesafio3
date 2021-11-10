package com.example.SpringDesafio3.Services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClienteImplemen implements ClienteInter {
	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		Session session = entityManager.unwrap(Session.class);

		session.save(cliente);
		session.close();

	}
	@Override
	public List<Cliente> listaTodo() {
		 Session session = entityManager.unwrap(Session.class);
    ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) session.createQuery("FROM Cliente").list();
        System.out.println("Listar todos");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("Nombre: " + listaClientes.get(i).getNombre() 
            		+ " Apellidos: " + listaClientes.get(i).getApellido());
        }

		session.close();
		return listaClientes;
	}
}
