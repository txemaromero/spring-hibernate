package com.josemaria.spring.model.dao;

import java.util.List;

import com.josemaria.spring.model.dto.Articulo;

public interface ArticuloDAO {

	public void addArticulo(Articulo a);
	public void updateArticulo(Articulo a);
	public List<Articulo> listArticulos();
	public void removeArticulo(int id);
}
