package com.pattern.two_pointers;

public class ValidWordAbbreviation {
    public static void main(String[] args) {

        String word ="z";
        String abbr= "2";
        System.out.println("Result : " + validWordAbbreviation(word,abbr));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex=0;
        int abbrIndex=0;
        while(abbrIndex < abbr.length()){
        char letter = abbr.charAt(abbrIndex);
            if(letter == '0'){
               /* abbrIndex++;
                continue;*/
                return false;
            }
            if(Character.isDigit(letter)){
//                int digitValue = Integer.parseInt(String.valueOf(letter));
                StringBuilder sb = new StringBuilder();
                for(int i=abbrIndex;i<abbr.length();i++){
                    if(Character.isDigit(abbr.charAt(i))){
                        int value = Integer.parseInt(String.valueOf(abbr.charAt(i)));
                        sb.append(value);
                    }else {
                        break;
                    }
                }
                int digitValue = Integer.parseInt(sb.toString());
             /*   if(digitValue == 0){
                   abbrIndex = abbrIndex + sb.length();
                }else{*/
                abbrIndex = abbrIndex + sb.length();
                wordIndex = wordIndex + digitValue;
                /*}*/
            }else{

                if(wordIndex >= word.length() || abbr.charAt(abbrIndex) != word.charAt(wordIndex)){
                    return false;
                }
                    abbrIndex++;
                    wordIndex++;

            }
        }
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}
