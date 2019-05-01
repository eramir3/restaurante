package com.restaurante.lamejorcocina.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restaurante.lamejorcocina.entity.Camarero;

@Repository
public class CamareroDAOImpl implements CamareroDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CamareroDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Camarero> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Camarero> theQuery = currentSession.createQuery("from Camarero", Camarero.class);
		
		List<Camarero> camareros = theQuery.getResultList();
		
		return camareros;
	}

	@Override
	public Camarero findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Camarero theCamarero = currentSession.get(Camarero.class, theId);
		
		return theCamarero;
	}

	@Override
	public void save(Camarero theCamarero) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCamarero);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<?> theQuery = currentSession.createQuery("delete from Camarero where id=:camareroId");
		theQuery.setParameter("camareroId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Object> findByTotalFacturado() {
		
		Session currentSession = entityManager.unwrap(Session.class);
				
		Query<Object> theQuery = currentSession.createNativeQuery(FIND_BY_SAL_RNG);
				
		List<Object> camareros = theQuery.getResultList();
				
		return camareros;
	}

}
