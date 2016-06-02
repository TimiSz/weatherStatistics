package hu.unideb.inf.entity;

import java.time.LocalDate;

/**
 * A class that contains the entity.
 * 
 * @author Tímea Szabó
 *
 */
/**
 * @author Timi
 *
 */
public class Weather {

	/**
	 * The date that identify the {@link Weather} object.
	 */
	private LocalDate date;
	
	/**
	 * The average of the daily temperature.
	 */
	private double temperatureAverage;
	
	/**
	 * The maximum value of the temperature for the day.
	 */
	private double temperatureMax;
	
	/**
	 * The minimum value of the temperature for the day.
	 */
	private double temperatureMin;
	
	/**
	 * The value of the rainfall for the day.
	 */
	private double rainSum;
	
	/**
	 * The number of hours of sunshine for the day.
	 */
	private double sunSum;

	
	/**
	 * Constructor.
	 * 
	 * @param date the date
	 * @param temperatureAverage the tamperatureAverage
	 * @param temperatureMax the TemperatureMax
	 * @param temperatureMin the TemperatureMin
	 * @param rainSum the rainSum
	 * @param sunSum the sunSum
	 */
	public Weather(LocalDate date, double temperatureAverage, double temperatureMax, double temperatureMin,
			double rainSum, double sunSum) {
		this.date = date;
		this.temperatureAverage = temperatureAverage;
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		this.rainSum = rainSum;
		this.sunSum = sunSum;
	}

	/**
	 * Getter.
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Setter.
	 * @param date the date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter.
	 * @return temperatureAverage
	 */
	public double getTemperatureAverage() {
		return temperatureAverage;
	}

	/**
	 * Setter.
	 * @param temperatureAverage the temperatureAverage
	 */
	public void setTemperatureAverage(double temperatureAverage) {
		this.temperatureAverage = temperatureAverage;
	}

	/**
	 * Getter.
	 * @return temperatureMax
	 */
	public double getTemperatureMax() {
		return temperatureMax;
	}

	/**
	 * Setter.
	 * @param temperatureMax the temperatureMax
	 */
	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	/**
	 * Getter.
	 * @return temperatureMin
	 */
	public double getTemperatureMin() {
		return temperatureMin;
	}

	/**
	 * Setter.
	 * @param temperatureMin the temperatureMin
	 */
	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	/**
	 * Getter.
	 * @return rainSum
	 */
	public double getRainSum() {
		return rainSum;
	}

	/**
	 * Setter.
	 * @param rainSum the rainSum
	 */
	public void setRainSum(double rainSum) {
		this.rainSum = rainSum;
	}

	/**
	 * Getter.
	 * @return sunSum
	 */
	public double getSunSum() {
		return sunSum;
	}

	/**
	 * Setter.
	 * @param sunSum the sunSum
	 */
	public void setSunSum(double sunSum) {
		this.sunSum = sunSum;
	}

}
