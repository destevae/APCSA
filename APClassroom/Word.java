import java.util.ArrayList;
import java.util.List;

public class Word {

    public static String scrambleWord(String word){
        boolean canScramble = false;
        ArrayList<Integer> cannotSwap = new ArrayList<Integer>();
        ArrayList<Integer> adjacent = new ArrayList<Integer>();

        for(int i = 0; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i))){
                canScramble = true;
            }
            else{
                canScramble = false;
                break;
            }
        }

        if(word.length() == 0){
            canScramble = true;
        }

        if(canScramble){
            for(int i = 0; i < word.length(); i++) {
                int rand = (int) ((Math.random() * word.length()));

                if((cannotSwap.contains(rand) == false) && (cannotSwap.contains(i) == false)) {
                    char temp;
                    temp = word.charAt(i);

                    char[] myChars = word.toCharArray(); // https://stackoverflow.com/questions/6952363/replace-a-character-at-a-specific-index-in-a-string
                    temp = myChars[rand];
                    myChars[rand] = myChars[i];
                    myChars[i] = temp;
                    word = String.valueOf(myChars);
                    
                    adjacent.add(rand);
                    adjacent.add(i);

                    for(int j = 0; j < adjacent.size(); j++){
                        for(int k = 0; k < adjacent.size(); k++){
                            if ((adjacent.get(k) == adjacent.get(j) + 1) || (adjacent.get(k) == adjacent.get(j) - 1)){
                                cannotSwap.add(k);
                                cannotSwap.add(j);
                            }
                        }
                    }
                }
            }

            return word;
            
        }

        return "cannot be scrambled";
    }

    public static void scrambleOrRemove(List<String> wordList){
        for(int i = 0; i < wordList.size(); i++){
            String word = wordList.get(i);
            word = scrambleWord(word);
            if(word == wordList.get(i)){
                wordList.remove(i);
            }
        }
    }

    public static void main(String[] args){
        Word word = new Word();
        System.out.println(Word.scrambleWord("HELLO"));

        List mylist = new List("hello", "world", "computers");
        
        System.out.println(Word.scrambleOrRemove(mylist));
    }
}

