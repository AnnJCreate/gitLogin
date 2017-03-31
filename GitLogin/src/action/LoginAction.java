package action;




import com.opensymphony.xwork2.ActionSupport;

import bean.UserBean;
import dao.UserDao;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 4251305212879825380L;
	
	private String username;
	private String password;

		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception
	{
		UserBean userbean = new UserBean();
//		System.out.println("username"+username);
//		System.out.println("password"+password);
		userbean.setUsername(username);
		userbean.setPassword(password);
		UserDao userDao = new UserDao();
		boolean b = userDao.findUserByUserBean(userbean);
//		System.out.println("b="+b);
		if(b==true)
		{
//			System.out.println("1");
			return LOGIN;
		}else
		{
//			System.out.println("2");
			return "end";
		}
		
		//return LOGIN;
	}

}
