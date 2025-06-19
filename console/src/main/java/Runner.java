import java.util.Scanner;

import static java.lang.Math.toRadians;

public class Runner {
	public static void main(String[] args) {
		System.out.println("Бросок тела под углом к горизонту");
		Scanner in = new Scanner(System.in);
		Body body = new Body();
		System.out.print("Угол (по умолчанию 30°): ");
		try {
			body.setAngel(toRadians(Double.parseDouble(in.nextLine())));
		} catch(NumberFormatException e) {
			body.setAngel(toRadians(30));
		}
		System.out.print("Масса (по умолчанию 1 кг): ");
		try {
			body.setMass(Double.parseDouble(in.nextLine()));
		} catch(NumberFormatException e) {
			body.setMass(1);
		}
		System.out.print("Коэффициент сопротивления (по умолчанию 0.3 кг/с): ");
		try {
			body.setResistanceCoefficient(Double.parseDouble(in.nextLine()));
		} catch(NumberFormatException e) {
			body.setResistanceCoefficient(0.3);
		}
		System.out.print("Начальная скорость (по умолчанию 20 м/с): ");
		try {
			body.setStartSpeed(Double.parseDouble(in.nextLine()));
		} catch(NumberFormatException e) {
			body.setStartSpeed(20);
		}
		double length = Model.flyingDistance(body);
		System.out.printf("Дальность полёта %.2f метров\n", length);
	}
}
