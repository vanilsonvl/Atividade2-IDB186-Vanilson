package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
	
	public List<Car> findByModel(String model);
	public List<Car> findByManufacturer(String manufacturer);
	
	@Query("select c from Car c where cli_id = ?")
	public List<Car> findByClients(long client_id);
}
