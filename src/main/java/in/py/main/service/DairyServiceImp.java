package in.py.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.py.main.entities.Dairy;
import in.py.main.repositories.DairyRepository;

@Service
public class DairyServiceImp implements DairyService {
	@Autowired
	DairyRepository dairyRepository;
	@Override
	public boolean registerDairy(Dairy dairy) {
		try {
			dairyRepository.save(dairy);
			return true;
			
			
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	@Override
	public List<Dairy>getDairy(String city,String pincode)
	{
		String cityFilter=(city==null || city.isEmpty())?"":city;
		String pincodeFilter=(pincode==null || pincode.isEmpty())?"":pincode;
		return dairyRepository.findByCityContainingIgnoreCaseAndPincodeContainingIgnoreCase(cityFilter, pincodeFilter);
	}
	
	@Override
	public List<Dairy>getAllDairy()
    {
		return dairyRepository.findAll();
	}
	
	@Override
	public List<Dairy> getDairyById(int userId)
	{
		return dairyRepository.findByUserId(userId);
	}
	
	@Override
	public Dairy getUserDairy(int id)
	{
		return dairyRepository.findById(id);
	}
	
	@Override
	public void deleteListing(int id)
	{
		dairyRepository.deleteById(id);
		
	}

}
