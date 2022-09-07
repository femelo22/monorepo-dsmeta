package lf.melo.com.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SALES")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sallerName;
	
	private int visited;
	
	private int deals;
	
	private Double amount;
	
	private LocalDate date;
	
	
	public Sale() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSallerName() {
		return sallerName;
	}


	public void setSallerName(String sallerName) {
		this.sallerName = sallerName;
	}


	public int getVisited() {
		return visited;
	}


	public void setVisited(int visited) {
		this.visited = visited;
	}


	public int getDeals() {
		return deals;
	}


	public void setDeals(int deals) {
		this.deals = deals;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
