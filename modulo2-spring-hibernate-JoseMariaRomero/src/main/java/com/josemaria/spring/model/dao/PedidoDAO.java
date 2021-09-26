package com.josemaria.spring.model.dao;

import java.util.List;

import com.josemaria.spring.model.dto.Pedido;

public interface PedidoDAO {

	public void addPedido(Pedido p);
	public void updatePedido(Pedido p);
	public List<Pedido> listPedidos();
	public void removePedido(int id);
}
