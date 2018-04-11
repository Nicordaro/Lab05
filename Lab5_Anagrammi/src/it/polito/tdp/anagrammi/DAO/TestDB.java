package it.polito.tdp.anagrammi.DAO;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * This is a main to check the DB connection
		 */

		DizionarioDAO ddao = new DizionarioDAO();
		ddao.getTutteLeParole();
		// System.out.println("prova2");
		// sdao.getTuttiGliStudenti();

	}

}
