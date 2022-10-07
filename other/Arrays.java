public class Arrays {
    public static void main(String[] args){
        int numNums = 0;
        int myArray[] = new int[50];
        for (int i = 0; i < 5000; i++){
            if (numNums < 51){
                boolean primeBool = false;
                primeBool = isPrime(i);
                if (primeBool == true){ // if number is prime
                    myArray[numNums] = i;
                    numNums++;
                }
            }

            if (numNums == 50){ // make sure for loop doesn't go infinitely
                break;
            }
        }

        for (int k = 0; k < 50; k++){
            System.out.println(myArray[k]);
        }
    }


    static boolean isPrime(int n){ // https://en.wikipedia.org/wiki/Primality_test#C,_C++,_C#_&_D
        if (n == 2 || n == 3){
            return true;
        }

        if (n <= 1 || n % 2 == 0 || n % 3 == 0){
            return false;
        }
        
        for (int i = 5; i * i <= n; i += 6){
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}

