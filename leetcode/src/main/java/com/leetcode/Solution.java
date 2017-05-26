package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//        lengthOfLastWord("a");
//        twoSum(new int[]{0, 7, 9, 15}, 9);

//        int A[] = {1,2,3,4,5,6,7};
//        removeElement(A,A.length, 5);

//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        ListNode l2 = new ListNode(9);
//         l2.next = new ListNode(9);
//
//        ListNode ln =  addTwoNumbers(l1,l2);
//        while (ln != null) {
//            System.out.println("addTwoNumbers --> " + ln.val);
//            ln = ln.next;
//        }

//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc", ""};
        String[] strs = {"tea","and","ace","ad","eat","dans"};
        System.out.println("addTwoNumbers --> " +  groupAnagrams(strs).toString());

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


    /**
     * 1. Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * tags: Array, Hash Table
     *
     * mine.
     */
    public static int[] twoSum(int[] nums, int target) {
        int [] tags = new int[2];
        int temp;
        for(int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            for(int j = 0; j < nums.length; j++) {
                if(j != i && temp == nums[j]) {
                    tags[0] = i;
                    tags[1] = j;
                    System.out.println("twoSum ---> " + Arrays.toString(tags));
                    return tags;
                }
            }
        }
        return tags;
    }

    /**
     * 1. Two Sum
     * other
     */
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }




    /**
     * 83. Remove Duplicates from Sorted List
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     *
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ln = head;
        while(ln.next != null) {
            if (ln.val == ln.next.val) {
                ln.next = ln.next.next;
            }else {
                ln = ln.next;
            }
        }
        return head;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 2. Add Two Numbers
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ln = new ListNode(0);
        ListNode ln_t = ln;
        int temp;
        while (ln_t != null) {
            ln_t.next = new ListNode(0);
            if (l1 != null && l2 != null) {
                temp = l1.val + l2.val + ln_t.val;
            } else if (l1 != null) {
                temp = l1.val + ln_t.val;
            } else if (l2 != null) {
                temp = l2.val + ln_t.val;
            } else {
                temp = ln_t.val;
            }
            if (temp >= 10) {
                ln_t.val = temp % 10;
                ln_t.next.val = 1;
            } else {
                ln_t.val = temp;
            }
            if ((l2 == null || l2.next == null) && (l1 == null || l1.next == null) && ln_t.next.val == 0) {
                ln_t.next = null;
            }
            if (l1 != null && l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }
            if (l2 != null && l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }
            ln_t = ln_t.next;
        }
        return ln;
    }


    /**
     * 49. Group Anagrams
     * Given an array of strings, group anagrams together.
     *
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * [
     *  ["ate", "eat","tea"],
     *  ["nat","tan"],
     *  ["bat"]
     * ]
     *
     * fixme 尚未通过测试
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return null;
        Map<Integer, String> map = new HashMap<>();
        Set<String> s = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sc = strs[i].toCharArray();
            Arrays.sort(sc);
            StringBuffer temp = new StringBuffer();
            for (char c : sc) {
                temp.append((int)c);
            }
            if (temp.length() == 0) {
                s.add("-1");
                map.put(i, "-1");
            } else {
                s.add(temp.toString());
                map.put(i,temp.toString());
            }
        }
        List<String> l;
        List<List<String>> ll = new ArrayList<>();
        for (String str : s) {
            l = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (map.get(i).equals(str)){
                    l.add(strs[i]);
                }
            }
            ll.add(l);
        }
        return ll;
    }

    /**
     * other
     */
    public static List<List<String>> groupAnagrams_2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * todo
     */
    public static int removeElement(int A[], int n, int elem){
        int j = 0;
        System.out.println("before ---> " + Arrays.toString(A));
        for (int i = 0; i < n; i++) {
            if (A[i] == elem) {
                continue;
            }
            A[j] = A[i];
            j++;
        }
//        A = Arrays.copyOf(A, j);
        System.out.println("after ---> " + Arrays.toString(A));
        return j;
    }

}
