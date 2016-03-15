package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Client;
import br.gov.sp.fatec.repository.ClientRepository;
import br.gov.sp.fatec.repository.DealershipRepository;

@Service("serviceSecurityClient")
public class ServiceSecurityClientImp implements ServiceSecurityClient{
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	@Transactional
	public long transactionalClient(Client client){
		clientRepo.save(client);
		return client.getId();
	}
	
	public void setClientRepo(ClientRepository clientRepo){
		this.clientRepo = clientRepo;
	}


}
