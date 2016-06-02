package hu.unideb.inf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.database.Database;
import hu.unideb.inf.entity.Weather;

/**
 * This class contains the SQL statements.
 * 
 * @author Tímea Szabó
 *
 */
public class WeatherDAOImpl implements WeatherDAO {

	/**
	 * Needs for logging.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WeatherDAOImpl.class);

	@Override
	public List<Weather> getAllWeathersBetween(LocalDate from, LocalDate to) {

		List<Weather> result = new ArrayList<>();

		/*
		 * try (Connection con = Database.connect()) { Statement statement =
		 * con.createStatement(); ResultSet resultSet = statement.executeQuery(
		 * "SELECT * FROM DEBRECEN WHERE EXTRACT(month FROM DATUM) >= " +
		 * from.getMonthValue() + " AND EXTRACT(month FROM DATUM) <=" +
		 * to.getMonthValue() + " AND EXTRACT(day FROM DATUM) >= " +
		 * from.getDayOfMonth() + " AND EXTRACT(day FROM DATUM) <=" +
		 * to.getDayOfMonth());
		 * 
		 * while (resultSet.next()) { result.add(new
		 * Weather(resultSet.getDate("DATUM").toLocalDate(),
		 * resultSet.getDouble("D_TA"), resultSet.getDouble("D_TX"),
		 * resultSet.getDouble("D_TN"), resultSet.getDouble("D_RS"),
		 * resultSet.getDouble("D_SS"))); }
		 * 
		 * 
		 * } catch (SQLException e) { LOG.error(
		 * "There was an error during SQL query.", e); }
		 */

		try (Connection con = Database.connect()) {
			Statement statement1 = con.createStatement();
			Statement statement2 = con.createStatement();
			Statement statement3 = con.createStatement();
			Statement statement4 = con.createStatement();
			Statement statement5 = con.createStatement();
			Statement statement6 = con.createStatement();
			Statement statement7 = con.createStatement();
			Statement statement8 = con.createStatement();
			Statement statement9 = con.createStatement();
			Statement statement0 = con.createStatement();

			// leap years
			// 1992
			ResultSet resultSet92 = statement2.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1992-"
					+ from.getMonthValue() + "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1992-"
					+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
			while (resultSet92.next()) {
				result.add(new Weather(resultSet92.getDate("DATUM").toLocalDate(), resultSet92.getDouble("D_TA"),
						resultSet92.getDouble("D_TX"), resultSet92.getDouble("D_TN"), resultSet92.getDouble("D_RS"),
						resultSet92.getDouble("D_SS")));
			}
			// 1996
			ResultSet resultSet96 = statement6.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1996-"
					+ from.getMonthValue() + "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1996-"
					+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
			while (resultSet96.next()) {
				result.add(new Weather(resultSet96.getDate("DATUM").toLocalDate(), resultSet96.getDouble("D_TA"),
						resultSet96.getDouble("D_TX"), resultSet96.getDouble("D_TN"), resultSet96.getDouble("D_RS"),
						resultSet96.getDouble("D_SS")));
			}
			// 2000
			ResultSet resultSet00 = statement0.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('2000-"
					+ from.getMonthValue() + "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('2000-"
					+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
			while (resultSet00.next()) {
				result.add(new Weather(resultSet00.getDate("DATUM").toLocalDate(), resultSet00.getDouble("D_TA"),
						resultSet00.getDouble("D_TX"), resultSet00.getDouble("D_TN"), resultSet00.getDouble("D_RS"),
						resultSet00.getDouble("D_SS")));
			}

			// not leap years
			if (!(from.getMonthValue() == 2 && from.getDayOfMonth() == 29 && to.getMonthValue() == 2
					&& to.getDayOfMonth() == 29)) {
				// 1991
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet91 = statement1.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1991-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1991-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet91.next()) {
						result.add(
								new Weather(resultSet91.getDate("DATUM").toLocalDate(), resultSet91.getDouble("D_TA"),
										resultSet91.getDouble("D_TX"), resultSet91.getDouble("D_TN"),
										resultSet91.getDouble("D_RS"), resultSet91.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet91 = statement1
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1991-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1991-02-28','YYYY-MM-DD')");
					while (resultSet91.next()) {
						result.add(
								new Weather(resultSet91.getDate("DATUM").toLocalDate(), resultSet91.getDouble("D_TA"),
										resultSet91.getDouble("D_TX"), resultSet91.getDouble("D_TN"),
										resultSet91.getDouble("D_RS"), resultSet91.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet91 = statement1
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1991-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1991-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet91.next()) {
						result.add(
								new Weather(resultSet91.getDate("DATUM").toLocalDate(), resultSet91.getDouble("D_TA"),
										resultSet91.getDouble("D_TX"), resultSet91.getDouble("D_TN"),
										resultSet91.getDouble("D_RS"), resultSet91.getDouble("D_SS")));
					}
				}
				// 1993
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet93 = statement3.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1993-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1993-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet93.next()) {
						result.add(
								new Weather(resultSet93.getDate("DATUM").toLocalDate(), resultSet93.getDouble("D_TA"),
										resultSet93.getDouble("D_TX"), resultSet93.getDouble("D_TN"),
										resultSet93.getDouble("D_RS"), resultSet93.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet93 = statement3
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1993-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1993-02-28','YYYY-MM-DD')");
					while (resultSet93.next()) {
						result.add(
								new Weather(resultSet93.getDate("DATUM").toLocalDate(), resultSet93.getDouble("D_TA"),
										resultSet93.getDouble("D_TX"), resultSet93.getDouble("D_TN"),
										resultSet93.getDouble("D_RS"), resultSet93.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet93 = statement3
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1993-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1993-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet93.next()) {
						result.add(
								new Weather(resultSet93.getDate("DATUM").toLocalDate(), resultSet93.getDouble("D_TA"),
										resultSet93.getDouble("D_TX"), resultSet93.getDouble("D_TN"),
										resultSet93.getDouble("D_RS"), resultSet93.getDouble("D_SS")));
					}
				}
				// 1994
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet94 = statement4.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1994-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1994-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet94.next()) {
						result.add(
								new Weather(resultSet94.getDate("DATUM").toLocalDate(), resultSet94.getDouble("D_TA"),
										resultSet94.getDouble("D_TX"), resultSet94.getDouble("D_TN"),
										resultSet94.getDouble("D_RS"), resultSet94.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet94 = statement4
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1994-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1994-02-28','YYYY-MM-DD')");
					while (resultSet94.next()) {
						result.add(
								new Weather(resultSet94.getDate("DATUM").toLocalDate(), resultSet94.getDouble("D_TA"),
										resultSet94.getDouble("D_TX"), resultSet94.getDouble("D_TN"),
										resultSet94.getDouble("D_RS"), resultSet94.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet94 = statement4
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1994-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1994-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet94.next()) {
						result.add(
								new Weather(resultSet94.getDate("DATUM").toLocalDate(), resultSet94.getDouble("D_TA"),
										resultSet94.getDouble("D_TX"), resultSet94.getDouble("D_TN"),
										resultSet94.getDouble("D_RS"), resultSet94.getDouble("D_SS")));
					}
				}
				// 1995
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet95 = statement5.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1995-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1995-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet95.next()) {
						result.add(
								new Weather(resultSet95.getDate("DATUM").toLocalDate(), resultSet95.getDouble("D_TA"),
										resultSet95.getDouble("D_TX"), resultSet95.getDouble("D_TN"),
										resultSet95.getDouble("D_RS"), resultSet95.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet95 = statement5
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1995-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1995-02-28','YYYY-MM-DD')");
					while (resultSet95.next()) {
						result.add(
								new Weather(resultSet95.getDate("DATUM").toLocalDate(), resultSet95.getDouble("D_TA"),
										resultSet95.getDouble("D_TX"), resultSet95.getDouble("D_TN"),
										resultSet95.getDouble("D_RS"), resultSet95.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet95 = statement5
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1995-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1995-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet95.next()) {
						result.add(
								new Weather(resultSet95.getDate("DATUM").toLocalDate(), resultSet95.getDouble("D_TA"),
										resultSet95.getDouble("D_TX"), resultSet95.getDouble("D_TN"),
										resultSet95.getDouble("D_RS"), resultSet95.getDouble("D_SS")));
					}
				}
				// 1997
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet97 = statement7.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1997-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1997-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet97.next()) {
						result.add(
								new Weather(resultSet97.getDate("DATUM").toLocalDate(), resultSet97.getDouble("D_TA"),
										resultSet97.getDouble("D_TX"), resultSet97.getDouble("D_TN"),
										resultSet97.getDouble("D_RS"), resultSet97.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet97 = statement7
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1997-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1997-02-28','YYYY-MM-DD')");
					while (resultSet97.next()) {
						result.add(
								new Weather(resultSet97.getDate("DATUM").toLocalDate(), resultSet97.getDouble("D_TA"),
										resultSet97.getDouble("D_TX"), resultSet97.getDouble("D_TN"),
										resultSet97.getDouble("D_RS"), resultSet97.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet97 = statement7
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1997-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1997-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet97.next()) {
						result.add(
								new Weather(resultSet97.getDate("DATUM").toLocalDate(), resultSet97.getDouble("D_TA"),
										resultSet97.getDouble("D_TX"), resultSet97.getDouble("D_TN"),
										resultSet97.getDouble("D_RS"), resultSet97.getDouble("D_SS")));
					}
				}
				// 1998
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet98 = statement8.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1998-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1998-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet98.next()) {
						result.add(
								new Weather(resultSet98.getDate("DATUM").toLocalDate(), resultSet98.getDouble("D_TA"),
										resultSet98.getDouble("D_TX"), resultSet98.getDouble("D_TN"),
										resultSet98.getDouble("D_RS"), resultSet98.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet98 = statement8
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1998-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1998-02-28','YYYY-MM-DD')");
					while (resultSet98.next()) {
						result.add(
								new Weather(resultSet98.getDate("DATUM").toLocalDate(), resultSet98.getDouble("D_TA"),
										resultSet98.getDouble("D_TX"), resultSet98.getDouble("D_TN"),
										resultSet98.getDouble("D_RS"), resultSet98.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet98 = statement8
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1998-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1998-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet98.next()) {
						result.add(
								new Weather(resultSet98.getDate("DATUM").toLocalDate(), resultSet98.getDouble("D_TA"),
										resultSet98.getDouble("D_TX"), resultSet98.getDouble("D_TN"),
										resultSet98.getDouble("D_RS"), resultSet98.getDouble("D_SS")));
					}
				}
				// 1999
				if (from.getMonthValue() == 2 && from.getDayOfMonth() == 29) {
					ResultSet resultSet99 = statement9.executeQuery(
							"SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1999-03-01','YYYY-MM-DD') AND DATUM <= TO_DATE('1999-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet99.next()) {
						result.add(
								new Weather(resultSet99.getDate("DATUM").toLocalDate(), resultSet99.getDouble("D_TA"),
										resultSet99.getDouble("D_TX"), resultSet99.getDouble("D_TN"),
										resultSet99.getDouble("D_RS"), resultSet99.getDouble("D_SS")));
					}
				} else if (to.getMonthValue() == 2 && to.getDayOfMonth() == 29) {
					ResultSet resultSet99 = statement9
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1999-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth()
									+ "','YYYY-MM-DD') AND DATUM <= TO_DATE('1999-02-28','YYYY-MM-DD')");
					while (resultSet99.next()) {
						result.add(
								new Weather(resultSet99.getDate("DATUM").toLocalDate(), resultSet99.getDouble("D_TA"),
										resultSet99.getDouble("D_TX"), resultSet99.getDouble("D_TN"),
										resultSet99.getDouble("D_RS"), resultSet99.getDouble("D_SS")));
					}
				} else {
					ResultSet resultSet99 = statement9
							.executeQuery("SELECT * FROM DEBRECEN WHERE DATUM >= TO_DATE('1999-" + from.getMonthValue()
									+ "-" + from.getDayOfMonth() + "','YYYY-MM-DD') AND DATUM <= TO_DATE('1999-"
									+ to.getMonthValue() + "-" + to.getDayOfMonth() + "','YYYY-MM-DD')");
					while (resultSet99.next()) {
						result.add(
								new Weather(resultSet99.getDate("DATUM").toLocalDate(), resultSet99.getDouble("D_TA"),
										resultSet99.getDouble("D_TX"), resultSet99.getDouble("D_TN"),
										resultSet99.getDouble("D_RS"), resultSet99.getDouble("D_SS")));
					}
				}

			}

		} catch (SQLException e) {
			LOG.error("There was an error during SQL query.", e);
		}

		return result;
	}

}
