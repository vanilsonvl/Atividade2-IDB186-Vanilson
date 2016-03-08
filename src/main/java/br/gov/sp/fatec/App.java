package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Car;
import br.gov.sp.fatec.model.Client;
import br.gov.sp.fatec.model.Dealership;
import br.gov.sp.fatec.repository.CarRepository;
import br.gov.sp.fatec.repository.ClientRepository;
import br.gov.sp.fatec.repository.DealershipRepository;
import br.gov.sp.fatec.service.ServiceSecurity;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ClientRepository clientRepo = (ClientRepository) context.getBean("clientRepository");
		DealershipRepository dealershipRepo = (DealershipRepository) context.getBean("dealershipRepository");
		CarRepository carRepo = (CarRepository) context.getBean("carRepository");
		boolean logged;
		Dealership dealership2;
		Dealership dealership = new Dealership();
		Car car1, car2, car3;
		Client cli1, cli2;
		
		dealership.setName("Dealership1");
		dealership.setUsername("D1");
		dealership.setPassword("12345");
		//        dealershipRepo.save(dealership);
		System.out.println("salvo.");
		dealership2 = dealershipRepo.checkDealership(dealership.getPassword(), dealership.getUsername());
		System.out.println(""+dealership.getUsername());
		System.out.println(""+dealership2.getUsername());

		logged = doLogin(dealership, dealership2);
		if(logged)
			System.out.println("Logou");
		else
			System.out.println("Usuario ou senha invalido");

//		ServiceSecurity sec = (ServiceSecurity)context.getBean("serviceSecurity");
//
//		try {
//			sec.TransactionalDealership();
//		}
//		catch(Exception e) {
//			System.out.println("Erro esperado! Rollback realizado!");
//			e.printStackTrace();
//		} 

		//cadastrar cliente
		//cadastrar carro
		cli1 = new Client();
		cli1.setName("Joao Miguel");
		cli1.setPhone("98839239");
		clientRepo.save(cli1);
		System.out.println("Cliente " + cli1.getName() + " salvo");
		cli2 = new Client();
		cli2.setName("Maria Antonia");
		cli2.setPhone("9342345657");
		clientRepo.save(cli2);
		System.out.println("Cliente " + cli2.getName() + " salvo");
		car1 = new Car();
		car1.setManufacturer("Volkswagen");
		car1.setModel("Gol");
		car1.setPrice(23000.00);
		carRepo.save(car1);
		System.out.println("Carro " + car1.getModel() + " salvo");
		
		car2 = new Car();
		car2.setManufacturer("Fiat");
		car2.setModel("Palio");
		car2.setPrice(20000.00);
		car2.setClient(cli1);
		carRepo.save(car2);
		System.out.println("Carro " + car1.getModel() + " salvo");
		
		car3 = new Car();
		car3.setManufacturer("Volkswagen");
		car3.setModel("Voyage");
		car3.setPrice(43000.00);
		car3.setClient(cli1);
		carRepo.save(car3);
		System.out.println("Carro " + car1.getModel() + " salvo");
		
		for(Client cli: clientRepo.findByName("Maria Antonia")){
			System.out.println("Cliente " + cli.getName() + " encontrado");
		}
		
		for(Car car: carRepo.findByManufacturer("Volkswagen")){
			System.out.println("Carros da marca Volkswagen: " + car.getModel());
		}
		
		System.out.println("Carros do cliente " + cli1.getName());
		for(Car car: carRepo.findByClients(cli1.getId())){
			System.out.println(car.getModel());
		}	
		
		System.out.println("Deletando...");
		carRepo.delete(car1);
		carRepo.delete(car2);
		carRepo.delete(car3);
		clientRepo.delete(cli1);
		clientRepo.delete(cli2);

	}

	public static boolean doLogin(Dealership d1, Dealership d2){
		if(d1.getUsername().equals(d2.getUsername()))
			return true;
		else
			return false;        	
	}
}
