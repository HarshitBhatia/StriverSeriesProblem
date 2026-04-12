package Interview;

import java.util.HashMap;

public class Altimetrik {
    public static void main(String[] args) {
        //2nd Non repeating
        String input ="AAHHBYUTT";
        System.out.println(find2ndNonRepeatingCharacter(input));

    }

    private static Character find2ndNonRepeatingCharacter(String input) {
        //Find 2nd Non Repeating Character
        Integer x=127;
        Integer y=127;
        System.out.println(x==y);

        HashMap<Character, Integer> freqMap=new HashMap<>();
        //Store Frequency of each Character in given input String
        for(char ch: input.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        //Now compute data of Map
        int counter=0;
//        for(int i = 0; i< input.length(); i++){
//            if(freqMap.get(input.charAt(i))>1){
////                counter++;
////                if(counter==2){
//                return input.charAt(i);
//            }
//        }

        // A- 65; B- 66
//        System.out.println((char)65);
        for(int i=65;i<92;i++) {
            if (freqMap.containsKey((char) i)) {
                if (freqMap.get((char) i) == 1) {
                    counter++;
                    if (counter == 2) {
                        return (char) i;
                    }
                }
            }
        }
        return null;
    }
}
