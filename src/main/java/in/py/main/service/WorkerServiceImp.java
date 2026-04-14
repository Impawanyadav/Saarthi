package in.py.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.py.main.entities.Worker;
import in.py.main.repostories.WorkerRepository;
@Service
public class WorkerServiceImp implements WorkerService {
	
	@Autowired
	WorkerRepository workerRepository;
	@Override
	public boolean registerWorker(Worker worker){
		try {
			workerRepository.save(worker);
			return true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
	@Override
	public List<Worker>searchWorkers(String city, String work)
	{
		String cityFilter=(city== null || city.isEmpty())?"":city;
		String workFilter=(work== null || work.isEmpty())?"":work;
		
		return workerRepository.findByCityContainingIgnoreCaseAndWorkContainingIgnoreCase(cityFilter, workFilter);
	}
	@Override
	public List<Worker>getAllJobs()
	{
		return workerRepository.findAll();
	}
	
	@Override
	public List<Worker> getWorkerById(int id)
	{
		return workerRepository.findById(id);
	}

}
