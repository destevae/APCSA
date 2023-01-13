import java.lang.Math;
import java.util.ArrayList;

public class Spinner{
    public int sectors;
    public ArrayList<Integer> myarraylist = new ArrayList<Integer>();

    public Spinner(int sector){
        sectors = sector;
    }

    // generates random number within sectors
    public int spin(){
        int rand = (int) ((Math.random() * sectors) + 1);

        // adding random number to an arraylist, if the number is the same as before
        for(int l = 0; l < 1; l++){
            if(myarraylist.isEmpty()){
                myarraylist.add(rand);
            }
            
            else{
                if(myarraylist.get(l) == rand){
                    myarraylist.add(rand);
                }

                else if (myarraylist.get(l) != rand){
                    myarraylist.clear();
                    myarraylist.add(rand);
                }
            }
        }

        return rand;
    }

    // counts the current streak of spinning same numbers
    public int currentRun(){
        int nums = 0;
        for(int j = 0; j < myarraylist.size(); j++){
            if(myarraylist.get(j) != null){
                nums++;
            }
        }

        return nums;
    }

    public static void main(String[] args){
        Spinner g = new Spinner(10);
        System.out.println(g.spin());
        System.out.println(g.spin());
        System.out.println(g.spin());
        System.out.println("Current run:" + g.currentRun());
    }
}

