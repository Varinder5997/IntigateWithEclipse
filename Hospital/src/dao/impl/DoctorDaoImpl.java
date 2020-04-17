package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.DoctorDao;
import entity.Doctor;
import entity.Hospital;
import exception.DaoException;
import utility.dbutils.ConnectionUtil;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public Set<Doctor> retreiveDoctor(int hospitalId) throws DaoException {

		Connection connection = ConnectionUtil.getConnection();
		Set<Doctor> doctors = new HashSet<>();
		try {

			String sql = "SELECT doctor_id,Doctor.name,salary from Doctor inner join Hospital on Doctor.hospital_id = Hospital.hospital_id where Hospital.hospital_id=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, hospitalId);

			ResultSet data = statement.executeQuery();

			while (data.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(data.getInt("doctor_id"));
				doctor.setDoctorName(data.getString("name"));
				doctor.setSalary(data.getDouble("salary"));
				doctors.add(doctor);
			}

		} catch (SQLException ex) {
			throw new DaoException();

		} finally {
			ConnectionUtil.closeConnection(connection);
		}

		return doctors;
	}

	@Override
	public List<Doctor> maxSalary() throws DaoException {

		List<Doctor> doctors = new ArrayList<Doctor>();

		Connection connection = ConnectionUtil.getConnection();

		if (connection != null) {
			System.out.println("Connected");
		}
		String sql = "select doctor_id,name,salary from Doctor where salary = All(select max(salary)from Doctor)";

		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(resultSet.getInt("doctor_id"));
				doctor.setDoctorName(resultSet.getString("name"));
				doctor.setSalary(resultSet.getDouble("salary"));
				doctors.add(doctor);
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			throw new DaoException();
		}

		return doctors;
	}

	@Override
	public Map<Hospital, Integer> getAllHospitals() throws DaoException {

		Connection connection = ConnectionUtil.getConnection();

		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		Map<Hospital, Integer> hlist = new HashMap<Hospital, Integer>();
		try {
			// Buisness Logic
			String sql = "select hospital_id,count(hospital_id) from Doctor group by(hospital_id)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				int count = resultSet.getInt(2);
				list.put(id, count);

			}
			Map<Hospital, Integer> map = null;
			for (Map.Entry entry : map.entrySet()) {
				  System.out.println( entry.getKey() + " -> " + entry.getValue() );
				}
			for (Integer key : list.values()) {
				System.out.println(key);
				int i = key;
				String sql1 = "select * from Hospital where hospital_id=?";
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, i);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				while (resultSet1.next()) {
					Hospital hospital = new Hospital();
					hospital.setId(resultSet1.getInt(1));
					hospital.setHospitalName(resultSet1.getString(2));

					hlist.put(hospital, i);

				}
			}
		} catch (Exception e) {
			throw new DaoException();
		}

		return hlist;
	}

	// @Override
	// public List<Doctor> getAllDoctors() {
	// TODO Auto-generated method stub
	// return null;
	// }

	/*
	 * @Override public List<Doctor> getAllDoctors() { // write buisness logic
	 * return null; }
	 */
}
