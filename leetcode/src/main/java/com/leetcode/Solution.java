package com.leetcode;

/**
 * Algorithms.
 *
 * https://leetcode.com
 *
 */
public class Solution {

    public static void main(String[] args) {
//        titleToNumber("EO");
//        titleToNumber_2("EO");// 3 * 26^0 + 2 * 26^1 + 1 * 26^2

        lengthOfLastWord("a");
    }

	/*FIXME ---------------------------------------------------------------------------*/

    /**
     * 171 Excel Sheet Column Number
     *
     * Give a column title as apper in an Excel sheet,
     * return its corresponding column number.
     *
     * For example:
     * A --> 1, B --> 2, C --> 3
     * ...
     * Z --> 26, AA --> 27, AB -- 28
     * ...
     * AZ --> 52, BA --> 53, BB --> 54
     *
     * mine.
     */
    public static int titleToNumber(String s){
        int lenght = s.length() - 1;
        int num = 0;
        for(int i = 0 ; i <= lenght; i++){
            num += ((s.charAt(lenght - i) - 'A' + 1) * Math.pow(26,i));
        }
        return num;
    }

    /**
     * other
     */
    public static int titleToNumber_2(String s) {
        int l = s.length();
        int count = 0;
        for(int i = 0; i<l;i++ ){
            System.out.println(i + " b : " + s.charAt(i)  + " / " + count);
            count = count * 26  + s.charAt(i) - 'A' + 1;
            System.out.println(i + " a : " + s.charAt(i)  + " / " + count);
        }
        System.out.println("---------------");
        System.out.println("other : " + s + " --> " + count);
        return count;
    }

	/*FIXME ---------------------------------------------------------------------------*/

    /**
     * 	58 Length of Last Word
     *
     *  Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     *  return the length of last word in the string.
     *
     *  If the last word does not exist, return 0.
     *
     *  Note: A word is defined as a character sequence consists of non-space characters only.
     *
     *  For example:
     *	Given s = "Hello World",
     *	return 5.
     *
     */
    public static int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        int l = strs.length;
        if(l <= 0){
            return 0;
        }
        System.out.println("58 length Of Last Word : " + strs[l -1].length());
        return strs[l -1].length();
    }

	/*FIXME ---------------------------------------------------------------------------*/

    /**
     * n!
     */


}
