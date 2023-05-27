package com.alura.jdbc.controller;


import java.util.List;

import com.alura.jdbc.DAO.CategoriaDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaController(){
		var factory = new ConnectionFactory();
		this.categoriaDAO = new CategoriaDAO(factory.Conecta());
	}
	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}

    public List<Categoria> cargaReporte() {

    	return this.categoriaDAO.listarConProductos();
    }

}
