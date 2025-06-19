package by.vsu.ith;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Math.toRadians;

@Controller
public class Web {
	@PostMapping("/calc")
	public String calculate(
		@RequestParam(name = "angle") double angle,
		@RequestParam(name = "mass") double mass,
		@RequestParam(name = "resistance-coefficient") double resistanceCoefficient,
		@RequestParam(name = "start-speed") double startSpeed,
		org.springframework.ui.Model model
	) {
		Body body = new Body();
		body.setAngel(toRadians(angle));
		body.setMass(mass);
		body.setResistanceCoefficient(resistanceCoefficient);
		body.setStartSpeed(startSpeed);
		double length = Model.flyingDistance(body);
		model.addAttribute("length", length);
		return "result";
	}
}
