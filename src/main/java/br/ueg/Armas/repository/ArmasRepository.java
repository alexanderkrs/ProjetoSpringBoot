package br.ueg.Armas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ueg.Armas.model.Arma;

@Repository
public interface ArmasRepository extends JpaRepository<Arma, Integer>{
	List<Arma> findByModelo(String modelo);
	
	List<Arma> findByMarca(String marca);

	@Query("" +
            "SELECT CASE WHEN COUNT(a) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Arma a " +
            "WHERE a.modelo = ?1"
    )
	Boolean existeModelo(String modelo);

}
