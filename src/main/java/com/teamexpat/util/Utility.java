package com.teamexpat.util;

import com.teamexpat.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {


    public static Integer[][] getArrayForTraversal(){
        Integer[][] integerArrays = new Integer[4][4];
        try{
            integerArrays[0][0] = 1;
            integerArrays[0][1] = 2;
            integerArrays[0][2] = 3;
            integerArrays[0][3] = 4;
            //
            integerArrays[1][0] = 5;
            integerArrays[1][1] = 6;
            integerArrays[1][2] = 7;
            integerArrays[1][3] = 8;
            //
            integerArrays[2][0] = 9;
            integerArrays[2][1] = 10;
            integerArrays[2][2] = 11;
            integerArrays[2][3] = 12;
            //
            integerArrays[3][0] = 13;
            integerArrays[3][1] = 14;
            integerArrays[3][2] = 15;
            integerArrays[3][3] = 16;
        }catch (ArrayIndexOutOfBoundsException aioobe){
            throw new InvalidInputException("invalid array structure. array should be a 4 by 4 array.");
        }

        return integerArrays;
    }


    public static List<List<Integer>> convertMultidimensionalArrayToList(Integer[][] multidimensionalArray){
        List<List<Integer>> listArrayList = Arrays.stream(multidimensionalArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        return listArrayList;
    }


    public static void printResult(String result){
        System.out.println(result);
    }

}
