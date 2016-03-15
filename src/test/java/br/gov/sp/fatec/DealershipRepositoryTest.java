package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Dealership;
import br.gov.sp.fatec.repository.DealershipRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class DealershipRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final String USERNAME = "dealer1";
	private static final String NAME = "dealership name";
	private static final String PASSWORD = "pwd";
	
	@Autowired
	private DealershipRepository dealershipRepo;
	
	public void setDealershipRepository(DealershipRepository dealershipRepo){
		this.dealershipRepo = dealershipRepo;
	}
	
	@Test
	public void testInsertOk(){
		Dealership dealership = new Dealership();
		dealership.setName(NAME);
		dealership.setUsername(USERNAME);
		dealership.setPassword(PASSWORD);
		dealershipRepo.save(dealership);
		assertTrue(dealership.getId() != null);
	}
	
	@Test
	public void testUpdateOk(){
		Dealership dealership = new Dealership();
		dealership.setName(NAME);
		dealership.setUsername(USERNAME);
		dealership.setPassword(PASSWORD);
		dealershipRepo.save(dealership);
		dealership.setName("UPDATE");
		dealershipRepo.save(dealership);
		assertEquals(dealership.getName(), "UPDATE");
	}
	
}
