import java.lang.Math;

public class Dice {
    public int calc(){
        int total = 0;
        System.out.print("| ");
        for(int i = 0; i < 6; i++){
            double x = (int) (Math.random() * 6) + 1;

            if(i%2 == 0){
                total += x;

                if(i == 0){
                    System.out.print(x);
                }
                else{
                    System.out.print(" + " + x);
                }
                
            }

            else if (i%2 == 1){
                total -= x;

                System.out.print(" - " + x);
            }

        }

        System.out.print("| = " + Math.abs(total));
        System.out.println(" ");
        return Math.abs(total);
    }

    public static void main(String[] args) {
        Dice dice = new Dice(); 
        Dice dice2Dice = new Dice();

        int k = dice.calc();
        int k2 = dice2Dice.calc();
        System.out.println(" ");

        if(k > k2){ // printing out results
            System.out.println("Player 1 wins! ");
        }
        else if(k < k2){
            System.out.println("Player 2 wins! ");
        }
        else{
            System.out.println("Draw");
        }
    }
}
