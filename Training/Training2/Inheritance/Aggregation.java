

class Team{
	String team;
	Team(String team){
		this.team = team;
	}
}

class EmployeeZ{
	String name;
	Team team;
	EmployeeZ(String name,Team team){
		this.name = name;
		this.team = team;
	}
	void printMethod() {
		System.out.println("Employee Details: " + name + " " + team.team);
	}
}

public class Aggregation {
	public static void main(String[] args) {
		Team t1 = new Team("Desk");
		Team t2 = new Team("CRM");
		
		EmployeeZ emp1 = new EmployeeZ("Ramesh",t1);        //Aggregation means object parameter inside object declaration
		EmployeeZ emp2 = new EmployeeZ("Suresh",t2);
		EmployeeZ emp3 = new EmployeeZ("Bromesh",t1);
		
		emp1.printMethod();
		emp2.printMethod();
		emp3.printMethod();
	}
}

