package dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.Doctor;
import entity.Hospital;
import exception.DaoException;

public interface DoctorDao {

	/**
	 * @param hospitalId
	 * @return Set of doctors of particular hospital from database
	 * @throws DaoException 
	 */
	public Set<Doctor> retreiveDoctor(int hospitalId) throws DaoException;

	/**
	 * @return List of doctors from database
	 * @throws DaoException 
	 */
	public List<Doctor> maxSalary() throws DaoException;

	/**
	 * @return Set of hospital from the database
	 * @throws DaoException 
	 */
	public Map<Hospital,Integer> getAllHospitals() throws DaoException;
	
	/**
	 * @return List of doctors from the database
	 */
	//public List<Doctor> getAllDoctors();

}
