package de.malte_bublitz.itc.kontoauszug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import de.malte_bublitz.util.ANSIConsole;

public class Konto {
	private String kontonr;
	private String inhaber;
	private int zinssatz;
	
	public String getKontonr() {
		return this.kontonr;
	}
	public String getInhaber() {
		return this.inhaber;
	}
	public void setInhaber(String inhaberNeu) {
		this.inhaber = inhaberNeu;
		try {
			syncDatabase();
		} catch (SQLException e) {
		}
	}
	public int getZinssatz() {
		return this.zinssatz;
	}
	public void setZinssatz(int zinssatzNeu) {
		this.zinssatz = zinssatzNeu;
		try {
			syncDatabase();
		} catch (SQLException e) {
		}
	}
	public void zeigeAuszug(int limit) throws SQLException {
		ANSIConsole c         = new ANSIConsole();
		Connection  con       = null;
		PreparedStatement st  = null;
		ResultSet   rs        = null;
		String      url       = "jdbc:mysql://gallifrey.tardis.malte-bublitz.de:3306/konto";
		String      user      = "konto";
		String      password  = "9767";
		Date        d         = new Date();
		DateFormat  df        = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat  df_day    = new SimpleDateFormat("dd");
		DateFormat  df_month  = new SimpleDateFormat("MM");
		DateFormat  df_year   = new SimpleDateFormat("yyyy");
		String      day_old   = "01";
		String      month_old = "";
		String      year_old  = "";
		double      saldo     = 0.0;
		double      zinsen    = 0.0;
		double      zinszahl  = 0.0;
		con = DriverManager.getConnection(url, user, password);
		st = con.prepareStatement("SELECT datum,betrag FROM buchungen WHERE kontonr=? ORDER BY datum");
		st.setString(1, kontonr);
		rs = st.executeQuery();
		c.println("\nKontoauszug für: "+this.inhaber+" ("+this.kontonr+")\n");
		c.println("Datum      | Betrag    | Saldo neu | Anmerkung");
		c.println("-----------+-----------+-----------+-------------");
		while (rs.next()) {
			// neues Saldo berechnen
			saldo += rs.getInt(2);
			// Neuer Monat? Zinsen für letzten Monat berechnen und Zinszahl zurücksetzen
			if (!month_old.equals("") && !month_old.equals(df_month.format(rs.getDate(1)))) {
				// Zinsen berechnen
				zinsen = zinszahl / (360/this.zinssatz);
				c.print(year_old+"-"+month_old+"-31 | ");
				saldo += zinsen;
				System.out.format(
						"%9.2f | %9.2f | Zinsen\n",
						zinsen,
						saldo
						);
				// Zinszahl zurücksetzen
				zinszahl  = 0.0;
				day_old   = "01";
			}
			// Ausgabe
			c.print(df.format(rs.getDate(1)) + " | ");
			if (rs.getInt(2)<0)
				c.setForegroundColor("RED");
			else
				c.setForegroundColor("GREEN");
			System.out.format(
					"%9.2f",
					(double)rs.getInt(2)
					);
			c.setAttribute("RESET");
			c.print(" | ");
			if (saldo < 0)
				c.setForegroundColor("RED");
			System.out.format(
					"%9.2f",
					saldo
					);
			if (saldo < 0)
				c.setAttribute("RESET");
			c.println(" | Buchung");
			// neue zinszahl berechnen
			zinszahl += (
					saldo * (
						Integer.parseInt(
							df_day.format(rs.getDate(1))
							)
						-Integer.parseInt(day_old)
						)) / 100;
			day_old   = df_day.format(rs.getDate(1));
			month_old = df_month.format(rs.getDate(1));
			year_old  = df_year.format(rs.getDate(1));
		}
		c.print("\nSaldo                    ");
		System.out.format("%9.2f", saldo);
		c.println("\n");
	}
	private void syncDatabase() throws SQLException {
		Connection con     = null;
		PreparedStatement st       = null;
		String    url      = "jdbc:mysql://gallifrey.tardis.malte-bublitz.de:3306/konto";
		String    user     = "konto";
		String    password = "9767";
		con = DriverManager.getConnection(url, user, password);
		st = con.prepareStatement("UPDATE konten SET inhaber=?, zinssatz=? WHERE id=?");
		st.setString(1, inhaber);
		st.setInt(2, zinssatz);
		st.setString(3, kontonr);
		st.executeUpdate();
		st.close();
		con.close();
	}
	public static Konto neuesKontoFactory(String kontonr, String inhaber, int zinssatz) throws SQLException {
		Connection con     = null;
		PreparedStatement st       = null;
		String    url      = "jdbc:mysql://localhost/konto";
		String    user     = "konto";
		String    password = "9767";
		con = DriverManager.getConnection(url, user, password);
		st = con.prepareStatement("INSERT INTO konten VALUES (?, ?, ?)");
		st.setString(1, kontonr);
		st.setString(2, inhaber);
		st.setInt(3, zinssatz);
		System.out.println(st);
		st.executeUpdate();
		st.close();
		con.close();
		return new Konto(kontonr);
	}
	public Konto(String kontonr) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://gallifrey.tardis.malte-bublitz.de:3306/konto";
		String user = "konto";
		String password = "9767";
		
		con = DriverManager.getConnection(url, user, password);
		st = con.prepareStatement("SELECT id,inhaber,zinssatz FROM konten WHERE id=?");
		st.setString(1, kontonr);
		rs = st.executeQuery();
		
		if (rs.next()) {
			this.kontonr = kontonr;
			this.inhaber = rs.getString(2);
			this.zinssatz = rs.getInt(3);
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
