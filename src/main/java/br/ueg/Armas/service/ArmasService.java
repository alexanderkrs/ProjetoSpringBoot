package br.ueg.Armas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import br.ueg.Armas.model.Arma;
import br.ueg.Armas.repository.ArmasRepository;

@Service
public class ArmasService {

	
	@Autowired
	private ArmasRepository armasRepository;

	
	public List<Arma> listar(){
		return armasRepository.findAll();
	}
	public Arma getArma(Integer id) {
		Optional<Arma> arma = obterArmasSeExiste(id);
		
		return arma.get();
	}
	
	private Optional<Arma> obterArmasSeExiste(Integer id) {
		Optional<Arma> arma = armasRepository.findById(id);
		
			if(!arma.isPresent()) {
				throw new IllegalStateException("Não existe Arma com o ID: "+id);
			}
		return arma;
	}
	
	
	public Arma incluir(Arma arma) {
		Arma armasRetorno = armasRepository.save(arma);
		return armasRetorno;
	}
	
	public List<Arma> getArmaByMarca(String marca){
		List<Arma> armas = armasRepository.findByMarca(marca);
		if(CollectionUtils.isEmpty(armas)) {
			throw new IllegalAccessError ("Nenhuma Marca com esse nome: "+ marca);
		}
		return armas;
	}

	
	private Optional<Arma> obterArmaSeExiste(Integer id) {
		Optional<Arma> arma = armasRepository.findById(id);
		return arma;
	}
	
	public Arma remover(Integer id) {
		Optional<Arma> armaOptional = obterArmaSeExiste(id);
		Arma arma = armaOptional.get();
		armasRepository.delete(arma);		
		return arma;
	}

	public Arma alterar(Arma arma, Integer id) {
		Optional<Arma> armaOptional = obterArmasSeExiste(id);
		Arma armaBD = armaOptional.get();
		
		if(StringUtils.hasLength(arma.getModelo())) {
			armaBD.setModelo(arma.getModelo());
		}
		
		if(StringUtils.hasLength(arma.getMarca())) {
			armaBD.setMarca(arma.getMarca());
		}
		
		if(arma.getCalibre()!= null) {
			armaBD.setCalibre(arma.getCalibre());
		}
		
		armaBD = armasRepository.save(armaBD);
				
		return armaBD;
	}


}
