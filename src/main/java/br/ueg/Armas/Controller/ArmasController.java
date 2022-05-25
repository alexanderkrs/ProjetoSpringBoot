package br.ueg.Armas.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.Armas.model.Arma;
import br.ueg.Armas.repository.ArmasRepository;

@RestController
@RequestMapping(path = "/armas")
public class ArmasController {
	
	@Autowired
	private ArmasRepository armasRepository;
	
	@GetMapping
	public List<Arma> listar(){
		Iterable<Arma> findAll = armasRepository.findAll();
		List<Arma> armas = new ArrayList<Arma>();
		
		findAll.forEach(arma -> {
			armas.add(arma);
		});
		
		return armas;
	}
	
	@PostMapping
	public Arma incluir(@RequestBody Arma arma) {
		arma.setId(null);
		return armasRepository.save(arma);
	}
	
	@PostMapping(path = "/{id}")
	public Arma alterar(@RequestBody Arma arma, @RequestParam Integer id) {
		Optional<Arma> armaBD = armasRepository.findById(id);
		if(!armaBD.isPresent()) {
			throw new IllegalStateException("Arma não existe para este ID:"+id);
		}
		Arma armaOld = armaBD.get();
		if(arma.getMarca()!=null) {
			armaOld.setMarca(arma.getMarca());	
		}
		if(arma.getModelo()!=null) {
			armaOld.setModelo(arma.getModelo());	
		}
		if(arma.getCalibre()!=null) {
			armaOld.setCalibre(arma.getCalibre());	
		}
		
		armasRepository.save(armaOld);
		return armaOld;
		
	}


}