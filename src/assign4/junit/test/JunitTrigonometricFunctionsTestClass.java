package assign4.junit.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import assign4.math.functions.TrignometricFunctions;

@RunWith(Parameterized.class)
public class JunitTrigonometricFunctionsTestClass {
	TrignometricFunctions functions;
	int radians;
	int degree;

	public JunitTrigonometricFunctionsTestClass(int radians, int degree) {
		this.radians = radians;
		this.degree = degree;
	}

	@Parameterized.Parameters
	public static Collection values() {

		Object[][] data = { { 180, 180 }, { 60, 60 }, { 0, 0 }, { 2, 2 }, { 120, 120 }, { 360, 360 },
				{ -180, -180 }, { -120, -120 }, { -360, -360 }, { -1, -1 }, { -60, -60 }, { -20, -20 },
				{ -4, -4 } };
		return Arrays.asList(data);
	}

	@Before
	public void initialize() {
		functions = new TrignometricFunctions();
	}

	@Test
	public void testSine() {
		assertEquals(Math.sin(radians), functions.sin(radians), 0.001);
	}

	@Test
	public void testSinedegree() {
		assertEquals(Math.toDegrees(Math.sin(Math.toRadians(degree))), functions.sinDegree(degree), 0.001);
	}

	@Test
	public void testCosine() {
		assertEquals(Math.cos(radians), functions.cos(radians), 0.001);
	}

	@Test
	public void testCosdegree() {
		assertEquals(Math.toDegrees(Math.cos(Math.toRadians(degree))), functions.cosDegree(degree), 0.001);
	}
	
	@Test
	public void testTan() {
		assertEquals(Math.tan(radians), functions.tan(radians), 0.001);
	}

	@Test
	public void testTandegree() {
		assertEquals(Math.toDegrees(Math.tan(Math.toRadians(degree))), functions.tanDegree(degree), 0.001);
	}
	
	@Test
	public void testPi() {
		assertEquals(Math.PI, functions.getPI(), 0.001);
	}

	@Test
	public void testGetRadians() {
		assertEquals(Math.toRadians(degree), functions.toRadian(degree), 0.001);
	}

	@Test
	public void testGetDegree() {
		assertEquals(Math.toDegrees(radians), functions.toDegree(radians), 0.001);
	}
}
