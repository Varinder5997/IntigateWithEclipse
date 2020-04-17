package entity;

import java.util.Set;

public class Hospital {

	private int id;

	private String hospitalName;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}



	
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName +  "]";
	}

	public Hospital(int id, String hospitalName, double hospitalRevenue, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.hospitalName = hospitalName;

	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

}
