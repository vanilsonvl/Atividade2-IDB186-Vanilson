package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Dealership;
import br.gov.sp.fatec.repository.DealershipRepository;

@Service("serviceSecurity")
public class ServiceSecurityImp implements ServiceSecurity{

	@Autowired
	private DealershipRepository dealershipRepo;

	@Override
	@Transactional
	public void TransactionalDealership(){
		Dealership dealership;
		dealership = new Dealership();
		dealership.setName("nome");
		dealership.setPassword("123");
		dealershipRepo.save(dealership);
	}

	public void setDealershipRepo(DealershipRepository dealershipRepo){
		this.dealershipRepo = dealershipRepo;
	}

}