package es.ieslavereda.examen;

import java.io.Serializable;

public abstract class Place implements Comparable<Place>, Serializable {
	
	private String title;
	private double lat;
	private double lon;
	
	public Place(String title, double lat, double lon) {
		this.title = title;
		this.lat = lat;
		this.lon = lon;
	}

	protected double getLat() {
		return lat;
	}

	protected double getLon() {
		return lon;
	}

	protected String getTitle() {
		return title;
	}
	
	@Override
	public int compareTo(Place p) {
		return title.compareToIgnoreCase(p.title);
	}

}
