package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

	public List<Client> findByName(String name);
	
	public Client findByPhone(String phone);
}
