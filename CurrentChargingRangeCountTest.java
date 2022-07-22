import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.junit.Test;

public class CurrentChargingRangeCountTest {

	CurrentChargingRangeCount chargingCount = new CurrentChargingRangeCount();

	@Test
	public void test_invalid_range() throws Exception {
		Map<String, String> rangeOut = chargingCount.countWithInputValue(4, 10);
		assertThat(rangeOut.get("4-10"), containsString("Not in Range"));

	}

	@Test
	public void test_valid_range() throws Exception {
		Map<String, String> rangeOut = chargingCount.countWithInputValue(4, 5);
		assertEquals("2", rangeOut.get("4-5"));
	}
	
	@Test
	public void test_invalid_start() throws Exception {
		Map<String, String> rangeOut = chargingCount.countWithInputValue(2, 10);
		assertThat(rangeOut.get("2-10"), containsString("No match found in the reading"));

	}
	
	@Test
	public void test_invalid_end() throws Exception {
		Map<String, String> rangeOut = chargingCount.countWithInputValue(3, 20);
		assertThat(rangeOut.get("3-20"), containsString("No match found in the reading"));

	}

}
