package models;

public class Enrollee {

	private String userId;
	private String name;
	private Integer version;
	private String insurance;
	
	public Enrollee() {}
	
	public Enrollee(String[] record) {
        this.userId = record[0];
        this.name = record[1];
        this.version = Integer.valueOf(record[2]);
        this.insurance = record[3];
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getInsurance() {
		return insurance;
	}
	
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	
}
