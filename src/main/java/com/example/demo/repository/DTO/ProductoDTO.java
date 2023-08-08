package com.example.demo.repository.DTO;

public class ProductoDTO {

	private String codigoBarras;
	private Integer cantidad;

	public ProductoDTO() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductoDTO [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}

}
