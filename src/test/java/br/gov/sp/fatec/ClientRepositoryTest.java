package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Client;
import br.gov.sp.fatec.repository.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class ClientRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String NAME = "Client1";
	private static final String PHONE = "123456";
	
	@Autowired
	private ClientRepository clientRepo;
	
	public void setClentRespo(ClientRepository clientRepo){
		this.clientRepo = clientRepo;
	}
	
	@Test
	public void testInsertOk(){
		Client client = new Client();
		client.setName(NAME);
		client.setPhone(PHONE);
		clientRepo.save(client);
		assertTrue(client.getId() != null);
	}
	
	@Test
	public void testUpdateOk(){
		Client client = new Client();
		client.setName(NAME);
		client.setPhone(PHONE);
		clientRepo.save(client);
		client.setName("UPDATE");
		clientRepo.save(client);
		assertEquals(client.getName(), "UPDATE");
	}	
	
}
