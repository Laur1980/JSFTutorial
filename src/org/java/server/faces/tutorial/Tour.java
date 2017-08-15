package org.java.server.faces.tutorial;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Tour {
	
	private TourType tourType;
	private List<TourType> tourTypes;
	
	public Tour() {}
	
	@PostConstruct
	private void init(){
		System.out.println("Going into the init method!");
		tourTypes = new LinkedList<TourType>();
		for(TourType t: TourType.values()){
			tourTypes.add(t);
		}
	}
	
	/*
	 * Method is used to redirect to other pages!
	 */
	public String goToPage(){
		if(tourType !=null && tourType == TourType.CITY){
			return "city_tour";
		}else{
			return "country_tour";
		}
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println("Going into the destroy method!");
		tourTypes=null;
	}

	public TourType getTourType() {
		return tourType;
	}

	public void setTourType(TourType tourType) {
		this.tourType = tourType;
	}

	public List<TourType> getTourTypes() {
		return tourTypes;
	}

	public void setTourTypes(List<TourType> tourTypes) {
		this.tourTypes = tourTypes;
	}
	
	
	
}
