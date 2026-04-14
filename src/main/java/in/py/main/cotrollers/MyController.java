package in.py.main.cotrollers;

import java.lang.ProcessBuilder.Redirect;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.py.main.entities.Dairy;
import in.py.main.entities.Lunch;
import in.py.main.entities.Room;
import in.py.main.entities.User;
import in.py.main.entities.Worker;
import in.py.main.repostories.UserRepository;
import in.py.main.service.DairyService;
import in.py.main.service.LunchService;
import in.py.main.service.RoomService;
import in.py.main.service.UserService;
import in.py.main.service.WorkerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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


}
