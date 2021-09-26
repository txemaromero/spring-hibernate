package com.josemaria.spring.model.dao;

import java.util.List;

import com.josemaria.spring.model.dto.Linea_Pedido;

public interface Linea_PedidoDAO {

	public void addLinea_Pedido(Linea_Pedido l);
	public void updateLinea_Pedido(Linea_Pedido l);
	public List<Linea_Pedido> listLineas_Pedido();
	public void removeLinea_Pedido(long id);
}
