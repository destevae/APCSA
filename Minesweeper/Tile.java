public class Tile {

    // all boolean and int attributes of tiles
    boolean isMine = false;
    boolean isFlagged = false;
    boolean isMineEdge = false;
    boolean isSafe = false;
    boolean isFlipped = false;
    int minesNear = 0;
    
    Tile(){}

    public String markMine(){
        isMine = true;
        return "[m]";
    }

    public String markEdge(){
        if(isMineEdge = false){
            minesNear = 0;
        }

        isMineEdge = true;
        minesNear++; // can continuiously increase the number value of the edge tile
        return "[" + minesNear + "]";
    }

    public String markFlagged(){
        isFlagged = true;
        return "[f]";
    }

    public void isSafe(){
        isSafe = true; 
    }

    public void flip(){
        isFlipped = true;
    }
}
