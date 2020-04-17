package service;

import java.util.Map;
import java.util.Set;

import entity.Doctor;
import entity.Hospital;
import exception.ServiceException;

public interface DoctorService {

	
	
	/**
	 * @param hospitalId
	 * @return set of doctor of particular hospital
	 * @throws ServiceException 
	 */
	public Set<Doctor> getDoctors(int hospitalId) throws ServiceException; 
	
	/**
	 * @return doctor having maximum salary
	 * @throws ServiceException 
	 */
	public Doctor maxSalary() throws ServiceException;
	
	/**
	 * @return Map containing Hospital as a key and count of it's doctor as a value
	 * @throws ServiceException 
	 */
	public Map<Hospital, Integer> getHospitalsWithDoctorCount() throws ServiceException;
	
}
