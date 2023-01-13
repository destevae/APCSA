import java.lang.Math;

public class FrogSimulation {
    public int goalDistance; // distance from starting position to goal

    public int maxHops; // max number of hops allowed to reach goal

    public FrogSimulation(int dist, int numHops){
        goalDistance = dist;
        maxHops = numHops;
    }

    // returns int representing the distance to be moved when the frog hops
    public int hopDistance(){
        int rand = (int) ((Math.random() * goalDistance) + 1);
        return rand;
    }

    // simulates the frog, return TRUE if success, FALSE otherwise
    public boolean simulate(){
        int currentDistance = 0;

        for(int i = 0; i < maxHops; i++){
            int distance = hopDistance();
            currentDistance = currentDistance + distance;
        }
        
        if(currentDistance >= goalDistance){
            return true; // success!
        }

        else{
            return false;
        }
    }

    // runs num simulations and returns proportion of simulations that the frog succeeds
    public double runSimulations(int num){
        double number = num;
        double success = 0;

        for(int i = 0; i < num; i++){
            boolean bool = simulate();
            if(bool == true){
                success++;
            }
        }
        System.out.println("SUCCESS NUM " + success);
        System.out.println("TOTAL NUMBER " + number);

        return success/number;
    }

    public static void main(String[] args){
        FrogSimulation bob = new FrogSimulation(30,2);
        System.out.println(bob.simulate());
        System.out.println("SIMULATION PROPORTION:" + bob.runSimulations(6));
    }
}
