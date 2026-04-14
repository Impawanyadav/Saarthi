package in.py.main.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.py.main.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
	List<Room> findByCityContainingIgnoreCaseAndRoomTypeContainingIgnoreCaseAndPincodeContainingIgnoreCase(String city, String roomType, String pincode);
    List<Room> findByUserId(int userId);
}
