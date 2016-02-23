package com.pruebajse.persistencia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import com.pruebajse.modelo.entidades.Colega;

public class TestMySqlColegaDao {

	@Test
	public void test() throws SQLException {

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/colegajdbc?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");

		// Datos de entrada
		Date fecha = new Date();
		Colega colega = new Colega("Joaquin", "Valencia", fecha);
		Colega otroColega = new Colega("Pepe", "Barcelona", fecha);
		MySqlColegaDao sut = new MySqlColegaDao(ds);

		// Ejecucion
		sut.baja(colega);
		sut.alta(colega);
		int idEsperadoColega = sut.getClaveTablaColegas() - 1;
		Colega colegaObtenido = sut.consultaPorId(idEsperadoColega);

		sut.baja(otroColega);
		sut.alta(otroColega);
		int idEsperadoOtroColega = sut.getClaveTablaColegas() - 1;
		Colega OtroColegaObtenido = sut.consultaPorId(idEsperadoOtroColega);

		try {
			// Asertos
			assertEquals(idEsperadoColega, colegaObtenido.getId());
			assertEquals(idEsperadoOtroColega, OtroColegaObtenido.getId());
			assertEquals(colega.getNombre(), colegaObtenido.getNombre());
			assertEquals(colega.getCiudad(), colegaObtenido.getCiudad());
			assertEquals(colega.getNombre(), colegaObtenido.getNombre());
		} catch (Exception e) {
			fail("Se produce un error y no deberia");
		}

	}
}
