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
        updatedArrayLength = integerList.size()-1;
        int xStart = 0, yStart = 0, xEnd = integerList.size()-1, yEnd= integerList.size()-1;
        final int positiveOffset = +1;
        final int negativeOffset = -1;
        //
        int control = updatedArrayLength;
        System.out.println(":::1:::updatedArrayLength=-> "+updatedArrayLength);


        for(int startingPoint = 0; startingPoint < 2/*updatedArrayLength*/; startingPoint++ ){

            if(direction == Direction.RIGHT){
                for(int x = 0; x <= control-startingPoint; x++ ){
                    stringBuilder.append( integerList.get(startingPoint).get(x+startingPoint) );//todo zeros should use the iteration index variable to move accordingly
                    doSingleLineProcessor(stringBuilder);
                }
                doSpacing(stringBuilder);
                direction = Direction.DOWN;
            }
            //
            if(direction == Direction.DOWN){
                for(int y = startingPoint+positiveOffset; y <= control; y++ ){//todo zeros or x variable should use the iteration index variable to move accordingly
                    stringBuilder.append( integerList.get(y).get(control) );
                    doSingleLineProcessor(stringBuilder);
                }
                if(control!=2)
                    doSpacing(stringBuilder);
                direction = Direction.LEFT;
                yStart = yStart+positiveOffset;
            }
            //
            if(direction == Direction.LEFT){
                for(int x = control-1; x >= startingPoint; x-- ){
                    stringBuilder.append( integerList.get(control).get( x ) );
                    doSingleLineProcessor(stringBuilder);
                }
                doSpacing(stringBuilder);
                direction = Direction.UP;
            }
            //
            if(direction == Direction.UP){
                for(int y = control-1; y >= yStart; y-- ){//todo zeros or x variable should use the iteration index variable to move accordingly
                    stringBuilder.append( integerList.get(y).get(startingPoint) );
                    doSingleLineProcessor(stringBuilder);
                }
                doSpacing(stringBuilder);
                direction = Direction.RIGHT;
                xStart = xStart+positiveOffset;
            }
            control = control-1;
        }


        return stringBuilder.toString();
    }



    private void doMultiLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
        if(indexControl+1 != listSize)
            stringBuilder.append(",");

        if((indexControl+1) % listSize == 0)
            stringBuilder.append("\n");
    }


    public void doSingleLineProcessor(StringBuilder stringBuilder){
        stringBuilder.append(",");
    }

    public void doSpacing(StringBuilder stringBuilder){
        stringBuilder.append("   ");
    }


}
