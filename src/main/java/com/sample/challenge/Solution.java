package com.sample.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){

         //int[] nums = {1,9, 5,0,20,-4,12,16,7,12};
         if(args.length!=2){
             System.out.println("The program receive two parameters pathFile and target sum");
             System.out.println("Please check de input.txt file that is located in resources for to understand the format");
             return;

         }
         String pathFile=args[0];
         int target = Integer.parseInt(args[1]);

        try {

            int[] nums = Files.lines(Paths.get(pathFile))
                    .mapToInt(Integer::parseInt).toArray();
            findPairsOfIntegers(nums,12);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public static void findPairsOfIntegers(int [] nums, int target){

        HashMap<Integer,Integer> data = new HashMap<>();

        for (int num : nums) {

            int temp = target - num;
            if (!data.containsKey(num)) {
                data.put(temp, num);
            } else {

                System.out.println(num + "," + data.get(num));

            }

        }


    }

}
