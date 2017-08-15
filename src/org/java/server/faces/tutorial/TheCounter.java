package org.java.server.faces.tutorial;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class TheCounter {
	
	private int counter;
	
	public TheCounter() {
	}
	
	public String incrementCounter(){
		this.counter++;
		return "counter-page";
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + counter;
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
		TheCounter other = (TheCounter) obj;
		if (counter != other.counter)
			return false;
		return true;
	}
	
	
	
}
