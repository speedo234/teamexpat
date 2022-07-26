package com.teamexpat.service.impl;


import com.teamexpat.service.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {


    @Override
    public File convertStringToFile(String inputDirectoryString) {
        return new File(inputDirectoryString);
    }


    @Override
    public List<CSVRecord> getCSVRecordsFromInputFile(File file) throws IOException {
        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader( new FileInputStream( file ) ));
        return records.getRecords();
    }
}
