package br.ueg.Armas.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.Armas.model.Arma;
import br.ueg.Armas.service.ArmasService;

@RestController
@RequestMapping(path = "/armas")
public class ArmasController {
	
	@Autowired
	private ArmasService armasService;
	
	@GetMapping()
	public List<Arma> listarTodos(){
		return armasService.listar();
	}
	
	@PostMapping
	public Arma incluir(@RequestBody Arma arma) {
		return armasService.incluir(arma);
	}
	
	@GetMapping(path = "/{idArma}")
	public Arma getArma(@PathVariable("idArma")Integer id) {
		return armasService.getArma(id);
	}
	
	@GetMapping(path = "marca/{marca}")
	public List<Arma> getArmaByMarca(@PathVariable("marca")String marca){
		return armasService.getArmaByMarca(marca);
	}
	
	@DeleteMapping( path = "{idArma}")
	public Arma remover(@PathVariable("idArma") Integer id) {
		return armasService.remover(id);
	}
	
	@PatchMapping( path = "update/{idArma}")
	public Arma alterar(@RequestBody Arma arma, @PathVariable("idArma") Integer id) {
		return armasService.alterar(arma, id);
	}
	


}
