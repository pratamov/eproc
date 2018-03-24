package id.noeandfriends.eproc.model.external;

public class AtmLocationRequest {
	
	private double latitude;
	private double longitude;
	private int radius_per_km;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getRadius_per_km() {
		return radius_per_km;
	}
	public void setRadius_per_km(int radius_per_km) {
		this.radius_per_km = radius_per_km;
	}
	
	
	
}
