package in.py.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import in.py.main.entities.Dairy;
import in.py.main.service.DairyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/dairy")


public class MyRestDairyController {
	
	@Autowired
	DairyService dairyService;
	
	@GetMapping("/search")
	public List<Dairy>getDairy(@RequestParam(required = false) String city, @RequestParam(required = false) String pincode)
	{
		return dairyService.getDairy(city, pincode);
	}

}
