package com.teamexpat.service;


import org.apache.commons.csv.CSVRecord;

import java.util.List;


public interface ArrayTraversalService {


    List<List<Integer>> getArrayFromCSVRecords(List<CSVRecord> csvRecordList);


    String doArrayTraversal(List<List<Integer>> integerList1);


}
