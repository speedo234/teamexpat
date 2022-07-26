package com.teamexpat.service.impl;


import com.teamexpat.enums.Direction;
import com.teamexpat.exception.InvalidInputException;
import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.ValidationService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArrayTraversalServiceImpl implements ArrayTraversalService {


    ValidationService validationService;

    final static int positiveOffset = +1;
    private static final int negativeOffset = -1;


    @Autowired
    public ArrayTraversalServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    public List<List<Integer>> getArrayFromCSVRecords(List<CSVRecord> csvRecordList) {
        List<List<Integer>> listArrayList = new ArrayList<>();
        List<Integer> integerList = null;
        CSVRecord tempArrayLine = null;
        for (int x = 0; x < csvRecordList.size(); x++) {
            integerList = new ArrayList<>();

            tempArrayLine = csvRecordList.get(x);

            for(int i = 0; i < tempArrayLine.size(); i++){

                //todo refactor validation out to an independent loop
                if(!validationService.isInputAnInteger( tempArrayLine.get(i).trim() ))
                    throw new InvalidInputException("value '"+tempArrayLine.get(i).trim()+"' entered at index "+x+" "+i+" is NOT a valid integer...");

                integerList.add( Integer.parseInt( tempArrayLine.get(i).trim() ) );
            }
            listArrayList.add(integerList);
        }
        return listArrayList;
    }


    public String doArrayTraversal(List<List<Integer>> integerList){
        StringBuilder stringBuilder = new StringBuilder();
        Direction direction = Direction.RIGHT;

        final int fixedArrayLength = integerList.size()+negativeOffset;
        int shrinkingArrayLength = integerList.size()+negativeOffset;


        for(int startingPoint = 0; startingPoint < fixedArrayLength; startingPoint++ ){

            doRightTraversal( stringBuilder, shrinkingArrayLength, startingPoint, integerList);
            doDownTraversal( stringBuilder, shrinkingArrayLength, startingPoint, integerList);
            doLeftTraversal( stringBuilder, shrinkingArrayLength, startingPoint, integerList);
            doUpTraversal( stringBuilder, shrinkingArrayLength, startingPoint, integerList);

//            shrinkArrayLength( shrinkingArrayLength);
            shrinkingArrayLength = shrinkingArrayLength+negativeOffset;
        }
        return stringBuilder.toString();
    }


    private void doRightTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
            for(int x = 0; x <= shrinkingArrayLength-startingPoint; x++ ){
                stringBuilder.append( integerList.get(startingPoint).get(x+startingPoint) );
                appendComma(stringBuilder);
            }
            appendSpace(stringBuilder);
    }


    private void doDownTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int y = startingPoint+positiveOffset; y <= shrinkingArrayLength; y++ ){
            stringBuilder.append( integerList.get(y).get(shrinkingArrayLength) );
            appendComma(stringBuilder);
        }
        if(shrinkingArrayLength!=2)
            appendSpace(stringBuilder);
    }


    private void doLeftTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int x = shrinkingArrayLength+negativeOffset; x >= startingPoint; x-- ){
            stringBuilder.append( integerList.get(shrinkingArrayLength).get( x ) );
            if(shrinkingArrayLength!=2)
                appendComma(stringBuilder);
        }
        appendSpace(stringBuilder);
    }


    private void doUpTraversal(StringBuilder stringBuilder, int shrinkingArrayLength, int startingPoint, List<List<Integer>> integerList){
        for(int y = shrinkingArrayLength+negativeOffset; y >= startingPoint+positiveOffset; y-- ){
            stringBuilder.append( integerList.get(y).get(startingPoint) );
            appendComma(stringBuilder);
        }
        appendSpace(stringBuilder);
    }


    private void shrinkArrayLength(int shrinkingArrayLength){
        shrinkingArrayLength = shrinkingArrayLength+negativeOffset;
    }


    public void appendComma(StringBuilder stringBuilder){
        stringBuilder.append(",");
    }

    public void appendSpace(StringBuilder stringBuilder){
        stringBuilder.append(" ");
    }


}
