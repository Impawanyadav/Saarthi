package in.py.main.service;

import in.py.main.entities.User;

public interface UserService {
	public boolean registerUser(User user);
	public User loginUser(String email, String password);

}
