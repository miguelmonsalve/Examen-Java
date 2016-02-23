package com.pruebajse.modelo.negocio;

import java.util.Collection;

import com.pruebajse.modelo.entidades.Colega;

public interface NegocioInterface {
	
	int registroDeColega(Colega colega);
	void bajaDeColega(Colega colega);
	void modificarColega(Colega colega);
	Colega consultarColegaPorId(int id);
	Collection<Colega> verTodosLosColegas();
	
}
