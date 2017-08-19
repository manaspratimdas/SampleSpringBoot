package manas.springboot.sampe.myapp.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entity")
public class Event implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "DATE")
	private String date;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "isDeal")
	private boolean isDeal = Boolean.FALSE;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeal() {
		return isDeal;
	}

	public void setDeal(boolean isDeal) {
		this.isDeal = isDeal;
	}

}
