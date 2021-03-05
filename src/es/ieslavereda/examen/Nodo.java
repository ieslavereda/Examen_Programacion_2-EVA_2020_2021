package es.ieslavereda.examen;

import java.io.Serializable;

public class Nodo<T> implements Serializable {

	private T info;
	private Nodo<T> next;
	
	public Nodo(T e) {
		this.info = e;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}
	
	public String toString() {
		return info.toString();
	}
}
