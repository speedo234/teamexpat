package com.teamexpat.service.impl;


import com.teamexpat.service.ValidationService;
import org.springframework.stereotype.Service;


@Service
public class ValidationServiceImpl implements ValidationService {



    @Override
    public boolean isValueMissing(Integer[][] multidimensionalArray) {
        boolean response = false;
        for(int y = 0; y < multidimensionalArray.length; y++){

            for(int x = 0; x < multidimensionalArray.length; x++){

                if( multidimensionalArray[y][x] == null ){
                    response = true;
                    break;
                }
            }
        }
        return response;
    }

}
