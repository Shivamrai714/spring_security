package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.models.User;
import com.learn.repo.UserRepository;

@SpringBootApplication
public class SpringBootSecurityLearnApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLearnApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	
		User user= new User();
		user.setEmail("r@gmail.com");
		user.setUsername("rohit");
		user.setPassword(this.bCryptPasswordEncoder.encode("rohit"));
		user.setRole("ROLE_NORMAL");
		
		
		userRepository.save(user);
		
		User user1= new User();
		user1.setUsername("shivam");
		user1.setEmail("s@gmail.com");
		user1.setPassword(this.bCryptPasswordEncoder.encode("shivam"));
		user1.setRole("ROLE_ADMIN");
		
		
		userRepository.save(user1);
		
		
	}

}
