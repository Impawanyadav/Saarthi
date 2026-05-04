package in.py.main.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.py.main.entities.Dairy;
import in.py.main.entities.Lunch;
import in.py.main.entities.Room;
import in.py.main.entities.User;
import in.py.main.entities.Worker;
import in.py.main.repositories.UserRepository;
import in.py.main.service.DairyService;
import in.py.main.service.LunchService;
import in.py.main.service.RoomService;
import in.py.main.service.UserService;
import in.py.main.service.WorkerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MyController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private WorkerService workerService;
	@Autowired
	private LunchService lunchService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private DairyService dairyService;
	@GetMapping("/reg")
	public String openRegPage(Model model)
	{
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/regForm")
	public String submitRegForm (@ModelAttribute("user") User user, Model model)
	{
		boolean status= userService.registerUser(user);
		return "login";
	}
	@GetMapping("/loginPage")
	public String openLoginPage(Model model)
	{
		model.addAttribute("user",new User());
		return"login";
	}
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user, Model model, HttpSession session)
	{
		
		User validUser=userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser!=null)
		{
			model.addAttribute("modelName", validUser.getName());
			session.setAttribute("usersName",validUser.getName());
			session.setAttribute("userid",validUser.getId());
			
			session.setAttribute("gender", validUser.getGender());
			session.setAttribute("email", validUser.getEmail());
			return "profile";
			
		}
		else return "login";
			
	}
	@GetMapping("/milkDairy")
	public String openDiaryPage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		return "dairy";
	}
	
	@GetMapping("/cleanGarbage")
	public String openGarbagePage()
	{
		return "garbage";
	}
	@GetMapping("/workPage")
	public String openWorkPage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		return "labourer";
	}
	
	@GetMapping("/home")
	public String openProPage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		return "profile";
	}
	
	
	@GetMapping("/roomRent")
	public String openRentPage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		return "rent";
	}
	
	@GetMapping("/tiffinService")
	public String openTiffinPage(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		return "tiffin";
	}
	@GetMapping("/roWater")
	public String openWaterPage()
	{
		return "water";
	}
	
	@GetMapping("/logOut")
	public String logout(HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		return "redirect:/loginPage";
	}
	
	@GetMapping("/uploadJob")
	public String openJobRegister(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		Worker worker = new Worker();
	    worker.setStatus("Not verified");
	    worker.setLikes(0);
	    
		
		model.addAttribute("worker", worker);
		return "labourForm";
	}
	
	
	@PostMapping("/labForm")
	public String submitLabForm(@ModelAttribute("worker") Worker worker, Model model, HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");

	    User user = userRepository.findById(userId).orElse(null);

	    
	    worker.setUser(user); 

	    
		
		boolean status=workerService.registerWorker(worker);
		return "labourer";
	}
	
	
	
	@GetMapping("/uploadLunch")
	public String openLunchRegister(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		Lunch lunch = new Lunch();
	    lunch.setStatus("Not verified");
	    lunch.setLikes(0);
	    
		
		model.addAttribute("lunch", lunch);
		return "lunchForm";
	}
	
	
	@PostMapping("/lunchForm")
	public String submitLunchForm(@ModelAttribute("lunch") Lunch lunch, Model model, HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");

	    User user = userRepository.findById(userId).orElse(null);

	    
	    lunch.setUser(user); 

		
		boolean status=lunchService.registerLunch(lunch);
		return "tiffin";
	}
	
	@GetMapping("/userDashboard")
	public String openUserDashboard(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		
		
		
		return "userDashboard";
	}
	
	@GetMapping("/userDashboardDairy")
	public String openUserDashboardDairy(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		
		
		
		return "userDashboardDairy";
	}
	
	@GetMapping("/userDashboardLunch")
	public String openUserDashboardLunch(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		
		
		
		return "userDashboardLunch";
	}
	
	@GetMapping("/userDashboardWorker")
	public String openUserDashboardWorker(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		
		
		
		return "userDashboardWorker";
	}
	@GetMapping("/uploadRoom")
	public String openRoomRegister(Model model,HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		Room room = new Room();
	    room.setStatus("Not verified");
	    room.setLikes(0);
	    
		
		model.addAttribute("room", room);
		return "roomForm";
	}
	
	
	@PostMapping("/roomForm")
	public String submitLunchForm(@ModelAttribute("room") Room room, Model model, HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");

	    User user = userRepository.findById(userId).orElse(null);

	    
	    room.setUser(user); 

		boolean status=roomService.registerRoom(room);
		return "rent";
	}
	
	@GetMapping("/uploadDairy")
	public String openDairyRegister(Model model, HttpServletRequest request)
	{
		HttpSession session=request.getSession(false);
		if(session==null)return "redirect:/";
		Dairy dairy = new Dairy();
	    dairy.setStatus("Not verified");
	    dairy.setLikes(0);
	    
		
		model.addAttribute("dairy", dairy);
		return "dairyForm";
	}
	
	
	@PostMapping("/dairyForm")
	public String submitDairyForm(@ModelAttribute("dairy") Dairy dairy, Model model, HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userid");

	    User user = userRepository.findById(userId).orElse(null);

	    
	    dairy.setUser(user); 

		
		boolean status=dairyService.registerDairy(dairy);
		return "dairy";
	}
	
	
	
	@GetMapping("/lab2")
	public String openDiaryPa()
	{
		return "lab2";
	}
	
	@GetMapping("/editRoom/{id}")
	
	public String getRoomById(@PathVariable int id, HttpSession session, Model model) {

	    Integer userId = (Integer) session.getAttribute("userid");
	    if (userId == null) return null;

	    
	    Room room = roomService.getRoomId(id);
	    model.addAttribute("room", room);
	    return "editRoom";
	    
	}
	
	
	@PostMapping("/updateRoom")
	public String updateRoom(@ModelAttribute("room") Room room, HttpSession session) {

	    Integer userId = (Integer) session.getAttribute("userid");
	    if (userId == null) return "redirect:/loginPage";

	    User user = userRepository.findById(userId).orElse(null);

	    
	    room.setUser(user);

	    
	    roomService.registerRoom(room);

	    return "redirect:/userDashboard";
	}
	
	
@GetMapping("/editDairy/{id}")
	
	public String getDairyById(@PathVariable int id, HttpSession session, Model model) {

	    Integer userId = (Integer) session.getAttribute("userid");
	    if (userId == null) return null;

	    
	    Dairy dairy = dairyService.getUserDairy(id);
	    model.addAttribute("dairy", dairy);
	    return "editDairy";
	    
	}
@PostMapping("/updateDairy")
public String updateDairy(@ModelAttribute("dairy") Dairy dairy, HttpSession session) {

    Integer userId = (Integer) session.getAttribute("userid");
    if (userId == null) return "redirect:/loginPage";

    User user = userRepository.findById(userId).orElse(null);

   
    dairy.setUser(user);

   
    dairyService.registerDairy(dairy);

    return "redirect:/userDashboardDairy";
}
@GetMapping("/editLunch/{id}")
public String getLunchById(@PathVariable int id, HttpSession session, Model model) {

    Integer userId = (Integer) session.getAttribute("userid");
    if (userId == null) return null;

    
    Lunch lunch = lunchService.getUserLunch(id);
    model.addAttribute("lunch", lunch);
    return "editTiffin";
    
}

@PostMapping("/updateTiffin")
public String updateTiffin(@ModelAttribute("lunch") Lunch lunch , HttpSession session) {

    Integer userId = (Integer) session.getAttribute("userid");
    if (userId == null) return "redirect:/loginPage";

    User user = userRepository.findById(userId).orElse(null);

   
    lunch.setUser(user);

   
    lunchService.registerLunch(lunch);

    return "redirect:/userDashboardLunch";
}

@GetMapping("/editWorker/{id}")
public String getWorkerById(@PathVariable int id, HttpSession session, Model model) {

    Integer userId = (Integer) session.getAttribute("userid");
    if (userId == null) return null;

    
    Worker worker = workerService.getUserWorker(id);
    model.addAttribute("worker", worker);
    return "editWorker";
    
}

@PostMapping("/updateWorker")
public String updateWorker(@ModelAttribute("worker") Worker worker, HttpSession session) {

    Integer userId = (Integer) session.getAttribute("userid");
    if (userId == null) return "redirect:/loginPage";

    User user = userRepository.findById(userId).orElse(null);

   
    worker.setUser(user);

   
    workerService.registerWorker(worker);

    return "redirect:/userDashboardWorker";
}
	
@DeleteMapping("/deleteRoom/{id}")
@ResponseBody
public void deleteRoom(@PathVariable int id) {
    roomService.deleteListing(id);
}

@DeleteMapping("/deleteDairy/{id}")
@ResponseBody
public void deleteDairy(@PathVariable int id) {
    dairyService.deleteListing(id);
}	
	
@DeleteMapping("/deleteLunch/{id}")
@ResponseBody
public void deleteLunch(@PathVariable int id) {
    lunchService.deleteListing(id);
}

@DeleteMapping("/deleteWorker/{id}")
@ResponseBody
public void deleteWorker(@PathVariable int id) {
    workerService.deleteListing(id);
}	


}
