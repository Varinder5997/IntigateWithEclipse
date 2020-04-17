package entity;

public class Doctor {

	int doctorId;

	String doctorName;

	double salary;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Doctor(int doctorId, String doctorName, double salary) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", salary=" + salary + "]";
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
