package services;

public class JavaCourse implements ICourse
{
	public boolean getTheCourse(double amount)
	{
		System.out.println("Java Course is purchased and amount paid is : "+ amount);
		return true;
	}
}
