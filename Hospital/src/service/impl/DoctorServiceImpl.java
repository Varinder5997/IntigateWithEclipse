package service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.DoctorDao;
import dao.impl.DoctorDaoImpl;
import entity.Doctor;
import entity.Hospital;
import exception.DaoException;
import exception.ServiceException;
import service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

	private static DoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public Set<Doctor> getDoctors(int hospitalId) throws ServiceException {
		Set<Doctor> doctors;
		try {
			doctors = this.doctorDao.retreiveDoctor(hospitalId);
		} catch (DaoException e) {
			throw new ServiceException();
		}

		return doctors;
	}

	@Override
	public Doctor maxSalary() throws ServiceException {

		List<Doctor> doctors;
		try {
			doctors = this.doctorDao.maxSalary();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		Collections.sort(doctors, new SortBySalary());
		if(doctors.size()==0) {
			System.out.println("No  doctor is Found");
			return  (Doctor) doctors;
		}
		else {
			
		
		return doctors.get(0);
	}
	}
	@Override
	public Map<Hospital, Integer> getHospitalsWithDoctorCount() throws ServiceException {
	
		// write Buisness logic here
		try {
			return this.doctorDao.getAllHospitals();
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

}

//Buisness logic to sort the list
class SortBySalary implements Comparator<Doctor> {

	@Override
	public int compare(Doctor a, Doctor b) {

		return (int) (a.getSalary() + a.getSalary());
	}
}
