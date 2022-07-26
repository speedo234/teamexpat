package com.teamexpat.service;

import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileService {


    File convertStringToFile(String inputDirectoryString);

    List<CSVRecord> getCSVRecordsFromInputFile(File file) throws IOException;


}
