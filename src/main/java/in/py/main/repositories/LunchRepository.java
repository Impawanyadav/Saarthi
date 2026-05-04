package in.py.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.py.main.entities.Lunch;
import in.py.main.entities.Room;

public interface LunchRepository extends JpaRepository<Lunch, Integer> {
	List<Lunch> findByCityContainingIgnoreCaseAndPincodeContainingIgnoreCase(String city, String pincode);
    List<Lunch> findByUserId(int userId);
    public Lunch findById(int id);
    void deleteById(int id);
}
