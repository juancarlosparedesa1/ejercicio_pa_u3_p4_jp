package com.example.demo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	private static final Logger LOG = LoggerFactory.getLogger(ProductoRepositoryImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Producto seleccionarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:datoCodigoBarras", Producto.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			LOG.info("producto no encontrado");
			return null;
		}

	}

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);

	}

}
