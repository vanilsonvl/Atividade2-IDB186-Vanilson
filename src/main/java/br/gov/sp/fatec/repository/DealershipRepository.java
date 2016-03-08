package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Dealership;

public interface DealershipRepository extends CrudRepository<Dealership, Long>{
	
	public Dealership findByName(String name);
	
	@Query("select d from Dealership d where d.password =? and d.username =?")
	public Dealership checkDealership(String password, String username);
	

}
