package hu.unideb.inf.dao;

import java.time.LocalDate;
import java.util.List;

import hu.unideb.inf.entity.Weather;

/**
 * An interface for DAO.
 * 
 * @author Tímea Szabó
 *
 */
public interface WeatherDAO {
	
	/**
	 * This method returns all {@link Weather} object which has date between the parameters.
	 * 
	 * @param from The first day of the interval.
	 * @param to The last day of the interval.
	 * @return a list of {@link Weather} objects.
	 */
	public List<Weather> getAllWeathersBetween(LocalDate from, LocalDate to);
	

}
