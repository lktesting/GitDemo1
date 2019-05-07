import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOutput
{
	public static void main(String[] args) 
	{
		StudentS s1 = new StudentS("nikhil",Gender.Male,1,"vashi",1,490);
		StudentS s2 = new StudentS("lalkunwar",Gender.Female,2,"koparkhairane",2,450);
		StudentS s3 = new StudentS("anmol",Gender.Female,3,"matunga",4,410);
		StudentS s4 = new StudentS("ashu",Gender.Female,4,"delhi",3,420);
		StudentS s5 = new StudentS("ankita",Gender.Female,5,"pune",5,400);

		StudentS s6 = new StudentS("soham",Gender.Male,1,"vashi",1,495);
		StudentS s7 = new StudentS("harsh",Gender.Male,2,"koparkhairane",2,470);
		StudentS s8 = new StudentS("pallavi",Gender.Female,3,"matunga",4,421);
		StudentS s9 = new StudentS("komal",Gender.Female,4,"delhi",3,437);
		StudentS s10 = new StudentS("sejal",Gender.Female,5,"pune",5,405);

		ArrayList<StudentS> studentlist1 = new ArrayList<StudentS>();
		studentlist1.add(s1);
		studentlist1.add(s2);
		studentlist1.add(s3);
		studentlist1.add(s4);

		ArrayList<StudentS> studentlist2 = new ArrayList<StudentS>();
		studentlist2.add(s6);
		studentlist2.add(s7);
		studentlist2.add(s8);
		studentlist2.add(s9);
		studentlist2.add(s10);

		ArrayList<StudentS> studentlist3 = new ArrayList<StudentS>();

		StudentClass C1 = new StudentClass("10A",studentlist1);
		StudentClass C2 = new StudentClass("10B",studentlist2);
		StudentClass C3 = new StudentClass("10C",studentlist3);

		ArrayList<StudentClass> class_list = new ArrayList<StudentClass>();
		class_list.add(C1);
		class_list.add(C2);
		class_list.add(C3);

		C1.GetClassInfo();
		System.out.println();
		
		C1.CountGenderType();
		System.out.println();
		
		C1.RankWiseAllignment();
		System.out.println();
		
		System.out.println("Class info for class C3 - empty student array list is ");
		C3.GetClassInfo();
		System.out.println();
		
		System.out.println("Gender count for class C3 - empty student array list");
		C3.CountGenderType();
		System.out.println();
		
		System.out.println("C3 class topper");
		if(C3.TopperStudent() == null)
		{
			System.out.println("There is no topper");
		}
		else
		{
			C3.ShowTopperStudentData(C3.TopperStudent());
		}
		System.out.println();
		
		System.out.println("Topper student amongst all classes: ");
		ShowStandardTopper(class_list);

	}

	public static void ShowStandardTopper(ArrayList<StudentClass> c_list)
	{
		StudentClass topper_class = null;

		for(int i = 0;i < c_list.size();i++)
		{
			if(c_list.get(i).TopperStudent() != null)
				if(topper_class == null || topper_class.TopperStudent().marks <= c_list.get(i).TopperStudent().marks)
				{
					topper_class = c_list.get(i);
				}
		}
		topper_class.ShowTopperStudentData(topper_class.TopperStudent());
	}
}

class StudentClass
{
	String standard_section;

	ArrayList<StudentS> stud_list = new ArrayList<StudentS>();

	StudentClass(String STANDARDSECTION,ArrayList<StudentS> LIST)
	{
		standard_section = STANDARDSECTION;
		stud_list = LIST;
	}

	public void GetClassInfo()
	{ 

		if(stud_list != null && !stud_list.isEmpty())
		{
			System.out.println(standard_section);
			for(int i = 0;i < stud_list.size();i++)
			{
				stud_list.get(i).ShowStudentData();
			}
		}
		else
		{
			System.out.println("There are no students in class " + standard_section);
		}

	}

	public void CountGenderType()
	{
		Gender f = Gender.Female;
		Gender m = Gender.Male;
		int Female_count = 0, Male_count=0;
		if(stud_list != null && !stud_list.isEmpty())
		{
			for(int i = 0;i < stud_list.size();i++)
			{
				if(stud_list.get(i).gender.equals(f))
				{
					Female_count++;
				}
				else
				if(stud_list.get(i).gender.equals(m))
				{
					Male_count++;
				}	
			}
		}
		
		if(Female_count == 0 && Male_count == 0)
		{
			System.out.println("There are no students in class " + standard_section);
		}
		else
		{
			System.out.println("No of females in class " + standard_section + ": " + Female_count);
			System.out.println("No of males in class " + standard_section + ": " + Male_count);
		}
	}

	public void RankWiseAllignment()
	{
		if(stud_list != null && !stud_list.isEmpty())
		{
			for(int i = 0;i < stud_list.size();i++)
			{
				for(int j = i+1;j < stud_list.size();j++)
				{
					if(stud_list.get(j).rank < stud_list.get(i).rank)
					{
						Collections.swap(stud_list, i, j);
					}
				}
			}
		}
		System.out.println("RANK WISE STUDENT INFORAMTION OF CLASS " + standard_section + ": ");
		for(int i = 0;i < stud_list.size();i++)
		{
			stud_list.get(i).ShowStudentData();
		}
	}

	public StudentS TopperStudent()
	{
		StudentS TopperStudent = null;
		if(stud_list != null && !stud_list.isEmpty())
		{
			for(int i = 0;i < stud_list.size();i++)
			{
				for(int j = i+1;j < stud_list.size();j++)
				{
					if(stud_list.get(j).rank < stud_list.get(i).rank)
					{
						Collections.swap(stud_list, i, j);
					}
				}
			}
			TopperStudent = stud_list.get(0);
		}
		return TopperStudent;
	}

	public void ShowTopperStudentData(StudentS s)
	{ 
		System.out.println(standard_section);
		s.ShowStudentData();
	}

}

class StudentS
{
	String name;
	Gender gender;
	int roll_no;
	String address;
	int rank;
	int marks;

	StudentS(String NAME,Gender GENDER,int ROLL_NO,String ADDRESS,int RANK,int MARKS)
	{
		name = NAME;
		gender = GENDER;
		roll_no = ROLL_NO;
		address = ADDRESS;
		rank = RANK;
		marks = MARKS;
	}

	public void ShowStudentData()
	{
		System.out.println("Rank: " + rank + ", Name: " + name + ", Gender: " + gender + ", Roll no: " + roll_no + ", Address:" + address );
	}
}

enum Gender
{
	Female,
	Male;
}
