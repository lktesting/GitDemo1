
public class BuyerVehicleData 
{
	public static void main(String[] args) 
	{
		Vehicle1 v1 = new Truck("Toyota", 500000, 2016, "Camrey", "Electric");
		Vehicle1 v2 = new Sedan("honda city", 700000, 2014, "iv-tec", "Electric");
		Vehicle1 v3 = new Bike("honda", 900000, 2017, "activa", "Electric");
		Vehicle1 v4 = new Sedan("maruti suzuki",800000,2017,"swift desire","Electric");
		Vehicle1 v5 = new Sedan("maruti suzuki",1000000,2017,"i 20","Electric");
		Vehicle1 v6 = new Truck("mahindra",1100000,2017,"XUV","Electric");
		Vehicle1 v7 = new Bike("honda",1200000,2017,"bullet","Electric");
		Vehicle1 v8 = new Truck("mahindra",1300000,2017,"xylo","Electric");
		Vehicle1[] veh_arr1 = {v1,v2,v3,v7};
		Vehicle1[] veh_arr2 = {v4,v5,v6,v8};
		Vehicle1[] veh_arr3 = {null,v5,v6,v8};
		Vehicle1[] veh_arr4 = {null,null,null,null};
		VehicleBuyer buyer1 = new VehicleBuyer("nikhil","mumbai",7718919, veh_arr1);
		VehicleBuyer buyer2 = new VehicleBuyer("lalkunwar","delhi",9889091,veh_arr2);
		VehicleBuyer buyer3 = new VehicleBuyer("joy","delhi",9889091,veh_arr3);
		VehicleBuyer buyer4 = new VehicleBuyer("jolly","delhi",9889091,veh_arr4);
		//b1.GetNamesOfVehicles();
		//b1.GetTotalPrice();
		//buyer1.NumberType();
		Vehicle1 VE1 = buyer1.GetExpensiveVehicle();
		Vehicle1 VE2 = buyer2.GetExpensiveVehicle();

		VehicleBuyer[] B = {buyer1,buyer2,buyer3,buyer4};
		BuyerExpensiveVehicle(B);




		Vehicle1 VE3 = buyer3.GetExpensiveVehicle();
		if(VE3 == null)
			System.out.println(buyer3.name + " does not have any vehicle");
		else
			buyer3.ShowExpensive(VE3);

		Vehicle1 VE4 = buyer4.GetExpensiveVehicle();
		if(VE4 == null)
			System.out.println(buyer4.name + " does not have any vehicle");


		if(VE1.price >= VE2.price)
		{
			buyer1.ShowExpensive(VE1);
		}
		else
		{
			buyer2.ShowExpensive(VE2);
		}

		Vehicle1 VH1 = buyer1.ExpensiveVehicleType();
		Vehicle1 VH2 = buyer2.ExpensiveVehicleType();
		if(VH1.price >= VH2.price)
		{
			buyer1.ShowExpensive(VH1);
		}
		else
		{
			buyer2.ShowExpensive(VH2);
		}

		if(buyer2.ExpensiveSedan1() == null)
			System.out.println(buyer2.name + " does not have any Sedan");
		else
			buyer2.ExpensiveSedan1().GetPrice();

		if(buyer2.ExpensiveVehicleType1(Bike.class) == null)
			System.out.println(buyer2.name + " does not have any " + Bike.class.toString());
		else
			buyer2.ExpensiveVehicleType1(Bike.class).GetPrice();
	}

	public static void BuyerExpensiveVehicle(VehicleBuyer[] A)
	{
		VehicleBuyer buyerexpensive = A[0];
		int i = 0;
		for(i = 0;i < A.length;i++)
		{
			if(A[i].GetExpensiveVehicle() != null)
			{
				if(buyerexpensive.GetExpensiveVehicle() == null || (buyerexpensive.GetExpensiveVehicle().price <= A[i].GetExpensiveVehicle().price))
				{
					buyerexpensive = A[i];
				}
			}
		}
		buyerexpensive.ShowExpensive(A[i].GetExpensiveVehicle());
	}
}


class VehicleBuyer
{
	String name;
	String address;
	int phonenumber;
	Vehicle1[] V_Arr = new Vehicle1[4];

	VehicleBuyer(String NAME, String ADDRESS, int PHONE, Vehicle1[] v_arr)
	{
		name = NAME;
		address = ADDRESS;
		phonenumber = PHONE;
		V_Arr = v_arr;
	}

	public void GetNamesOfVehicles()
	{
		//sedan.GetName(name);
		//System.out.println(sedan.year);

		//sedan1.GetName(name);
		//System.out.println(sedan1.year);
	}

	public void GetTotalPrice()
	{
		//double TotalPrice = sedan.price + sedan1.price;
		//System.out.println(TotalPrice);
	}

	public Vehicle1 GetExpensiveVehicle()
	{ 
		Vehicle1 largest = V_Arr[0];

		for(int i = 0; i < V_Arr.length;i++)
		{ 
			if(largest == null || (largest.price <= V_Arr[i].price) )
			{

				largest = V_Arr[i];

			}
		}
		return largest;


	}

	public void ShowExpensive(Vehicle1 vec)
	{

		System.out.println(vec.ShowCarInfo(name));
	}


	public int NumberTypeVehicle()
	{
		int i = 0;
		for(Vehicle1 temp : V_Arr)
		{
			if(temp instanceof Sedan)
			{
				i++;
			}
		}
		return i;
	}

	public Vehicle1 ExpensiveSedan()
	{
		Vehicle1 expensive_sedan = null;
		int first = 0, count = 0;
		for(int i = 0; i <= V_Arr.length; i++)
		{
			if(V_Arr[i] instanceof Sedan)
			{
				first = i;
				count++;
				break;
			}
		}
		if(count == 0)
			return null;
		expensive_sedan = V_Arr[first];
		for(int i = first; i <= V_Arr.length; i++)
		{
			if((V_Arr[i] instanceof Sedan) && (expensive_sedan.price <= V_Arr[i].price))
			{
				expensive_sedan = V_Arr[i];
			}
		}
		return expensive_sedan;
	}

	public Vehicle1 ExpensiveSedan1()
	{
		Vehicle1 expensive_sedan = null;
		for(int i = 0; i < V_Arr.length; i++)
		{
			if(V_Arr[i] instanceof Sedan)
			{
				if((V_Arr[i] != null) && ((expensive_sedan == null) || (expensive_sedan.price <= V_Arr[i].price)))
				{
					expensive_sedan = V_Arr[i];
				}
			}
		}
		return expensive_sedan;
	}

	//Find out which vehicle is expensive when it's type is passed to method
	public Vehicle1 ExpensiveVehicleType1(Class type)
	{
		Vehicle1 expensive_vehicle = null;
		for(int i = 0; i < V_Arr.length; i++)
		{
			if(V_Arr[i].getClass() == type)
			{
				if((expensive_vehicle == null) || (expensive_vehicle.price <= V_Arr[i].price))
					expensive_vehicle = V_Arr[i];
			}
		}
		return expensive_vehicle;
	}

	public Vehicle1 ExpensiveVehicleType()
	{
		int i = NumberTypeVehicle();
		Vehicle1[] VC_ARR = new Vehicle1[i];
		int j ;
		for(j = 0;j < i;j++)
		{
			for(Vehicle1 temp : V_Arr)
			{
				if(temp instanceof Sedan)
				{
					VC_ARR[j] = temp;
				}
			}
		}
		Vehicle1 pricy = VC_ARR[0];
		for(Vehicle1 temp1 : VC_ARR)
		{
			if(pricy.price <= temp1.price)
			{
				pricy = temp1;
			}
		}

		return pricy;

	}

	public void GetVehicleTypeCount()//old name NumberType
	{
		int j = 0 , k = 0 , l = 0;
		for(Vehicle1 temp : V_Arr)
		{
			if(temp instanceof Sedan)
			{
				j++;
			}
			else if(temp instanceof Bike)
			{
				k++;
			}
			else if(temp instanceof Truck)
			{
				k++;
			}
		}
		System.out.println(name + " Sedan " + j + " Bike " + k + " Truck " + l);
	}
}

class Vehicle1
{
	String brandname;
	double price;
	int year;
	String modelname;
	String enginetype;
	int tyreno;

	Vehicle1(String Brand,double Price,int Year,String Model,String Engine,int Tyre)
	{
		brandname = Brand;
		price = Price;
		year = Year;
		modelname = Model;
		enginetype = Engine;
		tyreno = Tyre;
	}
	public void GetPrice()
	{
		System.out.println("the price of " + brandname + " " + modelname + " is " + price);
	}
	public void GetName(String name)
	{
		System.out.println("buyer " + name + " brand name " + brandname + "  model name " + modelname );
	}

	public String ShowCarInfo(String name)

	{
		String S = "buyer " + name + " brand name " + brandname + "  model name " + modelname;
		return S;
	}
}


class Sedan extends Vehicle1
{
	Sedan(String Brand, double Price, int Year, String Model, String Engine) 
	{
		super(Brand, Price, Year, Model, Engine, 4);
	}
}

class Bike extends Vehicle1
{
	Bike(String Brand, double Price, int Year, String Model, String Engine) 
	{
		super(Brand, Price, Year, Model, Engine, 2);
	}
}

class Truck extends Vehicle1
{
	Truck(String Brand, double Price, int Year, String Model, String Engine) 
	{
		super(Brand, Price, Year, Model, Engine, 6);
	}
}






