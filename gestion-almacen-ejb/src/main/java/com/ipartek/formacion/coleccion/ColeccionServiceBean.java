package com.ipartek.formacion.coleccion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ipartek.formacion.persistence.Coleccion;

@Stateless(name = "coleccionServiceBean")
public class ColeccionServiceBean implements ColeccionServiceRemote {

	@PersistenceContext(name = "gestionalmacen")
	private EntityManager entityManager;

	public ColeccionServiceBean() {

	}

	@Override
	public List<Coleccion> getAll() {
		TypedQuery<Coleccion> colecciones = entityManager.createNamedQuery("coleccion.getAll", Coleccion.class);
		return colecciones.getResultList();
	}

	@Override
	public Coleccion getById(Long codigo) {

		Coleccion coleccion = entityManager.find(Coleccion.class, codigo);

		return coleccion;
	}

	@Override
	public Coleccion update(Coleccion coleccion) {

		try {
			entityManager.merge(coleccion);
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();
		}

		return coleccion;
	}

	@Override
	public Coleccion create(Coleccion coleccion) {
		try {
			coleccion = entityManager.merge(coleccion);
			// tx.commit();
			// entityManager.flush();

		} catch (Exception e) {

			// tx.rollback();
		}

		return coleccion;
	}

	@Override
	public void delete(long codigo) {
		try {
			entityManager.remove(entityManager.find(Coleccion.class, codigo));
			// tx.commit();

		} catch (Exception e) {

			// tx.rollback();
		}
	}

}
