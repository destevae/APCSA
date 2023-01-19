import java.util.Scanner;

public class MSMain {
    public static void main(String[] args) throws Exception {

        try (Scanner userDimensions = new Scanner(System.in)) {
            int rows = 0;
            int columns = 0;
            int minesNum = 0;

            // user decides the number of rows
            System.out.println("How many rows do you want your map to have?");
            String userRows = userDimensions.nextLine();
            if(isNumeric(userRows) == true){
                rows = Integer.valueOf(userRows);
            }

            else{
                System.out.println("Invalid number of rows. Game aborted.");
                return;
            }
            
            // user decides the number of columns
            System.out.println("How many columns do you want your map to have?");
            String userColumns = userDimensions.nextLine();

            if(isNumeric(userColumns) == true){
                columns = Integer.valueOf(userColumns);
            }

            else{
                System.out.println("Invalid number of rows. Game aborted.");
                return;
            }
            
            // user decides the number of mines
            System.out.println("How many mines do you want your map to have?");
            String userMine = userDimensions.nextLine();

            if(isNumeric(userMine) == true){
                minesNum = Integer.valueOf(userMine);
            }

            else{
                System.out.println("Invalid number of rows. Game aborted.");
                return;
            }
            
            // creating game, running game methods
            Game Minesweeper = new Game(rows, columns, minesNum);
            
            Minesweeper.startRound();
            Minesweeper.actualRound();

        }
    }

    // takes in a string, determines if it is fully numeric or not
    public static boolean isNumeric(String myString){

        boolean numeric = false;

        for(int i = 0; i < myString.length(); i++){
            if(myString.charAt(i) == '0' || myString.charAt(i) == '1' || myString.charAt(i) == '2' || myString.charAt(i) == '3' || myString.charAt(i) == '4' 
            || myString.charAt(i) == '5' || myString.charAt(i) == '6' || myString.charAt(i) == '7' || myString.charAt(i) == '8' || myString.charAt(i) == '9'){
                numeric = true;
            }
            else{
                numeric = false;
                break;
            }
        }

        return numeric;
    }
}
