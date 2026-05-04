package in.py.main.service;

import java.util.List;

import in.py.main.entities.Dairy;

public interface DairyService {
	public boolean registerDairy(Dairy dairy);
	public List<Dairy> getDairy(String city, String pincode);
	public List<Dairy> getAllDairy();
	public List<Dairy> getDairyById(int userId);
	public Dairy getUserDairy(int id);
	public void deleteListing(int id);

}
