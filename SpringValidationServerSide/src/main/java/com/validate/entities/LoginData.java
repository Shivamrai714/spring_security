package com.validate.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginData {

	
@NotBlank( message =  "user name can't be empty")
@Size(min=4 ,max=20 , message = "usename must be between 4 to 20")
private String userName;

@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
private String email;

@AssertTrue(message = "must agree t & c ")
private boolean agreed;           //for checkbox




public boolean isAgreed() {
	return agreed;
}
public void setAgreed(boolean agreed) {
	this.agreed = agreed;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "LoginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
}

}
