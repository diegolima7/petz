package br.com.petz.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.petz.beans.PetBean;
import br.com.petz.dto.PetDTO;
import br.com.petz.repositories.PetRepository;
import javassist.NotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	private ModelMapper model = new ModelMapper();

	public PetBean cadastrarPet(PetDTO dto, int idCliente) throws NotFoundException{
		PetBean pet = model.map(dto, PetBean.class);
		this.clienteService.buscaClientePorId(idCliente);		
		pet.setClienteId(idCliente);
		return this.petRepository.save(pet);
	}

	public PetBean atualizarPet(int idPet, PetDTO dto) throws NotFoundException {
		PetBean pet = model.map(dto, PetBean.class);
		return this.petRepository.save(pet);
	}

	public void removerPet(Integer id) {
		this.petRepository.deleteById(id);
	}

	public PetBean buscaPetPorId(Integer id) throws NotFoundException {
		return this.petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet não encontrado"));
	}
	

}
