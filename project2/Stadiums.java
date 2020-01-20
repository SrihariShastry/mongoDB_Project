package project2;

public class Stadiums {
	String stadiumID,stadiumName,stadiumCity,stadiumCapacity;

	/**
	 * @param stadiumID
	 * @param stadiumName
	 * @param stadiumCity
	 * @param stadiumCapacity
	 */
	public Stadiums(String stadiumID, String stadiumName, String stadiumCity, String stadiumCapacity) {
		super();
		this.stadiumID = stadiumID;
		this.stadiumName = stadiumName;
		this.stadiumCity = stadiumCity;
		this.stadiumCapacity = stadiumCapacity;
	}

	public String getStadiumID() {
		return stadiumID;
	}

	public void setStadiumID(String stadiumID) {
		this.stadiumID = stadiumID;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumCity() {
		return stadiumCity;
	}

	public void setStadiumCity(String stadiumCity) {
		this.stadiumCity = stadiumCity;
	}

	public String getStadiumCapacity() {
		return stadiumCapacity;
	}

	public void setStadiumCapacity(String stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}
	

}
