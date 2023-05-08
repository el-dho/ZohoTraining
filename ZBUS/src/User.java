import java.util.*;

public class User {
	private int userId;
	private String userName;
	private String userNumber;
	private int userAge;
	private String userGender;
	
	public User() {
		
	}
	
	public User(int id,String name,String num,int age,String gender) {
		this.userId = id;
		this.userName = name;
		this.userNumber = num;
		this.userAge = age;
		this.userGender = gender;
	}

	public int getId() {
		return userId;
	}


	public String getName() {
		return userName;
	}

	public String getNum() {
		return userNumber;
	}

	public int getAge() {
		return userAge;
	}

	public String getGender() {
		return userGender;
	}
}
