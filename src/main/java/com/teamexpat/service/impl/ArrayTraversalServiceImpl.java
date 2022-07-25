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
        int updatedArrayLength = 0;
        updatedArrayLength = integerList.size();
        int xStart, yStart, xEnd, yEnd= 0;
        final int rightOffset = +1;
        final int leftOffset = -1;
        //
        xEnd = integerList.size();
        yEnd= integerList.size();

        if(direction == Direction.RIGHT){
            for(int x = 0; x < updatedArrayLength; x++ ){
                stringBuilder.append( integerList.get(0).get(x) );//todo zeros should use the iteration index variable to move accordingly
                doSingleLineProcessor(stringBuilder, x, integerList.size());
            }
            direction = Direction.DOWN;
        }
        if(direction == Direction.DOWN){
            for(int y = 1; y < updatedArrayLength; y++ ){//todo zeros or x variable should use the iteration index variable to move accordingly
                stringBuilder.append( integerList.get(y).get(updatedArrayLength-1) );
                doSingleLineProcessor(stringBuilder, y, integerList.size());
            }
            direction = Direction.LEFT;
        }
        if(direction == Direction.LEFT){
            for(int x = updatedArrayLength-1; x > 0; x-- ){
                stringBuilder.append( integerList.get(updatedArrayLength-1).get(x-1) );
                doSingleLineProcessor(stringBuilder, x, integerList.size());
            }
            direction = Direction.UP;
            updatedArrayLength = updatedArrayLength-2;
        }


        stringBuilder.append("```");
        return stringBuilder.toString();
    }



    private void doMultiLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
        if(indexControl+1 != listSize)
            stringBuilder.append(",");

        if((indexControl+1) % listSize == 0)
            stringBuilder.append("\n");
    }


    public void doSingleLineProcessor(StringBuilder stringBuilder, int listSize, int elementCount){
        stringBuilder.append(",");
    }


}
