/*********************
* UserDao.java
* 06-Sep-2023 
* MACK-WORLD 
**********************/
package com.mack.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.mack.data.User;

/**
 * @author Bhagwat Kolte
 *
 */
@Component
public class UserDao {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Amol", LocalDate.now().minusYears(39)));
		users.add(new User(2, "Arati", LocalDate.now().minusYears(32)));
		users.add(new User(3, "Kunsh", LocalDate.now().minusYears(7)));
		users.add(new User(4, "Bhomashya", LocalDate.now().minusYears(9)));
		users.add(new User(5, "Lau", LocalDate.now().minusYears(6)));
		users.add(new User(6, "Purvi", LocalDate.now().minusYears(2)));
		
	}
	
	public List<User> daGetAllUsers(){
		return users;
	}

	public User daGetUser(int userID){
//		for (int i = 0; i < users.size(); i++){
//			if (users.get(i).getUserID().equals(userID)){
//				return users.get(i);
//			}
//		}
//		return null;

		Predicate<User> userPredicate = user -> user.getUserID().equals(userID);

		return users.stream().filter(userPredicate).findFirst().orElse(null);
	}
	public User daAddUser(User user){

		int id = users.size();
		user.setUserID(++id);
		users.add(user);

		return user;
	}


}
