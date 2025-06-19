import org.apache.commons.math3.analysis.solvers.BisectionSolver;

public class Model {
	public static double flyingDistance(Body body) {
		BisectionSolver solver = new BisectionSolver();
		double t = solver.solve(1000, body::y, 0.01, 100);
		return body.x(t);
	}
}
