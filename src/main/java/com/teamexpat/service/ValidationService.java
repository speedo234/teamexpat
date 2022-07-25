package com.teamexpat.service;


import org.apache.commons.csv.CSVRecord;

import java.util.List;


public interface ValidationService {



    boolean isInputAnInteger( String number );

    boolean isValidArrayFormat( List<CSVRecord> csvRecordList );

}
