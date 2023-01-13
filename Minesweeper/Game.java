import java.util.Scanner;

public class Game {
    int xDimension;
    int yDimension;
    int minesNumber;
    String[][] playerGrid;
    String[][] flippedGrid;

    Game(int xDim, int yDim, int mNum){ // game constructor
        xDimension = xDim;
        yDimension = yDim;
        minesNumber = mNum;

        playerGrid = new String[xDimension][yDimension]; // the grid that the player can see
        flippedGrid = new String[xDimension][yDimension]; // used in the flipNearby method
    }

    // initialize the map, setting all spaces as blank [ ]
    void startRound(){
        Grid theGrid = new Grid(xDimension, yDimension, minesNumber);

        System.out.println("Starting the game ...");
        for(int i=0; i<playerGrid.length; i++){
            for(int j=0; j<playerGrid[i].length; j++){
                playerGrid[i][j] = "[ ]";
            }
        }

        // for the flipNearby method
        for(int i=0; i<flippedGrid.length; i++){
            for(int j=0; j<flippedGrid[i].length; j++){
                flippedGrid[i][j] = "[ ]";
            }
        }

        theGrid.printMap(playerGrid);
    }

    // base code for the actual minesweeper game
    void actualRound(){

        Grid gameGrid = new Grid(xDimension, yDimension, minesNumber);
        String[][] referenceStringGrid = new String[xDimension][yDimension]; 
        Tile[][] referenceTileGrid = new Tile[xDimension][yDimension]; 
        boolean gameOver = false;
        boolean isUserFlagging = false;
        int x;
        int y;

        // gets the actual (reference) grids
        referenceTileGrid = gameGrid.gridCreate();
        referenceStringGrid = gameGrid.getStringArray(referenceTileGrid);

        // loops until the user uncovers all non-mine tiles
        while(gameOver == false){
            isUserFlagging = false;

            // create a scanner object and read user input
            Scanner userTileSelection = new Scanner(System.in);  
            String userChoice = userTileSelection.nextLine();
            
            // if the user tries to flag something
            if(userChoice.charAt(0) == 'f'){
                isUserFlagging = true;

                // space indexes are used to separate the x and y inputted coordinates from scanner
                int spaceIndex = userChoice.indexOf(" ");
                int spaceIndex2 = userChoice.indexOf(" ", spaceIndex + 1);

                if(spaceIndex == -1 || spaceIndex2 == -1){ // if there are no spaces in the input
                    System.out.println("Please enter in something that can be flagged in the 'x y' format.");
                    continue;
                }

                // if the inputs do not have numbers in the right format
                else if(isNumeric(userChoice.substring(spaceIndex + 1, spaceIndex2)) == false || isNumeric(userChoice.substring(spaceIndex2 + 1)) == false){
                    System.out.println("Please enter in something that can be flagged in the 'f x y' format.");
                    continue;
                }

                else{
                    x = Integer.valueOf(userChoice.substring(spaceIndex + 1, spaceIndex2));
                    y = Integer.valueOf(userChoice.substring(spaceIndex2 + 1));

                    if(x > (xDimension - 1) || y > (yDimension - 1) || x < 0 || y < 0){ // making sure the user input does not go out of grid bounds
                        System.out.println("Your x and y coordinates are out of bounds. Please try again.");
                        continue;
                    }
                }
                
            }
            
            // if user tries to flip something
            else{
                isUserFlagging = false;

                // space indexes are used to separate the x and y inputted coordinates from scanner
                int spaceIndex = userChoice.indexOf(" ");

                if(spaceIndex == -1){ // if there are no spaces in the input
                    System.out.println("Please enter in something that can be flipped in the 'x y' format.");
                    continue;
                }

                // if the inputs do not have numbers in the right format
                else if(isNumeric(userChoice.substring(0, spaceIndex)) == false || isNumeric(userChoice.substring(spaceIndex + 1)) == false){
                    System.out.println("Please enter in something that can be flipped in the 'x y' format. Make sure you don't have an extra space at the end!");
                    continue;
                }

                else{
                    x = Integer.valueOf(userChoice.substring(0, spaceIndex));
                    y = Integer.valueOf(userChoice.substring(spaceIndex + 1));

                    if(x > (xDimension - 1) || y > (yDimension - 1) || x < 0 || y < 0){ // making sure the user input does not go out of grid bounds
                        System.out.println("Your x and y coordinates are out of bounds. Please try again.");
                        continue;
                    }
                }
            }
            
            // what happens if the flipped tile is already flagged, safe, a mine, or is an edge
            if(isUserFlagging == false){ 
                if(referenceTileGrid[x][y].isFlagged == true){
                    System.out.println("You cannot flip a flagged tile. Try another one!");
                }

                else if(referenceTileGrid[x][y].isFlipped == true){
                    System.out.println("You cannot flip a flipped tile. Try another one!");
                }

                else if(referenceStringGrid[x][y] == "[m]"){
                    System.out.println("You have hit a mine. Game over!");
                    gameOver = true;
                    gameGrid.printMap(referenceStringGrid);
                    userTileSelection.close();
                    return;
                }

                else if(referenceStringGrid[x][y] == "[s]"){ // calls the flipNearby recursive method
                    playerGrid = flipNearby(referenceStringGrid, playerGrid, referenceTileGrid, x, y);
                }

                else{ // only flip that tile
                    playerGrid[x][y] = referenceStringGrid[x][y];
                    referenceTileGrid[x][y].flip();
                }
            } 

            if(isUserFlagging == true){

                // if user tries to flag an already flipped tile
                if(playerGrid[x][y].equals("[ ]") == false && playerGrid[x][y].equals("[⚐]") == false){ 
                    System.out.println("You cannot flag a flipped tile. Try another one!");
                }

                else if(referenceTileGrid[x][y].isFlagged == true){ // if the tile has already been flagged
                    referenceTileGrid[x][y].isFlagged = false;
                    playerGrid[x][y] = "[ ]";
                } 

                else if(referenceTileGrid[x][y].isFlagged == false){ // if the tile hasn't been flagged
                    referenceTileGrid[x][y].markFlagged(); 
                    playerGrid[x][y] = "[⚐]";
                }
            }
        
            gameGrid.printMap(playerGrid);

            // checking if the user has won - must uncover all non-mine tiles
            gameOver = isGameOver(playerGrid, referenceStringGrid);

        }

        System.out.println("Congrats! You have won! :)");
    }

    // comparing the number of non-mine tiles in the actual grid to the player's current grid to see if they have won or not
    public boolean isGameOver(String[][] playerGrid, String[][] reference) {
        boolean gameOver;
        int numFlippedReference = 0;
        int numFlippedPlayer = 0;

        // counting the number of non-mine tiles in the player grid
        for(int i=0; i<playerGrid.length; i++){
            for(int j=0; j<playerGrid[i].length; j++){
                if(playerGrid[i][j] != "[⚐]" && playerGrid[i][j] != "[ ]"){
                    numFlippedPlayer++;
                }
            }
        }

        // counting the number of non-mine tiles in the real (reference) grid
        for(int i=0; i<reference.length; i++){
            for(int j=0; j<reference[i].length; j++){
                if(reference[i][j] != "[m]" && reference[i][j] != "[ ]"){
                    numFlippedReference++;
                }
            }
        }

        if(numFlippedPlayer == numFlippedReference){
            gameOver = true;
        }

        else{
            gameOver = false;
        }

        return gameOver;
    }

    // flipNearby recursive function that flips all the nearby tiles of a [s] if they should be flipped
    // only flips left, right, up, and down - not diagonals, because code was finished before the instructions were changed
    public String[][] flipNearby(String[][] reference, String[][] playerGrid, Tile[][] tileReference, int xDim, int yDim){

        boolean isTouchSafeTest = false;

        // getting the printed grid all up to date with the current status of the player's exposed grid
        for(int i=0; i<playerGrid.length; i++){
            for(int j=0; j<playerGrid[i].length; j++){
                flippedGrid[i][j] = playerGrid[i][j];      
            }
        }

        if(yDim > 0){ // going left

            isTouchSafeTest = touchingSafeRight(reference, flippedGrid, xDim, yDim - 1); // boolean for if the tile to the right is safe

            // just an edge = just uncover that single edge
            if((reference[xDim][yDim - 1].equals("[m]") == false) && (reference[xDim][yDim - 1].equals("[s]") == false) 
            && (tileReference[xDim][yDim - 1].isFlagged == false) && (tileReference[xDim][yDim - 1].isFlipped == false)){ 
                tileReference[xDim][yDim - 1].flip();
                flippedGrid[xDim][yDim - 1] = reference[xDim][yDim - 1];
            }

            // if its not an edge, must check conditions in order to continue in the direction
            else if((reference[xDim][yDim - 1].equals("[m]") == false) && (tileReference[xDim][yDim - 1].isFlagged == false)
                && (tileReference[xDim][yDim - 1].isFlipped == false) && (isTouchSafeTest == true)){ 

                tileReference[xDim][yDim - 1].flip();
                flippedGrid[xDim][yDim - 1] = reference[xDim][yDim - 1];
                flipNearby(reference, flippedGrid, tileReference, xDim, yDim - 1); // recursively calls flipNearby again
            }
        }
    
        if(yDim < (yDimension - 1)){ // going right

            isTouchSafeTest = touchingSafeLeft(reference, flippedGrid, xDim, yDim + 1); // boolean for if the tile to the left is safe

            if((reference[xDim][yDim + 1].equals("[m]") == false) && (reference[xDim][yDim + 1].equals("[s]") == false) 
            && (tileReference[xDim][yDim + 1].isFlagged == false) && (tileReference[xDim][yDim + 1].isFlipped == false)){ 
                tileReference[xDim][yDim + 1].flip();
                flippedGrid[xDim][yDim + 1] = reference[xDim][yDim + 1];
            }

            if(reference[xDim][yDim + 1].equals("[m]") == false && tileReference[xDim][yDim + 1].isFlagged == false 
                && tileReference[xDim][yDim + 1].isFlipped == false && (isTouchSafeTest == true)){ 

                tileReference[xDim][yDim + 1].flip();
                flippedGrid[xDim][yDim + 1] = reference[xDim][yDim + 1];
                flipNearby(reference, flippedGrid, tileReference, xDim, yDim + 1);
            } 
        }
    
        if(xDim > 0){ // going up

            isTouchSafeTest = touchingSafeDown(reference, flippedGrid, xDim - 1, yDim); // boolean for if the tile going down is safe

            if((reference[xDim - 1][yDim].equals("[m]") == false) && (reference[xDim - 1][yDim].equals("[s]") == false) 
            && (tileReference[xDim - 1][yDim].isFlagged == false) && (tileReference[xDim - 1][yDim].isFlipped == false)){ 
                tileReference[xDim - 1][yDim].flip();
                flippedGrid[xDim - 1][yDim] = reference[xDim - 1][yDim];
            }

            if(reference[xDim - 1][yDim].equals("[m]") == false && tileReference[xDim - 1][yDim].isFlagged == false
                && tileReference[xDim - 1][yDim].isFlipped == false && (isTouchSafeTest == true)){ 

                tileReference[xDim - 1][yDim].flip();
                flippedGrid[xDim - 1][yDim] = reference[xDim - 1][yDim];
                flipNearby(reference, flippedGrid, tileReference, xDim - 1, yDim);
            }
        }
    
        if(xDim < (xDimension - 1)){ // going down

            isTouchSafeTest = touchingSafeUp(reference, flippedGrid, xDim + 1, yDim); // boolean for if the tile going up is safe

            if((reference[xDim + 1][yDim].equals("[m]") == false) && (reference[xDim + 1][yDim].equals("[s]") == false) 
            && (tileReference[xDim + 1][yDim].isFlagged == false) && (tileReference[xDim + 1][yDim].isFlipped == false)){ 
                tileReference[xDim + 1][yDim].flip();
                flippedGrid[xDim + 1][yDim] = reference[xDim + 1][yDim];
            }

            if(reference[xDim + 1][yDim].equals("[m]") == false && tileReference[xDim + 1][yDim].isFlagged == false
                && tileReference[xDim + 1][yDim].isFlipped == false && (isTouchSafeTest == true)){ 

                tileReference[xDim + 1][yDim].flip();
                flippedGrid[xDim + 1][yDim] = reference[xDim + 1][yDim];
                flipNearby(reference, flippedGrid, tileReference, xDim + 1, yDim);
            }
        }

        // if it's just a single safe tile, flip it
        if(reference[xDim][yDim].equals("[s]")){ 
            tileReference[xDim][yDim].flip();
            flippedGrid[xDim][yDim] = reference[xDim][yDim];
        }

        return flippedGrid;
    }

    // checking if the tile is touching a safe tile to its right
    boolean touchingSafeRight(String[][] reference, String[][] playerVisibleGrid, int xDim, int yDim){
        boolean isTouch = false;

        if(yDim < (yDimension - 1)){
            if(reference[xDim][yDim + 1].equals("[s]") && playerVisibleGrid[xDim][yDim + 1].equals("[ ]") == false){
                isTouch = true;
            }
        }

        // if the tile itself is safe, then isTouch is automatically true
        if(reference[xDim][yDim].equals("[s]")){
            isTouch = true;
        } 

        return isTouch;
    }

    // checking if the tile is touching a safe tile to its left
    boolean touchingSafeLeft(String[][] reference, String[][] playerVisibleGrid, int xDim, int yDim){
        boolean isTouch = false;
        
        if(yDim > 0){
            if(reference[xDim][yDim - 1].equals("[s]") && playerVisibleGrid[xDim][yDim - 1].equals("[ ]") == false){
                isTouch = true;
            }
        }

        if(reference[xDim][yDim].equals("[s]")){
            isTouch = true;
        } 
        
        return isTouch;
    }

    // checking if the tile is touching a safe tile above itself
    boolean touchingSafeUp(String[][] reference, String[][] playerVisibleGrid, int xDim, int yDim){
        boolean isTouch = false;

        if(xDim > 0){
            if(reference[xDim - 1][yDim].equals("[s]") && playerVisibleGrid[xDim - 1][yDim].equals("[ ]") == false){
                isTouch = true;
            }
        }

        if(reference[xDim][yDim].equals("[s]")){
            isTouch = true;
        } 

        return isTouch;
    }

    // checking if the tile is touching a safe tile below itself
    boolean touchingSafeDown(String[][] reference, String[][] playerVisibleGrid, int xDim, int yDim){
        boolean isTouch = false;

        if(xDim < (xDimension - 1)){
            if(reference[xDim + 1][yDim].equals("[s]") && playerVisibleGrid[xDim + 1][yDim].equals("[ ]") == false){
                isTouch = true;
            }
        }

        if(reference[xDim][yDim].equals("[s]")){
            isTouch = true;
        } 
        
        return isTouch;
    }

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
