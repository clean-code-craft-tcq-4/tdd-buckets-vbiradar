import java.util.ArrayList;
import java.util.List;

public class AnalogToDigitalConverter {

	public static void main(String[] args) {

	}

	public List<Integer> analogToDigital(List<Integer> inputs, int minSensor, int maxSensor, int ampMin, int ampMax) {

		List<Integer> digital = new ArrayList<>();
		for (Integer input : inputs) {
			if (validateSensorRange(input, minSensor, maxSensor)) {
				throw new IllegalArgumentException("Input is out of range");
			}
			int digi = convertToAmps(input, minSensor, maxSensor, ampMin, ampMax);
			digital.add(digi);
		}
		return digital;
	}

	public boolean validateSensorRange(int input, int minSensor, int maxSensor) {
		return (input < minSensor || input > maxSensor);
	}

	public int convertToAmps(int input, int minSensor, int maxSensor, int ampMin, int ampMax) {
		return Math.round(((input - minSensor) * (ampMax - ampMin)) / (maxSensor - minSensor) + ampMin);
	}

}
