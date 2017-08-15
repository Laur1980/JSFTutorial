package org.java.server.faces.tutorial;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class StudentDataUtil {
	
	private List<Student> students;
	
	public StudentDataUtil(){}
	
	@PostConstruct
	private void init(){
		students = new LinkedList<>();
		String [] lastNames = {"Vasile","Popescu","Taranescu","Damblagescu","Cretinescu"};
		String [] firstNames = {"Gogu","Adriana","Polina","Catalina","Alexandra","Alexandru","Cristian","Valentin","Valentina"};
		String [] domains = {"@gmail.com","@yahoo.com","@hotmail.com","@apple.com","@dms.org"};
		Random random = new Random();
		Set<Student> container= new HashSet<>();
		for(int i=0;i<10;i++){
			StringBuilder sb = new StringBuilder();
			String firstName = firstNames[random.nextInt(firstNames.length)];
			String lastName = lastNames[random.nextInt(lastNames.length)];
			String mail = sb.append(firstName.toLowerCase()+"."+lastName.toLowerCase()+domains[random.nextInt(domains.length)]).toString();
			Student temp = new Student(firstName,lastName,mail);
			while(!container.isEmpty() && container.contains(temp)){
				firstName = firstNames[random.nextInt(firstNames.length)];
				mail = sb.append(firstName+"."+lastName+domains[random.nextInt(domains.length)]).toString();
				temp = new Student(firstName,lastName,mail);
			}
			container.add(temp);
			students.add(temp);
			listStudents(students);
		}
	}
	
	private void listStudents(List<Student> students){
		for(Student s: students){
			System.out.println(">>>"+s+"<<<");
		}
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		StudentDataUtil other = (StudentDataUtil) obj;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentDataUtil [students=" + students + "]";
	}
		
}
