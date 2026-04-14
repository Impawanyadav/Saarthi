package in.py.main.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.py.main.entities.Worker;
import in.py.main.service.WorkerService;

@RestController
@RequestMapping("/api/worker")

public class MyRestController {
	
	@Autowired
	WorkerService workerService;
	
	@GetMapping
	public List<Worker> getAllWorkers()
	{
		return workerService.getAllJobs();
	}
	
	@GetMapping("/search")
	public List<Worker> searchWorkers(@RequestParam(required = false) String city, @RequestParam(required = false) String work)
	{
		return workerService.searchWorkers(city, work);
	}

}
