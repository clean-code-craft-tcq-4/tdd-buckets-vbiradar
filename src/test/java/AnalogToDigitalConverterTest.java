import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AnalogToDigitalConverterTest {

	AnalogToDigitalConverter analogToDigitalConverter = new AnalogToDigitalConverter();
	boolean actualResult;

	@Test
	public void outOfRangeInput() {
		actualResult = analogToDigitalConverter.validateSensorRange(8000, 0, 4094);
		assertTrue(actualResult);
	}

	@Test
	public void outOfRangeInput_2() {
		actualResult = analogToDigitalConverter.validateSensorRange(-8000, 0, 4094);
		assertTrue(actualResult);
	}

	@Test
	public void outOfRangeInput_3() {
		actualResult = analogToDigitalConverter.validateSensorRange(3000, 0, 1023);
		assertTrue(actualResult);
	}

	@Test
	public void outOfRangeInput_4() {
		actualResult = analogToDigitalConverter.validateSensorRange(-3000, 0, 1023);
		assertTrue(actualResult);
	}

	@Test
	public void convertToAmps_() {
		int actualResult = analogToDigitalConverter.convertToAmps(1000, 0, 4094, 0, 20);
		assertEquals(4, actualResult);
	}

	@Test
	public void convertToAmps_2() {
		int actualResult = analogToDigitalConverter.convertToAmps(600, 0, 1023, -20, 20);
		assertEquals(3, actualResult);
	}

	@Test
	public void analogToDigital_1() {
		List<Integer> bitValues_12 = new ArrayList<>();
		bitValues_12.add(1000);
		bitValues_12.add(2000);
		bitValues_12.add(3000);
		bitValues_12.add(4000);
		List<Integer> actualResult = analogToDigitalConverter.analogToDigital(bitValues_12, 0, 4094, 0, 10);
		assertTrue(actualResult.size() == 4);

	}

	@Test
	public void analogToDigital_2() {
		List<Integer> bitValues_12 = new ArrayList<>();
		bitValues_12.add(100);
		bitValues_12.add(200);
		bitValues_12.add(300);
		bitValues_12.add(400);
		List<Integer> actualResult = analogToDigitalConverter.analogToDigital(bitValues_12, 0, 1023, -15, 15);
		assertTrue(actualResult.size() == 4);

	}

}
