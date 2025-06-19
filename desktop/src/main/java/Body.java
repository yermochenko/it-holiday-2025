import static java.lang.Math.*;

public class Body {
	public static final double g = 9.81;
	private double mass;
	private double startSpeed;
	private double angel;
	private double resistanceCoefficient;

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
		coefficient = null;
	}

	public double getStartSpeed() {
		return startSpeed;
	}

	public void setStartSpeed(double startSpeed) {
		this.startSpeed = startSpeed;
	}

	public double getAngel() {
		return angel;
	}

	public void setAngel(double angel) {
		this.angel = angel;
	}

	public double getResistanceCoefficient() {
		return resistanceCoefficient;
	}

	public void setResistanceCoefficient(double resistanceCoefficient) {
		this.resistanceCoefficient = resistanceCoefficient;
		coefficient = null;
	}

	private Double coefficient;
	public double getCoefficient() {
		if(coefficient == null) {
			coefficient = - getResistanceCoefficient() / getMass();
		}
		return coefficient;
	}

	public double x(double t) {
		double v0 = getStartSpeed();
		double alpha = getAngel();
		double c = getCoefficient();
		return (v0 * cos(alpha) / c) * e(t);
	}

	public double y(double t) {
		double v0 = getStartSpeed();
		double alpha = getAngel();
		double c = getCoefficient();
		return (v0 * sin(alpha) / c - g / (c * c)) * e(t) + g * t / c;
	}

	private double e(double t) {
		double c = getCoefficient();
		return exp(c * t) - 1;
	}
}
