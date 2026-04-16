package in.py.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.py.main.entities.User;
import java.util.List;




public interface UserRepository  extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	User findById(int id);

}
