package com.ipartek.formacion.persistence.coleccion;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ipartek.formacion.coleccion.ColeccionServiceBean;
import com.ipartek.formacion.coleccion.ColeccionServiceRemote;
import com.ipartek.formacion.persistence.Coleccion;
import com.ipartek.formacion.persistence.Fabricante;
import com.ipartek.formacion.persistence.Prenda;

@RunWith(Arquillian.class)
public class ColeccionServiceBeanTest {

	@Deployment
	public static Archive<?> createDeployment() {
		// importa el archvio de pom.xml
		File[] files = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().resolve()
				.withTransitivity().asFile();

		WebArchive wa = ShrinkWrap.create(WebArchive.class, "test.war").addClass(Coleccion.class)
				.addPackage(Coleccion.class.getPackage()).addClass(ColeccionServiceBean.class)
				.addClass(ColeccionServiceRemote.class).addClass(Fabricante.class).addClass(Prenda.class)
				.addAsLibraries(files).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

		return wa;

	}

	@EJB
	ColeccionServiceRemote cs;

	Coleccion coleccion;

	@Test
	public void testIsDeployed() {
		assertNotNull(cs);
	}

	@Test
	public void getByIdTest() {
		long i = 1;

		assertNotNull("el codigo: " + i + " no tiene coleccion", cs.getById(i));

	}

	@Test
	public void getAllTest() {

		assertNotNull("la lista de colecciones esat vacia", cs.getAll());
	}

}
