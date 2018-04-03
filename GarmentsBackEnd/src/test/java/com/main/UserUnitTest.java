//package com.main;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.DAO.UserDAO;
//import com.model.User;
//
//public class UserUnitTest {static UserDAO userDAO;
//@BeforeClass
//public static void executeFirst()
//{
//	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//	context.scan("com.*");
//	context.refresh();
//	
//	userDAO=(UserDAO)context.getBean("userDAO");
//}
//
//@Test
//public void addUserTest()
//{
//	User user=new User();
//	user.setUserName("Book Cupboard");
//	user.setUserDescription("All the Book Cupboard Types");
//	assertTrue("Problem in User Insertion",userDAO.addUser(user));
//}
//
//@Ignore
//@Test
//public void getUserTest()
//{
//	assertNotNull("Problem in get User",userDAO.getUser(2));
//}
//
//@Ignore
//@Test
//public void deleteUserTest()
//{
//	User user=userDAO.getUser(2);
//	assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
//}
//
//@Test
//public void updateUserTest()
//{
//	User user=userDAO.getUser(3);
//	user.setUserName("L Sofa Model");
//	assertTrue("Problem in Updation",userDAO.updateUser(user));
//}
//
//@Test
//public void listCategoriesTest()
//{
//	List<User> listUsers=userDAO.getUser();
//	assertNotNull("No Users",listUsers);
//	
//	for(Users users:listUsers)
//	{
//		System.out.print(users.getUserId()+":::");
//		System.out.print(users.getUserName()+":::");
//		System.out.println(users.getUserDescription());
//	}
//}
//
//	
//
//}
