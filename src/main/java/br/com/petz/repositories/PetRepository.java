package br.com.petz.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.petz.beans.ClienteBean;
import br.com.petz.beans.PetBean;

@Repository
public interface PetRepository extends JpaRepository<PetBean, Integer>{
		
	public PetBean findByCliente(Optional<ClienteBean> optional);
	

}
