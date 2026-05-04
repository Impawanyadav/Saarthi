package in.py.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.py.main.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	List<Room> findByCityContainingIgnoreCaseAndRoomTypeContainingIgnoreCaseAndPincodeContainingIgnoreCase(String city, String roomType, String pincode);
    List<Room> findByUserId(int userId);
    public Room findById(int id);
    void deleteById(int id);
}
