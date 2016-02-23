package com.pruebajse.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.pruebajse.modelo.entidades.Colega;

public interface NegocioInterface {
	
	int registroDeColega(Colega colega) throws SQLException;
	void bajaDeColega(Colega colega) throws SQLException;
	void modificarColega(Colega colega) throws SQLException;
	Colega consultarColegaPorId(int id) throws SQLException;
	Collection<Colega> verTodosLosColegas() throws SQLException;
	
}
