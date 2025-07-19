package kr.co.bidworks.review3_myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

	public boolean authenticate(String username, String password) {
		System.out.println("name: " + username + ", pwd: " + password);
		boolean isValidUsername = username.equalsIgnoreCase("veronika");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		System.out.println("isValidUsername:" + isValidUsername);

		return isValidUsername && isValidPassword;
	}
}
