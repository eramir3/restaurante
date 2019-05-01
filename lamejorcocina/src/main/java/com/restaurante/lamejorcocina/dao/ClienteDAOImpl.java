package com.restaurante.lamejorcocina.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	private EntityManager entityManager;

	@Autowired
	public ClienteDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Cliente> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Cliente> theQuery = currentSession.createQuery("from Cliente", Cliente.class);
		
		List<Cliente> clientes = theQuery.getResultList();
		
		return clientes;
	}

	@Override
	public Cliente findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Cliente theCliente = currentSession.get(Cliente.class, theId);
		
		return theCliente;
	}

	@Override
	public void save(Cliente theCliente) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCliente);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Cliente where id=:clienteId");
		theQuery.setParameter("clienteId", theId);
		theQuery.executeUpdate();
	}
	
	@Override
	public List<Object> findByImporteTotal() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createNativeQuery(FIND_BY_SAL_RNG);
		
		List<Object> detalleFactura = theQuery.getResultList();
		
		return detalleFactura;
	}

}
