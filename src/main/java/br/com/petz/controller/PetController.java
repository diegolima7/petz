package br.com.petz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.beans.PetBean;
import br.com.petz.dto.PetDTO;
import br.com.petz.responses.Response;
import br.com.petz.services.PetService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService service;

	@PostMapping("/cadastrar/{idCliente}")
	public ResponseEntity<Response<PetBean>> cadastrarPet(@Valid @RequestBody PetDTO pet,
			BindingResult result, @PathVariable(name = "idCliente") int idCliente) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<PetBean>(erros));
		}

		try {
			return ResponseEntity.ok(new Response<PetBean>(this.service.cadastrarPet(pet, idCliente)));

		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/atualizar/{idPet}")
	public ResponseEntity<PetBean> atualizaPet(@PathVariable(name = "idPet") int idPet,
			@RequestBody PetDTO pet) throws NotFoundException {
		return ResponseEntity.ok(this.service.atualizarPet(idPet,pet));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<PetBean> buscaPetPorId(@PathVariable(name = "id") int id) {
		try {
			return ResponseEntity.ok(this.service.buscaPetPorId(id));
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> removerPet(@PathVariable(name = "id") int id) {
		this.service.removerPet(id);
		return ResponseEntity.noContent().build();
	}


}