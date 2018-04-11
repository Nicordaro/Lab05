package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DizionarioDAO {

	// private List<String> dizionario = new ArrayList<>();

	public List<String> getTutteLeParole() {

		final String sql = "SELECT * FROM parola";

		List<String> dizionario = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String parola = rs.getString("nome");

				// System.out.println(parola);

				dizionario.add(parola);
			}

			return dizionario;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
