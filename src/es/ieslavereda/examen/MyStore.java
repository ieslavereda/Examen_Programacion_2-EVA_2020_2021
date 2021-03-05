package es.ieslavereda.examen;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public interface MyStore<T> {

	public void add(T e);
	public T get(int index);
	public T remove(int index);
	public int size();
	public void store(File f);
	public void load(File f);
	public String print();
	public boolean contains(T e);
	public List<T> sort();
	public List<T> sort(Comparator<T> c);
	
}
