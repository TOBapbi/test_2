package Bean;

public class LoginBean {
	private int id;
	private String username;
	private int password;

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(int id, int password) {
		super();
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public int getpassword() {
		return password;
	}

	public void setpassword(int password) {
		this.password = password;
	}

}