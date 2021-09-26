package com.josemaria.spring.model.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * DTO para la tabla ARTICULOS de MySQL.
 *
 */
@Entity
@Table(name="ARTICULOS")
public class Articulo {

	// PROPIEDADES DE CLASE
	@Id
	@Column(name="CODIGO_ARTICULO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(generator="secuencia1") 
	//@SequenceGenerator(name="secuencia1", sequenceName="CODIGO_ARTICULO", allocationSize=1)
	private Integer id;
	
    @Column(name="DESCRIPCION_ARTICULO")
	private String descripcion_articulo;
	
    @Column(name="PRECIO_UNIDAD_ARTICULO")
	private Double precio_unidad_articulo;

    // METODOS ACCESORES
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion_articulo;
	}

	public void setDescripcion(String descripcion_articulo) {
		this.descripcion_articulo = descripcion_articulo;
	}

	public double getPrecio() {
		return precio_unidad_articulo;
	}

	public void setPrecio(Double precio_unidad_articulo) {
		this.precio_unidad_articulo = precio_unidad_articulo;
	}
	
	@Override
	public String toString() {
		return "CODIGO_ARTICULO="+id+", DESCRIPCION_ARTICULO="+descripcion_articulo+", PRECIO_UNIDAD_ARTICULO="+precio_unidad_articulo;
	}
}
