package com.teamexpat.service.impl;



import com.teamexpat.service.ValidationService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidationServiceImpl implements ValidationService {



    @Override
    public boolean isValueMissing(Integer[][] multidimensionalArray) {

        boolean response = true;
        for(int y = 0; y < multidimensionalArray.length; y++){

            for(int x = 0; x < multidimensionalArray.length; x++){

                if( multidimensionalArray[y][x] == null ){
                    response = false;
                    break;
                }
            }
        }
        /*
        for(int i = 0; i < integerArrays.length; i++){
            if( integerArrays.length != integerArrays[i].length ){
                response = false;
                break;
            }
        }
        * */
        return response;
    }

}
