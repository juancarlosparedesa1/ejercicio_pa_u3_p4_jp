package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoSerivice {

	@Autowired
	private IProductoRepository productoRepository;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void ingresar(Producto producto) {
		// TODO Auto-generated method stub

		Producto productoBd = this.productoRepository.seleccionarCodigoBarras(producto.getCodigoBarras());

		if (productoBd != null) {
			Integer nuevoStock = productoBd.getStock() + producto.getStock();
			if (nuevoStock > 0) {
				productoBd.setStock(nuevoStock);
				this.productoRepository.actualizar(productoBd);
			} else {
				throw new IllegalArgumentException("Stock negativo no se puede ingresar...");
			}
		} else {
			if (producto.getStock() > 0) {
				this.productoRepository.insertar(producto);
			} else {
				throw new IllegalArgumentException("Stock negativo no se puede ingresar...");

			}
		}

	}

}
