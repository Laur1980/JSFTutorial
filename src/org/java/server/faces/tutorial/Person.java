package org.java.server.faces.tutorial;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


@RequestScoped
@ManagedBean
public class Person {
	
	private String firstName;
	private String lastName;
	private int freePasses; //this field with special JSF validation rules
	private int postalCode; //this field with special JSF validation rules as well
	private String phoneNumber;//this field will be validate with regex
	private String specialCode;//this field will be validate with a custom rule
	
	public Person() {}
	
	//this the custom validation rule implementation
	public void validateSpecialCode(FacesContext context, 
									UIComponent component, 
									Object value)throws ValidatorException{
		
		if(value == null){
			return;
		}
		
		String data = value.toString();
		
		if(!data.startsWith("MAGIC")){
			FacesMessage message = new FacesMessage("The special code must start with MAGIC");
			throw new ValidatorException(message);
		}
	}
	
	public String getSpecialCode() {
		return specialCode;
	}

	public void setSpecialCode(String specialCode) {
		this.specialCode = specialCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + freePasses;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + postalCode;
		result = prime * result + ((specialCode == null) ? 0 : specialCode.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (freePasses != other.freePasses)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (postalCode != other.postalCode)
			return false;
		if (specialCode == null) {
			if (other.specialCode != null)
				return false;
		} else if (!specialCode.equals(other.specialCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses
				+ ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", specialCode=" + specialCode + "]";
	}
			
}
