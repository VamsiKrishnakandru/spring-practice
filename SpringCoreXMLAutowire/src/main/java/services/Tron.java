package services;

public class Tron 
{
	private ICourse course;
	
	public Tron()
	{
	}
	
	public Tron(ICourse course)
	{
		super();
		this.course = course;
	}
	
	public void setCourse(ICourse course)
	{
		this.course = course;
	}
	
	public boolean buyTheCourse(double amount)
	{
		return course.getTheCourse(amount);
	}
}
