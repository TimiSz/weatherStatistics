package calculation;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.calculation.Calculation;

public class CalculationTest {

	private Calculation calculation;
	
	@Before
	public void setup() {
		calculation = new Calculation();
	}

	@Test
	public void testCountAverage() {
		List<Double> actual1 = Arrays.asList(1.0, -3.5, 4.2);
		List<Double> actual2 = Arrays.asList(2.3);
		List<Double> actual3 = Arrays.asList();
		
		assertEquals(0.56, calculation.countAverage(actual1), 0.01);
		assertEquals(2.3, calculation.countAverage(actual2), 0.01);
		assertEquals(-128, calculation.countAverage(actual3), 0.01);
		
	}
	
	@Test
	public void testCountVariance() {
		List<Double> actual1 = Arrays.asList(1.0, -3.5, 4.2);
		List<Double> actual2 = Arrays.asList(2.3);
		List<Double> actual3 = Arrays.asList();
		
		assertEquals(9.9756, calculation.countVariance(actual1), 0.01);
		assertEquals(0.0, calculation.countVariance(actual2), 0.01);
		assertEquals(-128, calculation.countVariance(actual3), 0.01);
		
	}
	
	@Test
	public void testCountAverageOfTemperatureAverageByDay() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(-3.26, -1.53, -1.19, -0.79, -0.92);
		List<Double> array1 = calculation.countAverageOfTemperatureAverageByDay(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
		
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		List<Double> average2 = Arrays.asList(2.52, -1.03);
		List<Double> array2 = calculation.countAverageOfTemperatureAverageByDay(from2, to2);
		assertEquals(average2.size(), array2.size());
		for (int i=0; i < average2.size(); i++) {
			assertEquals(average2.get(i), array2.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfTemperatureAverageByYear() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(2.92, -7.06, -7.62, 2.32, -0.88, -2.1, -2.2, 5.58, -2.68, -3.66);
		List<Double> array1 = calculation.countAverageOfTemperatureAverageByYear(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
	}
	
	@Test
	public void testcountAverageOfTemperatureAverageAll() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		assertEquals(-1.53, calculation.countAverageOfTemperatureAverageAll(from1, to1), 0.01);
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		assertEquals(1.7, calculation.countAverageOfTemperatureAverageAll(from2, to2), 0.01);
		
		LocalDate from3 = LocalDate.parse("2016-01-31");
		LocalDate to3 = LocalDate.parse("2016-02-01");
		calculation.initWeatherList(from3, to3);
		assertEquals(-3.945, calculation.countAverageOfTemperatureAverageAll(from3, to3), 0.01);
	}
	
	@Test
	public void testCountAverageOfTemperatureMaxByDay() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(0.44, 1.68, 2.24, 1.99, 1.93);
		List<Double> array1 = calculation.countAverageOfTemperatureMaxByDay(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
		
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		List<Double> average2 = Arrays.asList(9.21, 6.83);
		List<Double> array2 = calculation.countAverageOfTemperatureMaxByDay(from2, to2);
		assertEquals(average2.size(), array2.size());
		for (int i=0; i < average2.size(); i++) {
			assertEquals(average2.get(i), array2.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfTemperatureMaxByYear() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(5.82, -2.7, -2.0, 4.94, 1.96, 0.16, -0.04, 9.32, 0.96, -1.86);
		List<Double> array1 = calculation.countAverageOfTemperatureMaxByYear(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
	}
	
	@Test
	public void testcountAverageOfTemperatureMaxAll() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		assertEquals(1.656, calculation.countAverageOfTemperatureMaxAll(from1, to1), 0.01);
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		assertEquals(8.66, calculation.countAverageOfTemperatureMaxAll(from2, to2), 0.01);
		
		LocalDate from3 = LocalDate.parse("2016-01-31");
		LocalDate to3 = LocalDate.parse("2016-02-01");
		calculation.initWeatherList(from3, to3);
		assertEquals(0.58, calculation.countAverageOfTemperatureMaxAll(from3, to3), 0.01);
	}
	
	@Test
	public void testCountAverageOfTemperatureMinByDay() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(-7.25, -4.76, -4.32, -3.31, -3.86);
		List<Double> array1 = calculation.countAverageOfTemperatureMinByDay(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
		
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		List<Double> average2 = Arrays.asList(-1.98, -5.63);
		List<Double> array2 = calculation.countAverageOfTemperatureMinByDay(from2, to2);
		assertEquals(average2.size(), array2.size());
		for (int i=0; i < average2.size(); i++) {
			assertEquals(average2.get(i), array2.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfTemperatureMinByYear() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(0.92, -12.5, -11.96, -0.66, -3.28, -4.5, -4.78, 1.78, -5.56, -6.46);
		List<Double> array1 = calculation.countAverageOfTemperatureMinByYear(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
	}
	
	@Test
	public void testcountAverageOfTemperatureMinAll() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		assertEquals(-4.7, calculation.countAverageOfTemperatureMinAll(from1, to1), 0.01);
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		assertEquals(-2.82, calculation.countAverageOfTemperatureMinAll(from2, to2), 0.01);
		
		LocalDate from3 = LocalDate.parse("2016-01-31");
		LocalDate to3 = LocalDate.parse("2016-02-01");
		calculation.initWeatherList(from3, to3);
		assertEquals(-7.295, calculation.countAverageOfTemperatureMinAll(from3, to3), 0.01);
	}
	
	@Test
	public void testCountAverageOfRainSumByDay() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(2.25, 0.26, 1.61, 0.7, 1.0);
		List<Double> array1 = calculation.countAverageOfRainSumByDay(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
		
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		List<Double> average2 = Arrays.asList(0.0, 0.0);
		calculation.initWeatherList(from2, to2);
		List<Double> array2 = calculation.countAverageOfRainSumByDay(from2, to2);
		assertEquals(average2.size(), array2.size());
		for (int i=0; i < average2.size(); i++) {
			assertEquals(average2.get(i), array2.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfRainSumByYear() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(1.58, 0.6, 0.0, 2.26, 0.22, 3.64, 1.14, 0.64, 1.4, 0.16);
		List<Double> array1 = calculation.countAverageOfRainSumByYear(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
	}
	
	@Test
	public void testcountAverageOfRainSumAll() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		assertEquals(1.164, calculation.countAverageOfRainSumAll(from1, to1), 0.01);
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		assertEquals(0.0, calculation.countAverageOfRainSumAll(from2, to2), 0.01);
		
		LocalDate from3 = LocalDate.parse("2016-01-31");
		LocalDate to3 = LocalDate.parse("2016-02-01");
		calculation.initWeatherList(from3, to3);
		assertEquals(0.195, calculation.countAverageOfRainSumAll(from3, to3), 0.01);
	}
	
	@Test
	public void testCountAverageOfSunSumByDay() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(1.74, 2.37, 1.51, 1.03, 1.04);
		List<Double> array1 = calculation.countAverageOfSunSumByDay(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
		
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		List<Double> average2 = Arrays.asList(7.27, 6.3);
		List<Double> array2 = calculation.countAverageOfSunSumByDay(from2, to2);
		assertEquals(average2.size(), array2.size());
		for (int i=0; i < average2.size(); i++) {
			assertEquals(average2.get(i), array2.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfSunSumByYear() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		List<Double> average1 = Arrays.asList(0.98, 1.96, 5.7, 0.84, 2.28, 0.64, 0.0, 1.48, 0.36, 1.14);
		List<Double> array1 = calculation.countAverageOfSunSumByYear(from1, to1);
		assertEquals(average1.size(), array1.size());
		for (int i=0; i < average1.size(); i++) {
			assertEquals(average1.get(i), array1.get(i), 0.01);
		}
	}
	
	@Test
	public void testCountAverageOfSunSumAll() {
		LocalDate from1 = LocalDate.parse("2016-01-01");
		LocalDate to1 = LocalDate.parse("2016-01-05");
		calculation.initWeatherList(from1, to1);
		assertEquals(1.538, calculation.countAverageOfSunSumAll(from1, to1), 0.01);
		
		LocalDate from2 = LocalDate.parse("2016-02-28");
		LocalDate to2 = LocalDate.parse("2016-02-29");
		calculation.initWeatherList(from2, to2);
		assertEquals(7.046, calculation.countAverageOfSunSumAll(from2, to2), 0.01);
		
		LocalDate from3 = LocalDate.parse("2016-01-31");
		LocalDate to3 = LocalDate.parse("2016-02-01");
		calculation.initWeatherList(from3, to3);
		assertEquals(4.67, calculation.countAverageOfSunSumAll(from3, to3), 0.01);
	}

}
