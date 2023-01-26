package com.two.pointer;

public class BackspaceCompare {

    public static void main(String[] args) {

        String s1="xy#z";
        String s2="xzz#";

        System.out.println("Given Strings are "+(areStringsEqual(s1,s2) ? "equal" : "not equal"));

    }

    private static boolean areStringsEqual(String s1, String s2) {

        int index1 = s1.length()-1;
        int index2 = s2.length()-1;

        while(index1 >= 0 || index2 >= 0){

            int i1 = getValidIndex(s1,index1);
            int i2 = getValidIndex(s2,index2);

            if(i1 < 0 && i2 < 0){
                return true;
            }

            if(i1 < 0 || i2 < 0){
                return false;
            }

            if(s1.charAt(i1) != s2.charAt(i2)){
                return false;
            }

            index1 = i1-1;
            index2 = i2-1;

        }
        return true;
    }

    private static int getValidIndex(String str, int index) {

        int backspaceCount =0;
        while(index >= 0){

            if(str.charAt(index) == '#'){
                backspaceCount++;
            }else if(backspaceCount > 0){
                backspaceCount--;
            }else{
                break;
            }

            index--;
        }

        return index;
    }

}
