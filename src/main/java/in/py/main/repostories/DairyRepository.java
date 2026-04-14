package in.py.main.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.py.main.entities.Dairy;
import in.py.main.entities.Lunch;

public interface DairyRepository extends JpaRepository<Dairy, Integer> {
	List<Dairy> findByCityContainingIgnoreCaseAndPincodeContainingIgnoreCase(String city, String pincode);
    List<Dairy> findById(int id);

}
