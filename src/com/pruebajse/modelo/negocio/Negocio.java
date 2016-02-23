package com.pruebajse.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;

import com.pruebajse.modelo.entidades.Colega;
import com.pruebajse.persistencia.ColegaDao;

public class Negocio implements NegocioInterface {

	private ColegaDao colegaDao;

	public Negocio(ColegaDao colegaDao) {
		super();
		this.colegaDao = colegaDao;
	}

	@Override
	public int registroDeColega(Colega colega) throws SQLException {
		return colegaDao.alta(colega);
	}

	@Override
	public void bajaDeColega(Colega colega) throws SQLException {
		colegaDao.baja(colega);

	}

	@Override
	public void modificarColega(Colega colega) throws SQLException {
		colegaDao.modificacion(colega);

	}

	@Override
	public Colega consultarColegaPorId(int id) throws SQLException {
		return colegaDao.consultaPorId(id);
	}

	@Override
	public Collection<Colega> verTodosLosColegas() throws SQLException {
		return colegaDao.consultarTodos();
	}

}
