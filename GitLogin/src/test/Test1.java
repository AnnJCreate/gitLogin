package test;

import bean.UserBean;
import dao.UserDao;

public class Test1 {

	public static void main(String[] args) {
		
		UserBean u =new UserBean();
		UserDao ud = new UserDao();
		u.setUsername("E");
		u.setPassword("1");
		boolean istrue = ud.findUserByUserBean(u);
		System.out.println(istrue);

	}

}
