package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Table(name = "CAR")
public class Car {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CAR_ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CLI_ID", table = "CAR")
	private Client client;
	
	@Column(name = "CAR_PRICE", nullable = false, precision=5, scale=2)
	private double price;
	
	@Column(name = "CAR_MODEL", length = 20, nullable = false)
	private String model;
	
	@Column(name = "CAR_MANUFACTURER", length = 20, nullable = false)
	private String manufacturer;
	
	public Long getId(){
		return id;
	}
	
	public Client getClient(){
		return this.client;
	}
	
	public void setClient(Client client){
		this.client = client;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public String getModel(){
		return model;
	}
	
	public void setModel(String model){
		this.model = model;
	}
	
	public String getManufacturer(){
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	
}
