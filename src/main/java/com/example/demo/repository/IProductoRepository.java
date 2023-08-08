package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);

	public Producto seleccionarCodigoBarras(String codigoBarras);

	public void actualizar(Producto producto);
}
