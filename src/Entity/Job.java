package Entity;

public class Job {
	private String Job_ID;
	private String Name;

	public Job(String job_ID, String name) {
		super();
		Job_ID = job_ID;
		Name = name;
	}

	public String getJob_ID() {
		return Job_ID;
	}

	public void setJob_ID(String job_ID) {
		Job_ID = job_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String toString() {
		return Name;
	}
}
