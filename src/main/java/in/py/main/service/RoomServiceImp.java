package in.py.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.py.main.entities.Room;
import in.py.main.repositories.RoomRepository;
import in.py.main.repositories.WorkerRepository;

@Service
public class RoomServiceImp implements RoomService {

   
	@Autowired
	RoomRepository roomRepository;

  
	@Override
	public boolean registerRoom(Room room) 
	{
		try {
			roomRepository.save(room);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public List<Room>getRooms(String city, String roomType, String pincode)
	{
		String cityFilter=(city== null || city.isEmpty())?"":city;
		String roomTypeFilter=(roomType== null || roomType.isEmpty())?"":roomType;
		String pincodeFilter=(pincode==null || pincode.isEmpty())?"":pincode;
		
		return roomRepository.findByCityContainingIgnoreCaseAndRoomTypeContainingIgnoreCaseAndPincodeContainingIgnoreCase(cityFilter, roomTypeFilter, pincodeFilter);
	}
	
   @Override
   public List<Room>getAllRooms()
   {
	   return roomRepository.findAll();
   }
   
   @Override
   public List<Room> getRoomsWithId(int userId)
   {
	   return roomRepository.findByUserId(userId);
   }

}
