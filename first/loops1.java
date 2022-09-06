package first;
class loops1{
    public static void main(String[] args){
        int x = 0;
        int y = 0;
        for(x=0; x<20; x++){
            if(x==4 || x==6 || x==8){
                System.out.println("goteem");
            }
            if(x<12 && x>3) {
                y = y + 5;
                System.out.println(y);
            }
        }
        
    }
}


