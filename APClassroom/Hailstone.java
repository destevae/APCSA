import java.util.ArrayList;

public class Hailstone {
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args){
        propLong(10);
    }
    
    public static int hailstoneLength(int n){
        list.add(n);

        while (n != 1){
            if(n % 2 == 0){ // if n is even
                n /= 2;
                list.add(n);
            }
    
            else if (n % 2 == 1){ // if n is odd
                n = 3*n + 1;
                list.add(n);
            }
        }

        System.out.println(list);
        return list.size();

    }

    public static boolean isLongSeq(int n){
        list.clear();
        int hLength = hailstoneLength(n);

        if(hLength > n){
            return true;
        }

        else{
            return false;
        }
    }
    
    public static double propLong(int n){
        int i = n;
        double nTrue = 0.0;

        while(i > 0){
            System.out.println(i);
            boolean isLong = isLongSeq(i);

            if(isLong == true){
                nTrue++;
            }

            i--;
        }

        double returnS = nTrue / (double) n;
        System.out.println(returnS);
        return returnS;
    }
}

