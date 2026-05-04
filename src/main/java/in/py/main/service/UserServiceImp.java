package in.py.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.py.main.entities.User;
import in.py.main.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public boolean registerUser(User user)
	{
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepository.save(user);
			return true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	@Override
	public User loginUser(String email, String password)
	{
		User validUser=userRepository.findByEmail(email);
		if (validUser != null && encoder.matches(password, validUser.getPassword()))
		{
			return validUser;
		
		}
		return null;
		
	}

}
