package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{20, 37, 20, 21}, 1)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> list = new ArrayList<>();
        List<Integer> reverseList = new ArrayList<>();

        Arrays.stream(elements).forEach(list::add);
        Arrays.stream(elements).forEach(reverseList::add);
        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(t -> t));

        Collections.reverse(reverseList);
        int count = 0;
        for(int i = 0; i < list.size();i++) {
            Integer comparingObject = list.get(i);
            for(int j = 0; j < reverseList.size();j++) {
                if(comparingObject == reverseList.get(j)) {
                    count++;
                    if(count > maxOccurrences) {
                        reverseList.remove(comparingObject);
                        count--;
                    }
                }
            }
            count = 0;
        }
        Collections.reverse(reverseList);
        return reverseList.stream().mapToInt(v -> v).toArray();
    }
}