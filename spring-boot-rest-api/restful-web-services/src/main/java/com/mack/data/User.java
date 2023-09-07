/*********************
* User.java
* 06-Sep-2023 
* MACK-WORLD 
**********************/
package com.mack.data;

import java.time.LocalDate;

/**
 * @author Bhagwat Kolte
 *
 */
public class User {
	
	private Integer userID;
	
	private String name;
	
	private LocalDate birthDate;
	
	

	/**
	 * @param userID
	 * @param name
	 * @param localDate
	 */
	public User(Integer userID, String name, LocalDate localDate) {
		super();
		this.userID = userID;
		this.name = name;
		this.birthDate = localDate;
	}

	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
}
