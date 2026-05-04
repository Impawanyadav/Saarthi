package in.py.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.py.main.entities.Lunch;
import in.py.main.repositories.LunchRepository;

@Service
public class LunchServiceImp implements LunchService{
	@Autowired
	LunchRepository lunchRepository;
	@Override
	public boolean registerLunch(Lunch lunch){
		try {
			lunchRepository.save(lunch);
			return true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	@Override
	public List<Lunch> getLunchs(String city, String pincode)
	{
		String cityFilter=(city==null || city.isEmpty())?"":city;
		String pincodeFilter=(pincode==null || pincode.isEmpty())?"":pincode;
		
		return lunchRepository.findByCityContainingIgnoreCaseAndPincodeContainingIgnoreCase(cityFilter, pincodeFilter);
	}
	 @Override
	 public List<Lunch> getAllLunch()
	 {
		 return lunchRepository.findAll();
	 }
	 
	 @Override
	 public List<Lunch> getLunchById(int userId)
	 {
		 return lunchRepository.findByUserId(userId);
		 
	 }
	 
	 @Override
	 public Lunch getUserLunch(int id)
	 {
		 return lunchRepository.findById(id);
	 }
	 
	 @Override
	 public void deleteListing(int id)
	{
		 lunchRepository.deleteById(id);
			
	}
	


}
