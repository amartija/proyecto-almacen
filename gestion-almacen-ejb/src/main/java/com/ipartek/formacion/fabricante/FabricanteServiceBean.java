package com.ipartek.formacion.fabricante;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Fabricante;

@Stateless(name = "fabricanteServiceBean")
public class FabricanteServiceBean implements FabricanteServiceRemote {

	@PersistenceContext(name = "gestionalmacen")
	private EntityManager entityManager;

	public FabricanteServiceBean() {

	}

	@Override
	public List<Fabricante> getAll() {

		TypedQuery<Fabricante> fabricantes = entityManager.createNamedQuery("fabricante.getAll", Fabricante.class);
		return fabricantes.getResultList();
	}

	@Override
	public Fabricante getById(Long codigo) {

		Fabricante fabricante = entityManager.find(Fabricante.class, codigo);

		return fabricante;
	}

	@Override
	public Fabricante update(Fabricante fabricante) {
		try {
			entityManager.merge(fabricante);
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();
		}

		return fabricante;
	}

	@Override
	public Fabricante create(Fabricante fabricante) {
		try {
			entityManager.merge(fabricante);
			// tx.commit();
			entityManager.flush();

		} catch (Exception e) {

			// tx.rollback();
		}

		return fabricante;
	}

	@Override
	public void delete(long codigo) {

		try {
			entityManager.remove(entityManager.find(Fabricante.class, codigo));
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();

		}
	}

}
