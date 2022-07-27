package com.teamexpat.service.impl;


import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.ValidationService;
import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArrayTraversalServiceImpl implements ArrayTraversalService {


    ValidationService validationService;

    private static final int POSITIVE_OFFSET = +1;
    private static final int NEGATIVE_OFFSET = -1;
    private static final int LOWER_LIMIT = 2;


    @Autowired
    public ArrayTraversalServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }


    public String doArrayTraversal(List<List<Integer>> integerList){
        StringBuilder stringBuilder = new StringBuilder();

        final int fixedArrayLength = integerList.size();

        //Used MutableInt to be able to pass this variable by reference and not pass by value
        MutableInt shrinkingArrayLength = new MutableInt(integerList.size()+NEGATIVE_OFFSET);


        //Used the startingPoint index to progressively shift the starting point for x-axis and y-axis with each iteration
        for(int startingPoint = 0; startingPoint < (fixedArrayLength/LOWER_LIMIT); startingPoint++ ){
            doRightTraversal( stringBuilder, shrinkingArrayLength.getValue(), startingPoint, integerList);
            doDownTraversal( stringBuilder, shrinkingArrayLength.getValue(), startingPoint, integerList);
            doLeftTraversal( stringBuilder, shrinkingArrayLength.getValue(), startingPoint, integerList);
            doUpTraversal( stringBuilder, shrinkingArrayLength.getValue(), startingPoint, integerList);
            shrinkArrayLength( shrinkingArrayLength);
        }
        return stringBuilder.toString();
    }


    /**
     * <p>Traverse the array to the right direction only</p>
     * @param stringBuilder
     * @param shrinkingArrayLength
     * @param startingPoint
     * @param integerList
     */
    private void doRightTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
            for(int x = 0; x <= shrinkingArrayLength-startingPoint; x++ ){
                stringBuilder.append( integerList.get(startingPoint).get(x+startingPoint) );
                appendComma(stringBuilder);
            }
            appendSpace(stringBuilder);
    }


    /**
     * <p>Traverse the array to the downward direction only</p>
     * @param stringBuilder
     * @param shrinkingArrayLength
     * @param startingPoint
     * @param integerList
     */
    private void doDownTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int y = startingPoint+POSITIVE_OFFSET; y <= shrinkingArrayLength; y++ ){
            stringBuilder.append( integerList.get(y).get(shrinkingArrayLength) );
            appendComma(stringBuilder);
        }
        if(shrinkingArrayLength!=LOWER_LIMIT)
            appendSpace(stringBuilder);
    }


    /**
     * <p>Traverse the array to the left direction only</p>
     * @param stringBuilder
     * @param shrinkingArrayLength
     * @param startingPoint
     * @param integerList
     */
    private void doLeftTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int x = shrinkingArrayLength+NEGATIVE_OFFSET; x >= startingPoint; x-- ){
            stringBuilder.append( integerList.get(shrinkingArrayLength).get( x ) );
            if(shrinkingArrayLength!=LOWER_LIMIT)
                appendComma(stringBuilder);
        }
        if(shrinkingArrayLength!=LOWER_LIMIT)
            appendSpace(stringBuilder);
    }


    /**
     * <p>Traverse the array to the upward direction only</p>
     * @param stringBuilder
     * @param shrinkingArrayLength
     * @param startingPoint
     * @param integerList
     */
    private void doUpTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int y = shrinkingArrayLength+NEGATIVE_OFFSET; y >= startingPoint+POSITIVE_OFFSET; y-- ){
            stringBuilder.append( integerList.get(y).get(startingPoint) );
            appendComma(stringBuilder);
        }
        if(shrinkingArrayLength!=LOWER_LIMIT)
            appendSpace(stringBuilder);
    }


    /**
     * <p>This method decrements the size of the array by 1 for each complete iteration effectively controlling the boundary for the next iteration</p>
     * @param shrinkingArrayLength
     */
    private void shrinkArrayLength(MutableInt shrinkingArrayLength){
        shrinkingArrayLength.decrement();
    }


    /**
     * <p>This method appends a comma to the stringBuilder</p>
     * @param stringBuilder
     */
    public void appendComma(StringBuilder stringBuilder){
        stringBuilder.append(",");
    }


    /**
     * <p>This method appends a single space to the stringBuilder</p>
     * @param stringBuilder
     */
    public void appendSpace(StringBuilder stringBuilder){
        stringBuilder.append(" ");
    }


}
