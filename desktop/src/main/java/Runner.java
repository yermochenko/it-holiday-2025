import javax.swing.*;

import static java.lang.Math.toRadians;

public class Runner {
	public static void main(String[] args) {
		JFrame window = new JFrame("Бросок тела под углом к горизонту");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setSize(500, 500);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		JLabel angleLabel = new JLabel("Угол (°): ");
		angleLabel.setBounds(10, 10, 220, 25);
		window.add(angleLabel);
		JTextField angleField = new JTextField("30");
		angleField.setBounds(240, 10, 220, 25);
		window.add(angleField);
		JLabel massLabel = new JLabel("Масса (кг): ");
		massLabel.setBounds(10, 45, 220, 25);
		window.add(massLabel);
		JTextField massField = new JTextField("1");
		massField.setBounds(240, 45, 220, 25);
		window.add(massField);
		JLabel resistanceCoefficientLabel = new JLabel("Коэффициент сопротивления (кг/с): ");
		resistanceCoefficientLabel.setBounds(10, 80, 220, 25);
		window.add(resistanceCoefficientLabel);
		JTextField resistanceCoefficientField = new JTextField("0.3");
		resistanceCoefficientField.setBounds(240, 80, 220, 25);
		window.add(resistanceCoefficientField);
		JLabel startSpeedLabel = new JLabel("Начальная скорость (м/с): ");
		startSpeedLabel.setBounds(10, 115, 220, 25);
		window.add(startSpeedLabel);
		JTextField startSpeedField = new JTextField("20");
		startSpeedField.setBounds(240, 115, 220, 25);
		window.add(startSpeedField);
		JButton button = new JButton("Посчитать");
		button.setBounds(10, 150, 450, 30);
		button.addActionListener(event -> {
			try {
				Body body = new Body();
				body.setAngel(toRadians(Double.parseDouble(angleField.getText())));
				body.setMass(Double.parseDouble(massField.getText()));
				body.setResistanceCoefficient(Double.parseDouble(resistanceCoefficientField.getText()));
				body.setStartSpeed(Double.parseDouble(startSpeedField.getText()));
				double length = Model.flyingDistance(body);
				JOptionPane.showMessageDialog(null, String.format("Дальность полёта %.2f метров", length), "Ответ", JOptionPane.PLAIN_MESSAGE);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Неверные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
			}
		});
		window.add(button);
		window.setVisible(true);
	}
}
