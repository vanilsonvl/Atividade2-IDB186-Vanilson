package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Client;
import br.gov.sp.fatec.service.ServiceSecurityClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class ServiceSecurityClientTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void testSaveClient(){
		long id;
		ServiceSecurityClient cli = (ServiceSecurityClient)context.getBean("serviceSecurityClient");
		try {
			Client client = new Client();
			client.setName("Client");
			client.setPhone("123232131");
			id = cli.transactionalClient(client);
		}
		catch(Exception e) {
			id = 0;	
		}
		
		assertTrue(id != 0);
	}
}
