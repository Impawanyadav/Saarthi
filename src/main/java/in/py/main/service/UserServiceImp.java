package in.py.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.py.main.entities.User;
import in.py.main.repostories.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public boolean registerUser(User user)
	{
		try {
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
		if(validUser!=null && validUser.getPassword().equals(password)) 
		{
			return validUser;
		
		}
		return null;
		
	}

}
