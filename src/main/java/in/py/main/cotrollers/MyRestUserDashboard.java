package in.py.main.cotrollers;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.py.main.entities.Dairy;
import in.py.main.entities.Lunch;
import in.py.main.entities.Room;
import in.py.main.entities.Worker;
import in.py.main.service.DairyService;
import in.py.main.service.LunchService;
import in.py.main.service.RoomService;
import in.py.main.service.WorkerService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/userDashboard")
public class MyRestUserDashboard {
	
	@Autowired
	RoomService roomService;
	@Autowired
	WorkerService workerService;
	@Autowired
	DairyService dairyService;
	@Autowired
	LunchService lunchService;
	
	@GetMapping("/rooms")
	public List<Room> getRoomById(HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");
		
	    return roomService.getRoomsWithId(userId);

	}
	
	@GetMapping("/dairy")
	public List<Dairy> getDairyById(HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");
		return dairyService.getDairyById(userId);
	}
	
	@GetMapping("/lunch")
	public List<Lunch> getLunchById(HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");
		return lunchService.getLunchById(userId);
	}
	
	@GetMapping("/worker")
	public List<Worker> getWorkerById(HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");
		return workerService.getWorkerById(userId);
	}
	

}
