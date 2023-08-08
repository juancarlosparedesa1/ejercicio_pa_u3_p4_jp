package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_Factura")
public class DetalleFactura {
	@Id
	// Secuencias
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_factura")
	@SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura", allocationSize = 1)
	@Column(name = "dtlf_id")
	private Integer id;
	@Column(name = "dtlf_cantidad")
	private Integer cantidad;
	@Column(name = "dtlf_precio_unitario")
	private BigDecimal precioUnitario;
	@Column(name = "dtl_subtotal")
	private Integer subtotal;
	// relaciones(hija)
	@ManyToOne
	@JoinColumn(name = "det_id_factura")
	private Factura factura;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "det_id_Producto")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
