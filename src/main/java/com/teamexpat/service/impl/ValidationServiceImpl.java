package com.teamexpat.service.impl;



import com.teamexpat.service.ValidationService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidationServiceImpl implements ValidationService {



    public boolean isInputAnInteger( String number ){
        try{
            Integer.parseInt( number );
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }

    }

    @Override
    public boolean isValidArrayFormat(List<CSVRecord> csvRecordList) {
        boolean response = true;
        for(int i = 0; i < csvRecordList.size(); i++){
            if( csvRecordList.size() != csvRecordList.get(i).size() ){
                response = false;
                break;
            }
        }
        return response;
    }

}
