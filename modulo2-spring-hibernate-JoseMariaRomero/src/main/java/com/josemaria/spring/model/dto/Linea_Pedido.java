package com.josemaria.spring.model.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * DTO para la tabla LINEA_PEDIDO de MySQL.
 * 
 */
@Entity
@Table(name="LINEA_PEDIDO")
public class Linea_Pedido {

	// PROPIEDADES DE CLASE
	@Id
	@Column(name="CODIGO_LINEA_PEDIDO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(generator="secuencia2") 
	//@SequenceGenerator(name="secuencia2", sequenceName="NUM_LINEA_PEDIDO", allocationSize=1)
	private Long id;
	
	@Column(name="CODIGO_ARTICULO")
	private Integer codigo_articulo;
	
	@Column(name="NUMERO_PEDIDO")
	private Integer numero_pedido;
	
	@Column(name="PRECIO_UNIDAD_ARTICULO")
	private Double precio_unidad_articulo;
	
	@Column(name="NUMERO_UNIDADES_ARTICULO")
	private Integer numero_unidades_articulo;
	
	@Column(name="PORCENTAJE_DESCUENTO")
	private Float porcentaje_descuento;

	// METODOS ACCESORES
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(Integer codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public Integer getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public Double getPrecio_unidad_articulo() {
		return precio_unidad_articulo;
	}

	public void setPrecio_unidad_articulo(Double precio_unidad_articulo) {
		this.precio_unidad_articulo = precio_unidad_articulo;
	}

	public Integer getNumero_unidades_articulo() {
		return numero_unidades_articulo;
	}

	public void setNumero_unidades_articulo(Integer numero_unidades_articulo) {
		this.numero_unidades_articulo = numero_unidades_articulo;
	}

	public Float getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Float porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	
	@Override
	public String toString() {
		return "CODIGO_LINEA_PEDIDO="+id+", NUMERO_PEDIDO="+numero_pedido+", CODIGO_ARTICULO="+codigo_articulo;
	}

}
