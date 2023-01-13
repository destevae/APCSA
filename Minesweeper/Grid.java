public class Grid {
    int xDimensions;
    int yDimensions;
    int minesNumber;

    Grid(int xDim, int yDim, int mineNum){ // grid constructor
        xDimensions = xDim;
        yDimensions = yDim;
        minesNumber = mineNum;
    }

    public Tile[][] gridCreate(){
        Tile[][] tileGrid = new Tile[xDimensions][yDimensions]; // creates minesweeper tile grid with given dimensions
        String[][] stringGrid = new String[xDimensions][yDimensions]; // string version of tile grid that will become reference

        for(int i=0; i<tileGrid.length; i++){
            for(int j=0; j<tileGrid[i].length; j++){
                Tile singleTile = new Tile(); // initialize tiles
                tileGrid[i][j] = singleTile;
            }
        }
        
        // placing mines at random positions
        for(int i = 0; i < minesNumber; i++){ 
            int x = (int) (Math.random() * xDimensions);
            int y = (int) (Math.random() * yDimensions);

            if(tileGrid[x][y] != null){
                while(tileGrid[x][y].isMine == true){ // not placing 2 mines in the same place
                    x = (int) (Math.random() * xDimensions);
                    y = (int) (Math.random() * yDimensions);
                }
            }

            tileGrid[x][y].markMine();
            stringGrid[x][y] = "[m]";
        }

        // finding mine edge tiles
        for(int i=0; i<tileGrid.length; i++){
            for(int j=0; j<tileGrid[i].length; j++){
                int up = i - 1; 
                int down = i + 1;
                int right = j + 1;
                int left = j - 1;

                if(stringGrid[i][j] != null && stringGrid[i][j].equals("[m]") == true){
                    continue;
                }

                // checking up
                if(up >= 0 && stringGrid[up][j] != null && stringGrid[up][j].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge(); // adds one to the number value of the edge tile
                    stringGrid[i][j] = numEdge;
                }

                // checking down
                if(down < xDimensions && stringGrid[down][j] != null && stringGrid[down][j].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                // checking left
                if(left >= 0 && stringGrid[i][left] != null && stringGrid[i][left].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                // checking down
                if(right < yDimensions && stringGrid[i][right] != null && stringGrid[i][right].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                // checking 4 diagonals
                if(left >= 0 && up >= 0 && stringGrid[up][left] != null && stringGrid[up][left].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                if(left >= 0 && down < xDimensions && stringGrid[down][left] != null && stringGrid[down][left].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                if(right < yDimensions && up >= 0 && stringGrid[up][right] != null && stringGrid[up][right].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }

                if(right < yDimensions && down < xDimensions && stringGrid[down][right] != null && stringGrid[down][right].equals("[m]") == true){
                    String numEdge = tileGrid[i][j].markEdge();
                    stringGrid[i][j] = numEdge;
                }
            }
        }
        
        // making the remaining tiles safe
        for(int i=0; i<stringGrid.length; i++){
            for(int j=0; j<stringGrid[i].length; j++){
                if(stringGrid[i][j] == null){
                    stringGrid[i][j] = "[s]";
                    tileGrid[i][j].isSafe();
                }
            }
        }

        return tileGrid; 
    }

    // convert from tile 2D array to string 2D array
    public String[][] getStringArray(Tile[][] tileGrid){
        String[][] returnStringGrid = new String[xDimensions][yDimensions];

        for(int i=0; i<tileGrid.length; i++){
            for(int j=0; j<tileGrid[i].length; j++){
                if(tileGrid[i][j].isMine == true){
                    returnStringGrid[i][j] = "[m]";
                }

                else if(tileGrid[i][j].isMineEdge == true){
                    returnStringGrid[i][j] = "[" + (String.valueOf(tileGrid[i][j].minesNear)) + "]";
                }

                else{
                    returnStringGrid[i][j] = "[s]";
                }
            }
        }

        return returnStringGrid;
    }

    // convert from string 2D array to tile 2D array
    public Tile[][] getTileArray(String[][] stringGrid){
        Tile[][] returnTileGrid = new Tile[xDimensions][yDimensions];

        for(int i=0; i<returnTileGrid.length; i++){
            for(int j=0; j<returnTileGrid[i].length; j++){
                if(stringGrid[i][j] == "[m]"){
                    Tile mineTile = new Tile();
                    mineTile.isMine = true;
                    returnTileGrid[i][j] = mineTile;
                }

                else if (stringGrid[i][j] == "[s]"){
                    Tile safeTile = new Tile();
                    returnTileGrid[i][j] = safeTile;
                }

                else{
                    Tile aTile = new Tile();
                    aTile.isMineEdge = true;
                    returnTileGrid[i][j] = aTile;
                }
            }
        }

        return returnTileGrid;
    }

    // print the map based on string input
    public void printMap(String[][] playerGrid){

        Colors mycolors = new Colors();

        // formating of the column numbers above the map
        String columnNumbers = "   ";
        for(int i = 0; i < yDimensions; i++) {
            if(i >= 10){
                columnNumbers += i + " ";
            }
            else{
                columnNumbers += i + "  ";
            }
        }

        System.out.println(mycolors.purple + columnNumbers + mycolors.reset);
        
        // looping to print out array
        for(int i=0; i < playerGrid.length; i++){
            System.out.print(mycolors.purple + i + " " + mycolors.reset); // formatting of the row numbers
            for(int j=0; j < playerGrid[i].length; j++){

                // prints out grid in different colors based on the tile status
                if(playerGrid[i][j].equals("[s]")){
                    System.out.print(mycolors.green + playerGrid[i][j] + mycolors.reset);
                }

                else if(playerGrid[i][j].equals("[m]")){
                    System.out.print(mycolors.red + playerGrid[i][j] + mycolors.reset);
                }

                else if(playerGrid[i][j].equals("[⚐]")){
                    System.out.print(mycolors.yellow + playerGrid[i][j] + mycolors.reset);
                }

                else if(playerGrid[i][j].equals("[ ]")){
                    System.out.print(mycolors.white + playerGrid[i][j] + mycolors.reset);
                }

                else{
                    System.out.print(mycolors.blue + playerGrid[i][j] + mycolors.reset);
                }
                    
            }
            System.out.println(" ");
        }
    }
}
