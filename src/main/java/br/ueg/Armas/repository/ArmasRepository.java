package br.ueg.Armas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ueg.Armas.model.Arma;

@Repository
public interface ArmasRepository extends CrudRepository<Arma,Integer>{
	
}
