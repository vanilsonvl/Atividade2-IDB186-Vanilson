package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEALERSHIP")
public class Dealership {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "DEA_ID")
	private long id;
	
	@Column(name = "DEA_NAME", length = 30, nullable = false)
	private String name;
	
	@Column(name = "DEA_USERNAME", unique=true, length = 10, nullable = false)
	private String username;
	
	@Column(name = "DEA_PASSWORD", length = 20, nullable = false)
	private String password;
	
	public Long getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	
	
}
