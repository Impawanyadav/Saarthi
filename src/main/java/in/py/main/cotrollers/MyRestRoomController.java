package in.py.main.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.py.main.entities.Room;
import in.py.main.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class MyRestRoomController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping
	public List<Room>getAllRooms()
	{
		return roomService.getAllRooms();
	}
	
	@GetMapping("/search")
	public List<Room>getRooms(@RequestParam(required = false) String city, @RequestParam(required = false) String roomType, @RequestParam(required = false) String pincode)
	{
		return roomService.getRooms(city, roomType, pincode);
	}

}
