package in.py.main.service;

import java.util.List;

import in.py.main.entities.Lunch;

public interface LunchService {
	
	public boolean registerLunch(Lunch lunch);
	public List<Lunch> getLunchs(String city, String pincode);
	public List<Lunch> getAllLunch();
	public List<Lunch> getLunchById(int userId);
	public Lunch getUserLunch(int id);
	public void deleteListing(int id);
		
	}


