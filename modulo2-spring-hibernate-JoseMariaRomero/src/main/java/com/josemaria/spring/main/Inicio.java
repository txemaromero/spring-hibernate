package com.josemaria.spring.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.josemaria.spring.model.dto.Articulo;
import com.josemaria.spring.model.dto.Linea_Pedido;
import com.josemaria.spring.model.dto.Pedido;

import com.josemaria.spring.model.dao.ArticuloDAO;
import com.josemaria.spring.model.dao.Linea_PedidoDAO;
import com.josemaria.spring.model.dao.PedidoDAO;

/**
 *
 * Main del proceso CRUD (alta, baja, modificación y consultas).
 * 
 */
public class Inicio {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ArticuloDAO articuloDAO = context.getBean(ArticuloDAO.class);
		Linea_PedidoDAO linea_PedidoDAO = context.getBean(Linea_PedidoDAO.class);
		PedidoDAO pedidoDAO = context.getBean(PedidoDAO.class);
		
		Articulo articulo = new Articulo();
		articulo.setDescripcion("Libro La tabla de Flandes");
		articulo.setPrecio(9.45);
		System.out.println("\nCRUD operation #1: Article: add #1 ...\n");
		articuloDAO.addArticulo(articulo);
		
		Articulo articulo2 = new Articulo();
		articulo2.setDescripcion("Libro El capitán Alatriste");
		articulo2.setPrecio(18.90);
		System.out.println("\nCRUD operation #2: Article: add #2 ...\n");
		articuloDAO.addArticulo(articulo2);
		
		Articulo articulo3 = new Articulo();
		articulo3.setDescripcion("Libro El club Dumas");
		articulo3.setPrecio(20.50);
		System.out.println("\nCRUD operation #3: Article: add #3 ...\n");
		articuloDAO.addArticulo(articulo3);

		System.out.println("\nCRUD operation #4: Article: consults ...\n");
		List<Articulo> list = articuloDAO.listArticulos();
		for (Articulo a : list) {
			System.out.println("Article list:"+a);
		}
		
		System.out.println("\nCRUD operation #5: Article: modification #1 ...\n");
		articulo.setPrecio(9.45);
		articuloDAO.updateArticulo(articulo);
		
		System.out.println("\nCRUD operation #6: Article: delete #3 ...\n");
		articuloDAO.removeArticulo(articulo3.getId());
		
		// DATOS DEL PEDIDO
		Pedido pedido_nuevo = new Pedido();
		pedido_nuevo.setFecha_pedido(new Date());
		pedido_nuevo.setTotal_factura_pedido(new Double(10151));
		pedido_nuevo.setCodigo_cliente(new Integer(8));
		System.out.println("\nCRUD operation #7: Pedido: add ...\n");
		pedidoDAO.addPedido(pedido_nuevo);
		// DATOS DE LAS LINEAS DE PEDIDO
		List<Linea_Pedido> lineas = new ArrayList<>();
		Linea_Pedido linea_nueva = new Linea_Pedido();
		linea_nueva.setNumero_pedido(pedido_nuevo.getId());
		linea_nueva.setCodigo_articulo(articulo.getId());
		System.out.println("\nCRUD operation #8: Linea_Pedido: add #1 ...\n");
		linea_PedidoDAO.addLinea_Pedido(linea_nueva);
		lineas.add(linea_nueva);
		
		linea_nueva = new Linea_Pedido();
		linea_nueva.setNumero_pedido(pedido_nuevo.getId());
		linea_nueva.setCodigo_articulo(articulo2.getId());
		System.out.println("\nCRUD operation #9: Linea_Pedido: add #2 ...\n");
		linea_PedidoDAO.addLinea_Pedido(linea_nueva);
		lineas.add(linea_nueva);
		
		System.out.println("\nCRUD operation #10: Linea_Pedido: consults ...\n");
		List<Linea_Pedido> list2 = linea_PedidoDAO.listLineas_Pedido();
		for(Linea_Pedido l : list2) {
			System.out.println("Linea_Pedido list:"+l);
		}
		
		// PASO LAS LINEAS DE PEDIDO AL PEDIDO NUEVO
		pedido_nuevo.setLineas_pedido(lineas);
		
		System.out.println("\nCRUD operation #11: Pedido: modification ...\n");
		pedidoDAO.updatePedido(pedido_nuevo);
		
		System.out.println("\nCRUD operation #12: Pedido: consults ...\n");
		List<Pedido> list3 = pedidoDAO.listPedidos();
		for(Pedido p : list3){
			System.out.println("Pedido list:"+p);
			List<Linea_Pedido> list4 = p.getLineas_pedido();
			for(Linea_Pedido l : list4) {
				System.out.println("Its Linea_Pedido list:"+l);
			}
		}
				
		context.close();
		
	}

}
