package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.DTO.ProductoDTO;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.IFacturaRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IFacturaRepository facturaRepository;

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void realizar(List<ProductoDTO> productos, String cedulaCliente) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		factura.setCedulaCliente(cedulaCliente);
//		factura.setDetalles(null);
		factura.setFecha(LocalDateTime.now());
//		factura.setId(null);
//		factura.setTotalFactura(null);

		List<DetalleFactura> detalles = new ArrayList<>();

		BigDecimal totalVentaParcial = new BigDecimal(0);
		productos.forEach(productoLista -> {
			Producto productoBd = this.productoRepository.seleccionarCodigoBarras(productoLista.getCodigoBarras());
			if (productoBd.getStock() >= productoLista.getCantidad()) {

				productoBd.setStock(productoBd.getStock() - productoLista.getCantidad());
				this.productoRepository.actualizar(productoBd);
				DetalleFactura detalle = new DetalleFactura();
				detalle.setCantidad(productoLista.getCantidad());
				detalle.setPrecioUnitario(productoBd.getPrecio());
				detalle.setSubtotal(productoBd.getStock() * productoLista.getCantidad());
				detalle.setFactura(factura);
				detalle.setProducto(productoBd);
				totalVentaParcial.add(new BigDecimal(detalle.getSubtotal()));
				detalles.add(detalle);
				factura.setDetalles(detalles);

			} else {
				throw new IllegalArgumentException("Stock no disponible");
			}
		});

		factura.setTotalFactura(totalVentaParcial);
		this.facturaRepository.insertar(factura);

	}

}
