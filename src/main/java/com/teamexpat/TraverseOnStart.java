package com.teamexpat;


import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.FileService;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;


@Component
public class TraverseOnStart implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraverseOnStart.class);

    @Value("${input.file.directory}")
    private String inputFileDirectory;

    @Autowired
    FileService fileService;

    @Autowired
    ArrayTraversalService arrayTraversalService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        File file = fileService.convertStringToFile(inputFileDirectory);//handle global exception here
        final List<CSVRecord> csvRecordsFromInputFile = fileService.getCSVRecordsFromInputFile(file);
        final List<List<Integer>> arrayFromCSVRecords = arrayTraversalService.getArrayFromCSVRecords(csvRecordsFromInputFile);
        String resultString = arrayTraversalService.doArrayTraversal(arrayFromCSVRecords);
        System.out.println(resultString);
    }


}
