package com.teamexpat.service;


import org.apache.commons.csv.CSVRecord;

import java.util.List;


/**
 * <p>Currently this ValidationService has only one method <code>isValueMissing()</code> for validation of missing values in array elements</p>
 * <br>
 * <p><code>Possible improvement</code></p>
 * <p>Add another method to validate the data types contained in the arrays.</p>
 * <p>This improvement will be useful if the array values are being read from a csv file, since the values will first be read as strings</p>
 * <p>before being converted into Integers.</p>
 * <p>For now the strict typing of the arrays which is an inherent <code>Java</code> feature helps ensure that wrong data types cannot be populated in the generated array.</p>
 */
public interface ValidationService {

    /**
     * This method checks if the multidimensionalArray has any element with a null value
     * @param multidimensionalArray
     * @return True if there is a null element found or false if no null element was found
     */
    boolean isValueMissing( Integer[][] multidimensionalArray );

}
