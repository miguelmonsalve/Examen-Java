package com.pruebajse.persistencia;

import com.pruebajse.modelo.entidades.Colega;

public interface ColegaDao {
	
	int alta(Colega colega);
	void baja(Colega colega);
	void modificacion(Colega colega);	
	Colega consulta(int id);
	

}
