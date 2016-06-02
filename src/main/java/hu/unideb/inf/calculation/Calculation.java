package hu.unideb.inf.calculation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.dao.WeatherDAO;
import hu.unideb.inf.dao.WeatherDAOImpl;
import hu.unideb.inf.entity.Weather;

/**
 * The class that contains all necessary calculations. This class realize the business logic.
 * 
 * @author Tímea Szabó
 *
 */
public class Calculation {

	/**
	 * Needs for logging.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Calculation.class);

	/**
	 * A {@link WeatherDAO} object.
	 */
	private WeatherDAO weatherDAO = new WeatherDAOImpl();

	/**
	 * List of {@link Weather} objects.
	 */
	private List<Weather> weatherList;

	/**
	 * Setter of the {@code weatherList}. Querying the data from the database.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 */
	public void initWeatherList(LocalDate from, LocalDate to) {
		this.weatherList = weatherDAO.getAllWeathersBetween(from, to);
	}

	/**
	 * Count the average of a list of doubles.
	 * 
	 * @param doubles numbers
	 * @return the average
	 */
	public double countAverage(List<Double> doubles) {
		double sum = 0;
		double average = -128;
		for (Double double1 : doubles) {
			sum += double1;
		}
		if (doubles.size() != 0)
			average = sum / doubles.size();
		return average;
	}
	
	/**
	 * Count the variance of a list of doubles.
	 * 
	 * @param doubles numbers
	 * @return the variance
	 */
	public double countVariance(List<Double> doubles) {
		double average = countAverage(doubles);
		double variance = -128;
		double sum = 0;
		for (Double double1 : doubles) {
			sum += (double1-average)*(double1-average);
		}
		if (doubles.size() != 0)
			variance = sum / doubles.size();
		return variance;
	}

	/**
	 * Count the average of {@code temperatureAverage} grouping by days of the date interval.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureAverageByDay(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureAverage by day.");

		List<Double> average = new ArrayList<>();

		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			List<Weather> days = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (date.getMonthValue() == weather.getDate().getMonthValue()
						&& date.getDayOfMonth() == weather.getDate().getDayOfMonth())
					days.add(weather);
			}
			List<Double> temperatureAverageOfDays = new ArrayList<>();
			for (Weather day : days) {
				temperatureAverageOfDays.add(day.getTemperatureAverage());
			}
			double a = countAverage(temperatureAverageOfDays);
			average.add(a);
		}
		return average;
	}

	/**
	 * Count the average of {@code temperatureAverage} grouping by years.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureAverageByYear(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureAverage by year.");

		List<Double> average = new ArrayList<>();

		for (int i = 1991; i <= 2000; i++) {
			List<Weather> years = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (weather.getDate().getYear() == i)
					years.add(weather);
			}
			List<Double> temperatureAverageOfYears = new ArrayList<>();
			for (Weather year : years) {
				temperatureAverageOfYears.add(year.getTemperatureAverage());
			}
			double a = countAverage(temperatureAverageOfYears);
			average.add(a);
		}
		return average;
	}

	/**
	 * Count the average of {@code temperatureAverage}.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return the average.
	 */
	public double countAverageOfTemperatureAverageAll(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureAverage.");

		double sum = 0;
		double average = -128;


		for (Weather weather : weatherList) {
			sum += weather.getTemperatureAverage();
		}
		if (weatherList.size() != 0)
			average = sum / weatherList.size();
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMax} grouping by days of the date interval.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureMaxByDay(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMax by day.");

		List<Double> average = new ArrayList<>();

		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			List<Weather> days = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (date.getMonthValue() == weather.getDate().getMonthValue()
						&& date.getDayOfMonth() == weather.getDate().getDayOfMonth())
					days.add(weather);
			}
			List<Double> temperatureMaxOfDays = new ArrayList<>();
			for (Weather day : days) {
				temperatureMaxOfDays.add(day.getTemperatureMax());
			}
			double a = countAverage(temperatureMaxOfDays);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMax} grouping by years.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureMaxByYear(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMax by year.");

		List<Double> average = new ArrayList<>();
		
		for (int i = 1991; i <= 2000; i++) {
			List<Weather> years = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (weather.getDate().getYear() == i)
					years.add(weather);
			}
			List<Double> temperatureMaxOfYears = new ArrayList<>();
			for (Weather year : years) {
				temperatureMaxOfYears.add(year.getTemperatureMax());
			}
			double a = countAverage(temperatureMaxOfYears);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMax}.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return the average.
	 */
	public double countAverageOfTemperatureMaxAll(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMax.");

		double sum = 0;
		double average = -128;


		for (Weather weather : weatherList) {
			sum += weather.getTemperatureMax();
		}
		if (weatherList.size() != 0)
			average = sum / weatherList.size();
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMin} grouping by days of the date interval.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureMinByDay(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMin by day.");

		List<Double> average = new ArrayList<>();

		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			List<Weather> days = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (date.getMonthValue() == weather.getDate().getMonthValue()
						&& date.getDayOfMonth() == weather.getDate().getDayOfMonth())
					days.add(weather);
			}
			List<Double> temperatureMinOfDays = new ArrayList<>();
			for (Weather day : days) {
				temperatureMinOfDays.add(day.getTemperatureMin());
			}
			double a = countAverage(temperatureMinOfDays);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMin} grouping by years.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfTemperatureMinByYear(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMin by year.");

		List<Double> average = new ArrayList<>();

		for (int i = 1991; i <= 2000; i++) {
			List<Weather> years = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (weather.getDate().getYear() == i)
					years.add(weather);
			}
			List<Double> temperatureMinOfYears = new ArrayList<>();
			for (Weather year : years) {
				temperatureMinOfYears.add(year.getTemperatureMin());
			}
			double a = countAverage(temperatureMinOfYears);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code temperatureMin}.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return the average.
	 */
	public double countAverageOfTemperatureMinAll(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of temperatureMin.");

		double sum = 0;
		double average = -128;


		for (Weather weather : weatherList) {
			sum += weather.getTemperatureMin();
		}
		if (weatherList.size() != 0)
			average = sum / weatherList.size();
		return average;
	}
	
	/**
	 * Count the average of {@code rainSum} grouping by days of the date interval.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfRainSumByDay(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of rainSum by day.");

		List<Double> average = new ArrayList<>();
		
		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			List<Weather> days = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (date.getMonthValue() == weather.getDate().getMonthValue()
						&& date.getDayOfMonth() == weather.getDate().getDayOfMonth())
					days.add(weather);
			}
			List<Double> rainSumOfDays = new ArrayList<>();
			for (Weather day : days) {
				rainSumOfDays.add(day.getRainSum());
			}
			double a = countAverage(rainSumOfDays);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code rainSum} grouping by years.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfRainSumByYear(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of rainSum by year.");

		List<Double> average = new ArrayList<>();
		
		for (int i = 1991; i <= 2000; i++) {
			List<Weather> years = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (weather.getDate().getYear() == i)
					years.add(weather);
			}
			List<Double> rainSumOfYears = new ArrayList<>();
			for (Weather year : years) {
				rainSumOfYears.add(year.getRainSum());
			}
			double a = countAverage(rainSumOfYears);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code rainSum}.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return the average.
	 */
	public double countAverageOfRainSumAll(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of rainSum.");

		double sum = 0;
		double average = -128;

		
		for (Weather weather : weatherList) {
			sum += weather.getRainSum();
		}
		if (weatherList.size() != 0)
			average = sum / weatherList.size();
		return average;
	}
	
	/**
	 * Count the average of {@code sunSum} grouping by days of the date interval.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfSunSumByDay(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of sunSum by day.");

		List<Double> average = new ArrayList<>();
		
		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			List<Weather> days = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (date.getMonthValue() == weather.getDate().getMonthValue()
						&& date.getDayOfMonth() == weather.getDate().getDayOfMonth())
					days.add(weather);
			}
			List<Double> sunSumOfDays = new ArrayList<>();
			for (Weather day : days) {
				sunSumOfDays.add(day.getSunSum());
			}
			double a = countAverage(sunSumOfDays);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code sunSum} grouping by years.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return list of the averages.
	 */
	public List<Double> countAverageOfSunSumByYear(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of sunSum by year.");

		List<Double> average = new ArrayList<>();
		
		for (int i = 1991; i <= 2000; i++) {
			List<Weather> years = new ArrayList<>();
			for (Weather weather : weatherList) {
				if (weather.getDate().getYear() == i)
					years.add(weather);
			}
			List<Double> sunSumOfYears = new ArrayList<>();
			for (Weather year : years) {
				sunSumOfYears.add(year.getSunSum());
			}
			double a = countAverage(sunSumOfYears);
			average.add(a);
		}
		return average;
	}
	
	/**
	 * Count the average of {@code sunSum}.
	 * 
	 * @param from The first day of the date interval.
	 * @param to The last day of the date interval.
	 * @return the average.
	 */
	public double countAverageOfSunSumAll(LocalDate from, LocalDate to) {

		LOG.info("Calculating average of sunSum.");

		double sum = 0;
		double average = -128;

		
		for (Weather weather : weatherList) {
			sum += weather.getSunSum();
		}
		if (weatherList.size() != 0)
			average = sum / weatherList.size();
		return average;
	}

}
