package in.py.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import in.py.main.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
	List<Worker> findByCityContainingIgnoreCaseAndWorkContainingIgnoreCase(String city, String work);
    List<Worker> findById(int id);

}
