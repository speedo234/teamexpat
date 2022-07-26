package com.teamexpat.service.impl;


import com.teamexpat.exception.ApplicationException;
import com.teamexpat.service.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {


    @Override
    public File convertStringToFile(String inputDirectoryString) {
        return new File(inputDirectoryString);
    }


    @Override
    public List<CSVRecord> getCSVRecordsFromInputFile(File file) throws IOException {
        CSVParser records = null;
        try{
             records = CSVFormat.EXCEL.parse(new InputStreamReader( new FileInputStream( file ) ));
        }catch (Exception e){
            e.printStackTrace();
            throw new FileNotFoundException("The specified input file does not exist.");
        }
        return records.getRecords();
    }
}
