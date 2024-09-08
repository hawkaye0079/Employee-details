import java.util.Scanner;
class Date{
	int day,month,year;
	Date(int d,int m,int y) {
		day=d;
		month=m;
		year=y;
	}
}

class Address{
	String country,state,dist,areacode;
	Address(String c,String s,String d,String p){
		country=c;
		state=s;
		dist=d;
		areacode=p;
	}
	void display() {
		System.out.println("Country="+country+",State="+state+",District="+dist+",Areacode="+areacode);
	}
}
class Employee{
	Scanner sc=new Scanner(System.in);
	String name,jobPosition,contactNumber;
	int empId;
	double salary;
	Date hireDate;
	Address address;
	Employee(String n,String jp,String cn,int id,double s){
		name=n;
		jobPosition=jp;
		contactNumber=cn;
		empId=id;
		salary=s;
		System.out.println("Enter day,month, and year of hiring respectively-");
		int d=sc.nextInt();
		int m=sc.nextInt();
		int y=sc.nextInt();
		System.out.println("Enter address--");
		sc.nextLine();
		System.out.print("Country:");
		String c=sc.nextLine();
		System.out.print("State:");
		String st=sc.nextLine();
		System.out.print("District:");
		String dist=sc.nextLine();
		System.out.print("Areacode:");
		String code=sc.nextLine();
		hireDate=new Date(d,m,y);
		address=new Address(c, st, dist, code);
	}
	
	void display() {
		System.out.println("Name = "+name);
		System.out.println("Employee id = "+empId);
		System.out.println("Salary = "+salary);
		System.out.println("Hire Date : "+hireDate.day+"-"+hireDate.month+"-"+hireDate.year);
		System.out.println("Job Position = "+jobPosition);
		System.out.println("Contact Number = "+contactNumber);
		System.out.println("Address : ");
		address.display();
		System.out.println();
	}
	
}

public class project {
	
	public static void arrangeEmployeeBySalary(Employee e[]) {
		for(int i=0;i<3-1;i++) {
			for(int j=0;j<3-i-1;j++) {
				if(e[j].salary<e[j+1].salary) {
					Employee temp=e[j];
					e[j]=e[j+1];
					e[j+1]=temp;
				}
				e[i].display();
			}
		}
	}
	
	public static void getEmployeesByJobPosition(Employee e[], String jp) {
		System.out.println("Displaying employee details with job position:"+jp);
		for(int i=0;i<3;i++) {
			if(e[i].jobPosition.equals(jp)) {
				e[i].display();
			}
		}
	}
	
	public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2) {
		for(int i=0;i<3;i++) {
			if((e[i].hireDate.year>=d1.year && e[i].hireDate.year<=d2.year) &&
					(e[i].hireDate.month>=d1.month || e[i].hireDate.month<=d2.month) &&
					(e[i].hireDate.day>=d1.day || e[i].hireDate.day<=d2.day)) {
				e[i].display();
			}
		}
	}
	
	public static int foreignEmployeeCount(Employee e[]) {
		int count=0;
		for(int i=0;i<3;i++) {
			if(e[i].contactNumber.substring(0,2).equals("91"))
				continue;
			else
				count++;
		}
		return count;
	}
	
	public static void getEmployeesBySalary(Employee e[], double s1, double s2) {
		for(int i=0;i<3;i++) {
			if(e[i].salary>=s1 && e[i].salary<=s2)
				e[i].display();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Employee ob[]=new Employee[3];
		System.out.println("Enter all details of employees.");
		for(int i=0;i<3;i++) {
			sc.nextLine();
			System.out.print("Enter name:");
			String n=sc.nextLine();
			System.out.print("Enter job position:");
			String jp=sc.nextLine();
			System.out.print("Enter employee id:");
			int id=sc.nextInt();
			System.out.print("Enter salary:");
			double s=sc.nextDouble();
			System.out.print("Enter contact number:");
			String cn=sc.next();
			ob[i]=new Employee(n,jp,cn,id,s);
		}
		sc.close();
		arrangeEmployeeBySalary(ob);
		System.out.println("Employee details are arranged in descending order of salary.");
		System.out.println("Displaying details of \"manager\"--");
		getEmployeesByJobPosition(ob, "manager");
		System.out.println("displaying details of employees whose hireDate is between 01-04-2022 to 31-03-2023--");
		Date d1=new Date(1,4,2022);
		Date d2=new Date(31,3,2023);
		getEmployeesByHireDate(ob,d1,d2);
		System.out.println("Number of foreign employees="+foreignEmployeeCount(ob));
		System.out.println("Displaying employees with salary from 150000 to 300000--");
		getEmployeesBySalary(ob,150000,300000);
	}

}
