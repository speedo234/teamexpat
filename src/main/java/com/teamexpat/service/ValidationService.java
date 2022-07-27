package com.teamexpat.service;


import org.apache.commons.csv.CSVRecord;

import java.util.List;


public interface ValidationService {

    boolean isValueMissing( Integer[][] multidimensionalArray );

}
