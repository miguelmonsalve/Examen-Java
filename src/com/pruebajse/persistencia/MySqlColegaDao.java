package com.pruebajse.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import com.pruebajse.modelo.entidades.Colega;

public class MySqlColegaDao implements ColegaDao {

	private static final String INSERT_COLEGA = "INSERT INTO colega (id,nombre,ciudad,fecha) " + "VALUES (?,?,?,?)";
	private static final String BORRAR_COLEGA = "DELETE FROM colega WHERE id = ?";
	private static final String UPDATE_COLEGA = "UPDATE colega SET nombre=?, ciudad = ?, fecha = ? WHERE id = ?";
	private static final String SELECT_COLEGA_BY_ID = "SELECT * FROM colega WHERE id=?";
	private static final String SELECT_COLEGA = "SELECT * FROM colega";
	private DataSource ds;

	public MySqlColegaDao(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public int alta(Colega colega) throws SQLException {

		Connection connection = null;

		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4, colega.getFecha());
			ps.executeUpdate();

		} finally {
			if (connection != null)
				connection.close();
		}

		return colega.getId();
	}

	@Override
	public void baja(Colega colega) throws SQLException {

		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(BORRAR_COLEGA);
			ps.setInt(1, colega.getId());
			ps.executeUpdate();

		} finally {
			if (connection != null)
				connection.close();
		}

	}

	@Override
	public void modificacion(Colega colega) throws SQLException {

		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_COLEGA);
			ps.setInt(4, colega.getId());
			ps.setString(1, colega.getNombre());
			ps.setString(2, colega.getCiudad());
			ps.setDate(3, colega.getFecha());
			ps.executeUpdate();

		} finally {
			if (connection != null)
				connection.close();
		}

	}

	@Override
	public Colega consultaPorId(int id) throws SQLException {

		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				return new Colega(id, rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));
			}
			return null; 

		} finally {
			if (connection != null)
				connection.close();
		}

	}

	@Override
	public Collection<Colega> consultarTodos() throws SQLException {
		Collection<Colega> resultado = new HashSet<>();

		Connection connection = null;

		try {

			connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				do {
					resultado.add(new Colega(rs.getInt("id"), rs.getString("nombre"), rs.getString("ciudad"),
							rs.getDate("fecha")));

				} while (rs.next());

			}
			return resultado;

		} finally {
			if (connection != null)
				connection.close();
		}

	}
}
