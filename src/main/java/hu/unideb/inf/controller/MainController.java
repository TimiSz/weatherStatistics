package hu.unideb.inf.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.calculation.Calculation;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * The controller class of the MainScene.
 * 
 * @author Tímea Szabó
 *
 */
public class MainController {

	/**
	 * A {@link Calculation} object.
	 */
	Calculation calc = new Calculation();

	/**
	 * A date picker where you can set the first day of the date interval.
	 */
	@FXML
	private DatePicker fromPicker;

	/**
	 * A date picker where you can set the the last day of the date interval.
	 */
	@FXML
	private DatePicker toPicker;

	/**
	 * A button. If you click this button, the program count the averages.
	 */
	@FXML
	private Button calculateButton;

	/**
	 * The place of the average of {@code temperatureAverage}.
	 */
	@FXML
	private Label temperatureAverageLabel;

	/**
	 * The place of the average of {@code temperatureMax}.
	 */
	@FXML
	private Label temperatureMaxLabel;

	/**
	 * The place of the average of {@code temperatureMin}.
	 */
	@FXML
	private Label temperatureMinLabel;

	/**
	 * The place of the average of {@code rainSum}.
	 */
	@FXML
	private Label rainSumLabel;

	/**
	 * The place of the average of {@code sunSum}.
	 */
	@FXML
	private Label sunSumLabel;

	/**
	 * The averages of {@code temperatureAverage} grouping by days of the date interval.
	 */
	@FXML
	private BarChart<String, Double> temperatureAverageByDayChart;

	/**
	 * The averages of {@code temperatureAverage} grouping by years.
	 */
	@FXML
	private BarChart<String, Double> temperatureAverageByYearChart;

	/**
	 * The averages of {@code temperatureMax} grouping by days of the date interval.
	 */
	@FXML
	private BarChart<String, Double> temperatureMaxByDayChart;

	/**
	 * The averages of {@code temperatureMax} grouping by years.
	 */
	@FXML
	private BarChart<String, Double> temperatureMaxByYearChart;

	/**
	 * The averages of {@code temperatureMin} grouping by days of the date interval.
	 */
	@FXML
	private BarChart<String, Double> temperatureMinByDayChart;

	/**
	 * The averages of {@code temperatureMin} grouping by years.
	 */
	@FXML
	private BarChart<String, Double> temperatureMinByYearChart;

	/**
	 * The averages of {@code rainSum} grouping by days of the date interval.
	 */
	@FXML
	private BarChart<String, Double> rainSumByDayChart;

	/**
	 * The averages of {@code rainSum} grouping by years.
	 */
	@FXML
	private BarChart<String, Double> rainSumByYearChart;

	/**
	 * The averages of {@code sunSum} grouping by days of the date interval.
	 */
	@FXML
	private BarChart<String, Double> sunSumByDayChart;

	/**
	 * The averages of {@code sunSum} grouping by years.
	 */
	@FXML
	private BarChart<String, Double> sunSumByYearChart;

	/**
	 * The button click action function.
	 */
	@FXML
	private void buttonOnClick() {

		clear();
		
		boolean checkDateInterval;
		if (fromPicker.getValue().isAfter(toPicker.getValue())) {
			checkDateInterval = false;
		} else
			checkDateInterval = true;

		if (!checkDateInterval) {
			AlertBox.display("Error message", "Invalid date interval!");
		} else {

			DecimalFormat df = new DecimalFormat("#.####");

			calc.initWeatherList(fromPicker.getValue(), toPicker.getValue());
			
			Double ta = calc.countAverageOfTemperatureAverageAll(fromPicker.getValue(), toPicker.getValue());
			Double tx = calc.countAverageOfTemperatureMaxAll(fromPicker.getValue(), toPicker.getValue());
			Double tn = calc.countAverageOfTemperatureMinAll(fromPicker.getValue(), toPicker.getValue());
			Double rs = calc.countAverageOfRainSumAll(fromPicker.getValue(), toPicker.getValue());
			Double ss = calc.countAverageOfSunSumAll(fromPicker.getValue(), toPicker.getValue());

			List<Double> tad = new ArrayList<>();
			tad = calc.countAverageOfTemperatureAverageByDay(fromPicker.getValue(), toPicker.getValue());

			List<Double> tay = new ArrayList<>();
			tay = calc.countAverageOfTemperatureAverageByYear(fromPicker.getValue(), toPicker.getValue());

			List<Double> txd = new ArrayList<>();
			txd = calc.countAverageOfTemperatureMaxByDay(fromPicker.getValue(), toPicker.getValue());

			List<Double> txy = new ArrayList<>();
			txy = calc.countAverageOfTemperatureMaxByYear(fromPicker.getValue(), toPicker.getValue());

			List<Double> tnd = new ArrayList<>();
			tnd = calc.countAverageOfTemperatureMinByDay(fromPicker.getValue(), toPicker.getValue());

			List<Double> tny = new ArrayList<>();
			tny = calc.countAverageOfTemperatureMinByYear(fromPicker.getValue(), toPicker.getValue());

			List<Double> rsd = new ArrayList<>();
			rsd = calc.countAverageOfRainSumByDay(fromPicker.getValue(), toPicker.getValue());

			List<Double> rsy = new ArrayList<>();
			rsy = calc.countAverageOfRainSumByYear(fromPicker.getValue(), toPicker.getValue());

			List<Double> ssd = new ArrayList<>();
			ssd = calc.countAverageOfSunSumByDay(fromPicker.getValue(), toPicker.getValue());

			List<Double> ssy = new ArrayList<>();
			ssy = calc.countAverageOfSunSumByYear(fromPicker.getValue(), toPicker.getValue());

			temperatureAverageLabel.setText(df.format(ta));
			temperatureMaxLabel.setText(df.format(tx));
			temperatureMinLabel.setText(df.format(tn));
			rainSumLabel.setText(df.format(rs));
			sunSumLabel.setText(df.format(ss));

			XYChart.Series<String, Double> series1 = new XYChart.Series<>();
			series1.setName("Temperature Average");
			for(int i=1; i<=9; i++) {
				series1.getData().add(new XYChart.Data<>("199"+i, tay.get(i-1)));
			}
			series1.getData().add(new XYChart.Data<>("2000", tay.get(9)));
			temperatureAverageByYearChart.getData().add(series1);

			XYChart.Series<String, Double> series2 = new XYChart.Series<>();
			series2.setName("Temperature Max");
			for(int i=1; i<=9; i++) {
				series2.getData().add(new XYChart.Data<>("199"+i, txy.get(i-1)));
			}
			series2.getData().add(new XYChart.Data<>("2000", txy.get(9)));
			temperatureMaxByYearChart.getData().add(series2);

			XYChart.Series<String, Double> series3 = new XYChart.Series<>();
			series3.setName("Temperature Min");
			for(int i=1; i<=9; i++) {
				series3.getData().add(new XYChart.Data<>("199"+i, tny.get(i-1)));
			}
			series3.getData().add(new XYChart.Data<>("2000", tny.get(9)));
			temperatureMinByYearChart.getData().add(series3);

			XYChart.Series<String, Double> series4 = new XYChart.Series<>();
			series4.setName("Rain Sum");
			for(int i=1; i<=9; i++) {
				series4.getData().add(new XYChart.Data<>("199"+i, rsy.get(i-1)));
			}
			series4.getData().add(new XYChart.Data<>("2000", rsy.get(9)));
			rainSumByYearChart.getData().add(series4);

			XYChart.Series<String, Double> series5 = new XYChart.Series<>();
			series5.setName("Sun Sum");
			for(int i=1; i<=9; i++) {
				series5.getData().add(new XYChart.Data<>("199"+i, ssy.get(i-1)));
			}
			series5.getData().add(new XYChart.Data<>("2000", ssy.get(9)));
			sunSumByYearChart.getData().add(series5);

			XYChart.Series<String, Double> series6 = new XYChart.Series<>();
			series6.setName("Temaperature Average");
			for (int i = 1; i <= tad.size(); i++) {
				series6.getData().add(new XYChart.Data<>(i + ".day", tad.get(i - 1)));
			}
			temperatureAverageByDayChart.getData().add(series6);

			XYChart.Series<String, Double> series7 = new XYChart.Series<>();
			series7.setName("Temaperature Max");
			for (int i = 1; i <= txd.size(); i++) {
				series7.getData().add(new XYChart.Data<>(i + ".day", txd.get(i - 1)));
			}
			temperatureMaxByDayChart.getData().add(series7);

			XYChart.Series<String, Double> series8 = new XYChart.Series<>();
			series8.setName("Temaperature Min");
			for (int i = 1; i <= tnd.size(); i++) {
				series8.getData().add(new XYChart.Data<>(i + ".day", tnd.get(i - 1)));
			}
			temperatureMinByDayChart.getData().add(series8);

			XYChart.Series<String, Double> series9 = new XYChart.Series<>();
			series9.setName("Rain Sum");
			for (int i = 1; i <= rsd.size(); i++) {
				series9.getData().add(new XYChart.Data<>(i + ".day", rsd.get(i - 1)));
			}
			rainSumByDayChart.getData().add(series9);

			XYChart.Series<String, Double> series10 = new XYChart.Series<>();
			series10.setName("Sun Sum");
			for (int i = 1; i <= ssd.size(); i++) {
				series10.getData().add(new XYChart.Data<>(i + ".day", ssd.get(i - 1)));
			}
			sunSumByDayChart.getData().add(series10);

		}
	}

	/**
	 * This function clears the bar charts.
	 */
	private void clear() {
		temperatureAverageByDayChart.getData().clear();
		temperatureAverageByYearChart.getData().clear();
		temperatureMaxByDayChart.getData().clear();
		temperatureMaxByYearChart.getData().clear();
		temperatureMinByDayChart.getData().clear();
		temperatureMinByYearChart.getData().clear();
		rainSumByDayChart.getData().clear();
		rainSumByYearChart.getData().clear();
		sunSumByDayChart.getData().clear();
		sunSumByYearChart.getData().clear();
	}

}
