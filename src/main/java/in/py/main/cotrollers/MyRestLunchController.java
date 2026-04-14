package in.py.main.cotrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.py.main.entities.Lunch;
import in.py.main.service.LunchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/lunch")

public class MyRestLunchController {
	
	@Autowired
	LunchService lunchService;
	@GetMapping("/search")
	public List<Lunch>getLunch(@RequestParam(required =false) String city, @RequestParam(required=false) String pincode)
	{
		return lunchService.getLunchs(city, pincode);
	}
	
	
	
}
