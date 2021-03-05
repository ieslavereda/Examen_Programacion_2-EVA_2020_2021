package es.ieslavereda.examen;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		File file = new File("myFile");

		MyList<Restaurant> l = new MyList<Restaurant>();

		l.add(new Restaurant("Chistu", 23.10045, 0.39942, 4));
		l.add(new Restaurant("Los Gauchos", 3.124455, -0.234242, 1));
		l.add(new Restaurant("Diverxo", 23.129455, 0.4242, 5));

		l.store(file);

		l.remove(1);

		System.out.println(l.sort());

		System.out.println(l.sort((p1, p2) -> p2.getstars() - p1.getstars()));

		// Not necessary. Only to test
		l = new MyList<Restaurant>();
		
		l.load(file);
		
		// Not necessary. Only to test
		System.out.println(l.print());

	}

}
