package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.DTO.ProductoDTO;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoSerivice;

@SpringBootApplication
public class EjercicioPaU3P4EcApplication implements CommandLineRunner {

	@Autowired
	private IProductoSerivice productoSerivice;
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4EcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		a) Insertar desde la clase principal 2
//		Productos (por dos ocasiones cada producto)

		Producto producto1 = new Producto();
		producto1.setCategoria("tos");
		producto1.setCodigoBarras("t0001");
		producto1.setNombre("flumin");
		producto1.setPrecio(new BigDecimal(100));
		producto1.setStock(500);

		Producto producto2 = new Producto();
		producto2.setCategoria("tos");
		producto2.setCodigoBarras("t0002");
		producto2.setNombre("Tempra");
		producto2.setPrecio(new BigDecimal(200));
		producto2.setStock(500);
//
//		this.productoSerivice.ingresar(producto1);
//		this.productoSerivice.ingresar(producto1);
//		this.productoSerivice.ingresar(producto2);
//		this.productoSerivice.ingresar(producto2);

//		b) Desde la clase principal realizar 1
//		factura con al menos 2 productos.

		ProductoDTO productoDTO1 = new ProductoDTO();
		productoDTO1.setCantidad(200);
		productoDTO1.setCodigoBarras("t0001");

		ProductoDTO productoDTO2 = new ProductoDTO();
		productoDTO1.setCantidad(400);
		productoDTO1.setCodigoBarras("t0002");

		List<ProductoDTO> productosVenta = new ArrayList<>();

		this.facturaService.realizar(productosVenta, "1726897200");

	}

}
