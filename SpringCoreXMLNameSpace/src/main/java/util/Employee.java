package util;

public class Employee 
{
	private Integer  id;
	
	private String name;
	
	private Double salary;
	
	private String city;
	
	private Department depart;
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Double salary, String city, Department depart) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.depart = depart;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + ", depart=" + depart
				+ "]";
	}
}
