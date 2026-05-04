package in.py.main.service;

import java.util.List;

import in.py.main.entities.Room;

public interface RoomService {
	
	public boolean registerRoom(Room room); 
	public List<Room> getRooms(String city, String roomType, String pincode);
	public List<Room> getAllRooms();
	public List<Room> getRoomsWithId(int userId);
	public Room getRoomId(int id);
	public void deleteListing(int id);
		
	

}
