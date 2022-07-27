package com.teamexpat.service;


import org.apache.commons.csv.CSVRecord;

import java.util.List;


public interface ValidationService {

    /**
     * This method checks if the multidimensionalArray has any element with a null value
     * @param multidimensionalArray
     * @return true if there is a null element found or false if no null element was found
     */
    boolean isValueMissing( Integer[][] multidimensionalArray );

}
