package frq2018;

public class FrogSimulation {
	
	/** Distance, in inches, from the starting position to the goal. */
	private int goalDistance;
	
	/** Maximum number of hops allowed to reach the goal. */
	private int maxHops;

	/**
	 * Constructs a FrogSimulation where dist is the distance, in inches, from the
	 * starting position to the goal, and numHops is the maximum number of hops
	 * allowed to reach the goal. 
	 * Precondition: dist > 0; numHops > 0
	 */
	public FrogSimulation(int dist, int numHops) {
		goalDistance = dist;
		maxHops = numHops;
	}

	/**
	 * Returns an integer representing the distance, in inches, to be moved when the
	 * frog hops.
	 */
	private int hopDistance() { 
		int dist = (int)(Math.random()*101) - 50;
		System.out.print(dist + " ");
		return dist;
	}

	/**
	 * Simulates a frog attempting to reach the goal as described in part (a).
	 * Returns true if the frog successfully reached or passed the goal during the
	 * simulation; false otherwise.
	 */
	public boolean simulate() {
		int currentDist = 0;
		for(int i = 0; i < maxHops; i++) {
			currentDist += hopDistance();
			if(currentDist >= goalDistance)
				return true;
			else if(currentDist < 0)
				return false;
		}
		return false;
	}

	/**
	 * Runs num simulations and returns the proportion of simulations in which the
	 * frog successfully reached or passed the goal. 
	 * Precondition: num > 0
	 */
	public double runSimulations(int num) {
		int successCount = 0;
		for(int i = 0; i < num; i++) {
			if(simulate()) {
				System.out.println(" Passed");
				successCount++;
			}else {
				System.out.println(" Not Passed");
			}
		}
		return successCount * 1.0 / num;
	}
	
	/**
	 * For testing use
	 */
	public static void main(String[] args) {
		FrogSimulation sim = new FrogSimulation(24, 5);
		System.out.println(sim.runSimulations(10));
	}
}
