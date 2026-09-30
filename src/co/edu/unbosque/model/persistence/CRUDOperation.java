package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface CRUDOperation<E> {
	
	
	public void create(E data);
	public String readAll();
	public String update(int index,E newData);
	public String eliminarId(long id);
	public ArrayList<String> buscarNumeroId(long id);
	
}
