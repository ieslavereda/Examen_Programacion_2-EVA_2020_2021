package es.ieslavereda.examen;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyList<T> implements MyStore<T>, Serializable {

	private Nodo<T> head;
	private int size;

	@Override
	public void add(T e) {

		Nodo<T> n = new Nodo<T>(e);

		if (head == null) {
			head = n;
		} else {
			n.setNext(head);
			head = n;
		}

		size++;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size)
			return null;
		else if (index == 0) {
			return head.getInfo();
		} else {
			Nodo<T> aux = head;

			for (int i = 0; i < size; i++)
				aux = aux.getNext();

			return aux.getInfo();
		}
	}

	@Override
	public T remove(int index) {

		T e;

		if (index < 0 || index >= size)
			return null;
		else if (index == 0) {

			e = head.getInfo();
			head = head.getNext();
			size--;

			return e;
		} else {
			Nodo<T> aux = head;

			for (int i = 0; i < index - 1; i++)
				aux = aux.getNext();

			e = aux.getNext().getInfo();
			aux.setNext(aux.getNext().getNext());
			size--;

			return aux.getInfo();
		}
	}

	@Override
	public String print() {
		String text = "";
		text += "Size: " + size + "\n";
		text += "Values: ";

		Nodo<T> aux = head;

		while (aux != null) {
			text += aux.getInfo() + " ";
			aux = aux.getNext();
		}

		return text;
	}

	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void store(File f) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {

			oos.writeObject(this);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void load(File f) {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {

			MyList<T> l = (MyList<T>) ois.readObject();
			this.head = l.head;
			this.size = l.size;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private ArrayList<T> getList() {

		ArrayList<T> arrayList = new ArrayList<T>();
		Nodo<T> aux = head;
		
		while (aux != null) {
			arrayList.add(aux.getInfo());
			aux = aux.getNext();
		}

		return arrayList;

	}

	@Override
	public List<T> sort() {
		
		List<T> arrayList = getList();
		Collections.sort((List)arrayList);
		
		return arrayList;
	}

	@Override
	public ArrayList<T> sort(Comparator<T> c) {
		
		ArrayList<T> arrayList = getList();
		arrayList.sort(c);
		
		return arrayList;
	}

	@Override
	public boolean contains(T e) {
		
		boolean exists = false;
		Nodo<T> aux = head;
		
		while(aux!=null && !exists) {
			
			if(aux.getInfo().equals(e))
				exists=true;
			
			aux = aux.getNext();
		}		
		
		return exists;
	}

}
