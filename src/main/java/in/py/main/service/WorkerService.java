package in.py.main.service;

import java.util.List;

import in.py.main.entities.Worker;

public interface WorkerService {
	public boolean registerWorker(Worker worker);
	public List<Worker>searchWorkers(String city, String work);
	public List<Worker>getAllJobs();
	public List<Worker>getWorkerById(int userId);
	public Worker getUserWorker(int id);
	public void deleteListing(int id);

}
