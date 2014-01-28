package de.malte_bublitz.itc.kontoauszug;

import de.malte_bublitz.itc.kontoauszug.Konto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.Timestamp;

public class Buchung {
	private int betrag;
	public void aufKonto(Konto k) throws SQLException {
		Connection con       = null;
		PreparedStatement st = null;
		String    url        = "jdbc:mysql://gallifrey.tardis.malte-bublitz.de:3306/konto";
		String    user       = "konto";
		String    password   = "9767";
		Date      date       = new Date();
		Object    mysqlNow   = new Timestamp(date.getTime());
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.prepareStatement("INSERT INTO buchungen (kontonr, betrag, datum) VALUES (?, ?, ?)");
			st.setString(1, k.getKontonr());
			st.setInt(2, this.betrag);
			st.setObject(3, mysqlNow);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
	}
	public Buchung(int betrag) {
		this.betrag = betrag;
	}
}
