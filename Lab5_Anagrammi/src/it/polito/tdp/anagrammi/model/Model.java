package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {

	DizionarioDAO dDao = new DizionarioDAO();
	List<String> dizionario = dDao.getTutteLeParole();

	private List<String> soluzione;
	private String ptemp = "";

	public List<String> findSoluzione(String inserita) {

		soluzione = new ArrayList<String>();

		recursive(ptemp, inserita, inserita, 0);

		return soluzione;
	}

	private void recursive(String parziale, String inserita, String daTogliere, int livello) {

		if (parziale.length() >= inserita.length()) {
			if (!soluzione.contains(parziale)) {
				// soluzione completa
				soluzione.add(new String(parziale));
				System.out.println(parziale);
			}
		}

		for (int i = 0; i < daTogliere.length(); i++) {
			StringBuilder sb = new StringBuilder(daTogliere);
			sb.deleteCharAt(i);
			recursive(parziale + daTogliere.charAt(i), inserita, sb.toString(), livello + 1);
		}

	}

	public List<String> anagrammiCorretti() {
		List<String> lista = new ArrayList<String>();
		for (String s : this.soluzione) {
			if (this.dizionario.contains(s))
				lista.add(s);
		}
		return lista;
	}

	public List<String> anagrammiErrati() {
		List<String> lista = new ArrayList<String>();
		for (String s : this.soluzione) {
			if (!this.dizionario.contains(s))
				lista.add(s);
		}
		return lista;
	}

}
