package org.java.server.faces.tutorial;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name="student")
public class Student {
	
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private TravelOptionType travelBy;
	private List<TravelOptionType> travelTypes;
	private String eatingAranjaments;
	private String[] vacationType;
	private List<VacationType> vacationTypes;
	
	public Student() {}
	
	@PostConstruct
	private void init(){
		System.out.println(">>>The init method has been called!<<<");
		travelTypes = populateTravelTypes();
		vacationTypes = populateVacationTypes();
		firstName = "Gogu";
		lastName = "Echilibreanu";
		country = "Romania";
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println(">>>The destroy method has been called!<<<");
		firstName = null;
		lastName = null;
		country = null;
	}
	
	private List<TravelOptionType> populateTravelTypes(){
		List<TravelOptionType> travelTypes = new LinkedList<>();
		for(TravelOptionType t: TravelOptionType.values()){
			travelTypes.add(t);
		}
		return travelTypes;
	}
	
	private List<VacationType> populateVacationTypes(){
		List<VacationType> vacationTypes = new LinkedList<>();
		for(VacationType t: VacationType.values()){
			vacationTypes.add(t);
		}
		return vacationTypes;
	}
			
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getVacationType() {
		return vacationType;
	}

	public void setVacationType(String[] vacationType) {
		this.vacationType = vacationType;
	}

	public List<VacationType> getVacationTypes() {
		return vacationTypes;
	}

	public void setVacationTypes(List<VacationType> vacationTypes) {
		this.vacationTypes = vacationTypes;
	}

	public String getEatingAranjaments() {
		return eatingAranjaments;
	}

	public void setEatingAranjaments(String eatingAranjaments) {
		this.eatingAranjaments = eatingAranjaments;
	}

	public TravelOptionType getTravelBy() {
		return travelBy;
	}

	public void setTravelBy(TravelOptionType travelBy) {
		this.travelBy = travelBy;
	}

	public List<TravelOptionType> getTravelTypes() {
		return travelTypes;
	}

	public void setTravelTypes(List<TravelOptionType> travelTypes) {
		this.travelTypes = travelTypes;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((travelTypes == null) ? 0 : travelTypes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (travelTypes == null) {
			if (other.travelTypes != null)
				return false;
		} else if (!travelTypes.equals(other.travelTypes))
			return false;
		return true;
	}
	
}
