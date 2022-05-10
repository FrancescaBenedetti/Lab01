package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> elenco;
		
	public Parole() {
		elenco = new ArrayList<>();		
	}
	
	public void addParola(String p) {
		elenco.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(elenco);
		return elenco;
	}
	
	public void reset() {
		elenco.clear();
	}
	
	public void cancella(String p) {
		elenco.remove(p);
	}

}
