public class Sort {
    public static void main (String[] args){
        int numbers[] = {99,84,70,112,138,157,22,171,124,90,102,191,184,93,140,22,8,15,101,124,51,129,165,60,67,88,123,97,101,188,40,106,56,55,94,87,89,97,86,66,135,170,113,20,199,89,198,29,168,28};
    


        // int[] numbers = {1,3,4,2,0}; // given numbers we need to sort
        int current_lowest; // index of lowest number we have found in the array so far
 
       
        for(int i=0; i<numbers.length-1; i++){
            current_lowest = i;
    
            for(int j=i+1; j<numbers.length; j++){ 
                if(numbers[current_lowest] < numbers[j]){
                    current_lowest = j; // found a new lowest value
                }
            }
 
            int temp = numbers[i];
            numbers[i] = numbers[current_lowest];
            numbers[current_lowest] = temp;
        }
 
        for(int k = 0; k<numbers.length; k++){ // for each integer in numbers
            System.out.println(numbers[k]);
        }
    }
}
