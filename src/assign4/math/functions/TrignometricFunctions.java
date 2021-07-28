package assign4.math.functions;

public class TrignometricFunctions {

	/*
	 * Reference
	 * 
	 * Author - marco
	 * https://stackoverflow.com/questions/45333694/implement-sine-in-java-without-
	 * math-sin-function
	 */

	final double PI = 3.14159265358979323846;

	public double sin(double radian) {

		//System.out.println(Math.sin(90));
		final int PRECISION = 50;
		int sign = 1;
		if(radian < 0)
			sign = -1;
		
		double currentTerm = 0;

		if (radian == Double.NEGATIVE_INFINITY || !(radian < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}
		radian %= 2 * PI;

		if (radian > PI) {
			radian -= PI;
			sign = -(sign);
		}
		if (radian < 0) {
			radian = 2 * PI - radian;
		}

		for (int i = 0; i <= PRECISION; i++) {
			currentTerm += getpower(-1, i) * (getpower(radian, 2 * i + 1) / getFact(2 * i + 1));
		}
		//System.out.println(currentTerm * sign);
		return currentTerm * sign;
	}

	public double cos(double radian) {
		final int PRECISION = 50;
		int sign = 1;
		double currentTerm = 0;
		if (radian == Double.NEGATIVE_INFINITY || !(radian < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}
		radian %= 2 * PI;

		if (radian < PI) {
			radian -= PI;
			sign = -1;
		}
		if (radian < 0) {
			radian = 2 * PI - radian;
		}

		for (int i = 0; i <= PRECISION; i++) {
			currentTerm += getpower(-1, i) * (getpower(radian, 2 * i) / getFact(2 * i));
		}

		//System.out.println(currentTerm * sign);
		return currentTerm * sign;
	}

	public double tan(double value) {
		
		return (sin(value) / cos(value));
	}
	
	public double sinDegree(double value) {
		double radians = toRadian(value);
		return toDegree(sin(radians));
	}
	
	public double cosDegree(double value) {
		double radians = toRadian(value);
		return toDegree(cos(radians));
	}

	public double tanDegree(double value) {
		double radians = toRadian(value);
		return toDegree(tan(radians));
	}
	
	public double toRadian(double value) {

		return (value * PI)/180;
	}

	public double toDegree(double value) {

		return (value * 180)/PI;
	}

	public double getpower(double val, int power) {

		if (power == 0) {
			return 1;
		}
		
		if (power == 1) {
			return val;
		}

		return val * getpower(val, power - 1);
	}

	public double getFact(int val) {

		if (val == 1 || val == 0) {
			return 1;
		}

		return val * getFact(val - 1);
	}

	public double getPI() {
		return PI;
	}
}
