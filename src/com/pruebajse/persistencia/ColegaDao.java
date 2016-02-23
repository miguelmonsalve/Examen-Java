package com.pruebajse.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.pruebajse.modelo.entidades.Colega;

public interface ColegaDao {

	int alta(Colega colega) throws SQLException;

	void baja(Colega colega) throws SQLException;

	void modificacion(Colega colega) throws SQLException;

	Colega consultaPorId(int id) throws SQLException;

	Collection<Colega> consultarTodos() throws SQLException;

}
