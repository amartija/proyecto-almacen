package com.ipartek.formacion.prenda;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Prenda;

@Stateless(name = "prendaServiceBean")
public class PrendaServiceBean implements PrendaServiceRemote {

	@PersistenceContext(name = "gestionalmacen")
	private EntityManager entityManager;

	public PrendaServiceBean() {

	}

	@Override
	public List<Prenda> getAll() {
		TypedQuery<Prenda> prendas = entityManager.createNamedQuery("prendas.getAll", Prenda.class);
		return prendas.getResultList();
	}

	@Override
	public Prenda getById(Long codigo) {

		Prenda prenda = entityManager.find(Prenda.class, codigo);

		return prenda;
	}

	@Override
	public Prenda update(Prenda prenda) {
		try {
			entityManager.merge(prenda);
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();
		}

		return prenda;
	}

	@Override
	public Prenda create(Prenda prenda) {
		try {
			entityManager.merge(prenda);
			// tx.commit();
			entityManager.flush();

		} catch (Exception e) {

			// tx.rollback();
		}

		return prenda;
	}

	@Override
	public void delete(long codigo) {
		try {
			entityManager.remove(entityManager.find(Prenda.class, codigo));
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();
		}

	}

}
