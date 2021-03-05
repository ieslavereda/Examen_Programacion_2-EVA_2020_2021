package es.ieslavereda.examen;

import java.io.Serializable;

public class Restaurant extends Place implements Serializable {

	private int stars;

	public Restaurant(String title, double lat, double lon, int stars) {
		super(title, lat, lon);
		this.stars = stars;
	}

	public int getstars() {
		return stars;
	}

	public void setstars(int stars) {
		this.stars = stars;
	}

	public double getLat() {
		return this.getLat();
	}

	public double getLon() {
		return this.getLon();
	}

	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < stars; i++)
			s += "*";

		return getTitle() + " " + s;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Restaurant) {
			
			Restaurant r = (Restaurant) o;
			
			return r.getLat() == getLat() && r.getLon() == getLon();
			
		} else
			return false;
	}

}
