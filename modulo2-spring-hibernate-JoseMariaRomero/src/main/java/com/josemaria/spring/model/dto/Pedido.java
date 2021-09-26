package com.josemaria.spring.model.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

/**
 *
 * DTO para la tabla PEDIDOS de MySQL.
 * 
 */
@Entity
@Table(name="PEDIDOS")
public class Pedido {

	// DATOS DE PEDIDO
	@Id
	@Column(name="NUMERO_PEDIDO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(generator="secuencia3") 
	//@SequenceGenerator(name="secuencia3", sequenceName="NUMERO_PEDIDO", allocationSize=1)
	private Integer id;
	
	@Column(name="FECHA_PEDIDO")
	private Date fecha_pedido;
	
	@Column(name="PORTE_PEDIDO")
	private Double porte_pedido;
	
	@Column(name="SEGURO_PEDIDO")
	private Double seguro_pedido;
	
	@Column(name="OTROS_CARGOS_PEDIDO")
	private Double otros_cargos_pedido;
	
	@Column(name="TOTAL_CARGOS_PEDIDO")
	private Double total_cargos_pedido;
	
	@Column(name="TOTAL_BRUTO_PEDIDO")
	private Double total_bruto_pedido;
	
	@Column(name="PORCENTAJE_IVA_PEDIDO")
	private Integer porcentaje_iva_pedido;
	
	@Column(name="IVA_PEDIDO")
	private Double iva_pedido;
	
	@Column(name="TOTAL_FACTURA_PEDIDO")
	private Double total_factura_pedido;
	
	@Column(name="CODIGO_CLIENTE")
	private Integer codigo_cliente;

	// REPRESENTACION DE LA RELACION ENTRE PEDIDOS Y LINEA DE PEDIDOS
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="numero_pedido")
	private List<Linea_Pedido> lineas_pedido;

	// METODOS ACCESORES
	public List<Linea_Pedido> getLineas_pedido() {
		return lineas_pedido;
	}

	public void setLineas_pedido(List<Linea_Pedido> lineas_pedido) {
		this.lineas_pedido = lineas_pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Double getPorte_pedido() {
		return porte_pedido;
	}

	public void setPorte_pedido(Double porte_pedido) {
		this.porte_pedido = porte_pedido;
	}

	public Double getSeguro_pedido() {
		return seguro_pedido;
	}

	public void setSeguro_pedido(Double seguro_pedido) {
		this.seguro_pedido = seguro_pedido;
	}

	public Double getOtros_cargos_pedido() {
		return otros_cargos_pedido;
	}

	public void setOtros_cargos_pedido(Double otros_cargos_pedido) {
		this.otros_cargos_pedido = otros_cargos_pedido;
	}

	public Double getTotal_cargos_pedido() {
		return total_cargos_pedido;
	}

	public void setTotal_cargos_pedido(Double total_cargos_pedido) {
		this.total_cargos_pedido = total_cargos_pedido;
	}

	public Double getTotal_bruto_pedido() {
		return total_bruto_pedido;
	}

	public void setTotal_bruto_pedido(Double total_bruto_pedido) {
		this.total_bruto_pedido = total_bruto_pedido;
	}

	public Integer getPorcentaje_iva_pedido() {
		return porcentaje_iva_pedido;
	}

	public void setPorcentaje_iva_pedido(Integer porcentaje_iva_pedido) {
		this.porcentaje_iva_pedido = porcentaje_iva_pedido;
	}

	public Double getIva_pedido() {
		return iva_pedido;
	}

	public void setIva_pedido(Double iva_pedido) {
		this.iva_pedido = iva_pedido;
	}

	public Double getTotal_factura_pedido() {
		return total_factura_pedido;
	}

	public void setTotal_factura_pedido(Double total_factura_pedido) {
		this.total_factura_pedido = total_factura_pedido;
	}

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	@Override
	public String toString() {
		return "NUMERO_PEDIDO="+id+", FECHA_PEDIDO="+fecha_pedido;
	}

}
