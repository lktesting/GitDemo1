import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class CompanySystemExecution
{

	public static void main(String[] args) 
	{
		Position p1 = new Position("ceo",PositionLevels.level4);
		Position p2 = new Position("manager",PositionLevels.level3);
		Position p3 = new Position("senior developer",PositionLevels.level2);
		Position p4 = new Position("junior developer",PositionLevels.level1);
		Position p5 = new Position("test manager",PositionLevels.level4);
		Position p6 = new Position("test lead",PositionLevels.level3);
		Position p7 = new Position("test engineer",PositionLevels.level2);
		Position p8 = new Position("test trainee",PositionLevels.level1);
		
		CompanyEmployee emp1 = new CompanyEmployee("mallya","GEP01",30000,CompanyDepartment.Management ,p1,"09/10/1988");
		CompanyEmployee emp2 = new CompanyEmployee("nikhil","GEP02",90000,CompanyDepartment.Technology,p3,"19/12/1988");
		CompanyEmployee emp3 = new CompanyEmployee("akash","GEP03",100000,CompanyDepartment.Technology,p4,"12/09/1989");
		CompanyEmployee emp4 = new CompanyEmployee("harsh","GEP04",30000,CompanyDepartment.Technology,p4,"09/10/1988");
		CompanyEmployee emp5 = new CompanyEmployee("santosh","GEP05",200000,CompanyDepartment.Technology,p2,"19/08/1980");
		CompanyEmployee emp6 = new CompanyEmployee("lalunwar","GEP06",30000,CompanyDepartment.Quality ,p8,"09/10/1988");
		CompanyEmployee emp7 = new CompanyEmployee("anmol","GEP07",30000,CompanyDepartment.Quality ,p8,"09/10/1988");
		CompanyEmployee emp8 = new CompanyEmployee("gitu","GEP08",30000,CompanyDepartment.Quality,p7,"19/12/1988");
		CompanyEmployee emp9 = new CompanyEmployee("ankita","GEP09",30000,CompanyDepartment.Quality ,p7,"09/10/1988");
		CompanyEmployee emp10 = new CompanyEmployee("shruti","GEP10",50000,CompanyDepartment.Quality,p6,"24/03/1990");
		
        //emp10.PrintEmployeeInformation();
		
		CompanySystem compSys = new CompanySystem();
		compSys.AddEmployee(emp1);
		compSys.AddEmployee(emp2);
		compSys.AddEmployee(emp3);
		compSys.AddEmployee(emp4);
		compSys.AddEmployee(emp5);
		compSys.AddEmployee(emp6);
		compSys.AddEmployee(emp7);
		compSys.AddEmployee(emp8);
		compSys.AddEmployee(emp9);
		compSys.AddEmployee(emp10);
		
		compSys.RemoveEmployee(emp10.Id);	
		//compSys.PrintAllActiveEmployeesInfo();
		
	}
	
	
	
}

class CompanySystem
{
	HashMap<String, CompanyEmployee> EmployeeCollection = new HashMap<String, CompanyEmployee>();

	public void AddEmployee(CompanyEmployee currEmp)
	{
		if(!EmployeeCollection.containsKey(currEmp.Id))
		{
			currEmp.IsActive = true;
			EmployeeCollection.put(currEmp.Id, currEmp);
			System.out.println("Employee " + currEmp.Name + " has been added in Database");
		}
		else
			System.out.println("Employee ID already exists in Database");
			
	}
	
	Collection<CompanyEmployee> employee_set = EmployeeCollection.values();
	
	Set<String> empid_set = EmployeeCollection.keySet();
    Set<Entry<String,CompanyEmployee>> entries = EmployeeCollection.entrySet();
    
    
    
	public void RemoveEmployee(String empid)
	{
		for(Entry ent : entries)
	    {
			CompanyEmployee temp = (CompanyEmployee) ent.getValue();
	    	System.out.println(temp.Id);
	    }
		
		for(String key : empid_set)
		{
			if(key.equals(empid))
			{
				EmployeeCollection.get(key).IsActive = false;
				System.out.println("Employee " + EmployeeCollection.get(empid).Name + " has been removed from Database");
			}
		}
	}
	
	
	
	void PrintAllActiveEmployeesInfo()
	{
		System.out.println("hello");
		
		for(CompanyEmployee emp : employee_set)
		{
			
			{
				emp.PrintEmployeeInformation();
			}
		}
	}
	
	
}


class CompanyEmployee
{
	String Name;
	String Id;
	double Salary;
	CompanyDepartment Department;
	String ReportingPersonID;
	Position emp_position;//position name and level
	String Birthdate;
	boolean IsActive = false;

	CompanyEmployee(String name,String id,double salary,CompanyDepartment depart,Position pos,String birthdate)
	{
		Name = name;
		Id = id;
		Salary = salary;
		Department = depart;
		emp_position = pos;
		Birthdate = birthdate;
	}

	
	
	public void PrintEmployeeInformation()//why string empid parameter needed?
	{
		if(IsActive == true)
		{
		System.out.println("Name: " + Name);
		System.out.println("Id: " + Id);
		System.out.println("Salary: " + Salary);
		System.out.println("Department: " + Department);
		System.out.println("Positon name: " + emp_position.positionname + " / level: " + emp_position.level);
		System.out.println("Birtdate: " + Birthdate);
		}
		
		
	}
}

class Position
{
	String positionname;
	PositionLevels level;
	Position(String Pname,PositionLevels lvl)
	{
		positionname = Pname;
		 level = lvl;
	}
}
enum CompanyDepartment
{
	Technology,
	Marketing,
	Sales,
	Quality,
	Management
}

enum PositionLevels
{
	level1,
	level2,
	level3,
    level4
}
