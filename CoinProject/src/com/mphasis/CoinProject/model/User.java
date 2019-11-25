package com.mphasis.CoinProject.model;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UserC")
	public class User implements Serializable {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int userID;
		private String userName;
		
		@Id
		private String userEmail;
		
		@Id
		private String userMobile;
		private String password;
		private String confirmpassword;
		private LocalDate userDOB;
		private String gender;
		private String Squestion;
		private String answer;
		private String City;
		public int getUserID() {
			return userID;
		}
		public String getUserName() {
			return userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public String getUserMobile() {
			return userMobile;
		}
		public String getPassword() {
			return password;
		}
		public String getConfirmpassword() {
			return confirmpassword;
		}
		public LocalDate getUserDOB() {
			return userDOB;
		}
		public String getGender() {
			return gender;
		}
		public String getSquestion() {
			return Squestion;
		}
		public String getAnswer() {
			return answer;
		}
		public String getCity() {
			return City;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public void setUserMobile(String userMobile) {
			this.userMobile = userMobile;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
		public void setUserDOB(LocalDate userDOB) {
			this.userDOB = userDOB;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public void setSquestion(String squestion) {
			Squestion = squestion;
		}
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public void setCity(String city) {
			City = city;
		}
		public User(int userID, String userName, String userEmail, String userMobile, String password,
				String confirmpassword, LocalDate userDOB, String gender, String squestion, String answer, String city) {
			super();
			this.userID = userID;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userMobile = userMobile;
			this.password = password;
			this.confirmpassword = confirmpassword;
			this.userDOB = userDOB;
			this.gender = gender;
			Squestion = squestion;
			this.answer = answer;
			City = city;
		}
		
		
		
		public User() {
			super();
		}
		@Override
		public String toString() {
			return "User [userID=" + userID + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobile="
					+ userMobile + ", password=" + password + ", confirmpassword=" + confirmpassword + ", userDOB="
					+ userDOB + ", gender=" + gender + ", Squestion=" + Squestion + ", answer=" + answer + ", City=" + City
					+ "]";
		}

}
