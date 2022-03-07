package Users;

public class UserVO {
	String name;
	String lastName;
	String birthday;
	String email;
	long number;
	String company;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String name, String lastName, String birthday, String email, long number, String company) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.number = number;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
