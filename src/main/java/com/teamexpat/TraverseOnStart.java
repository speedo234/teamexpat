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
import org.springframework.web.multipart.MultipartFile;

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

        File file = fileService.convertStringToFile(inputFileDirectory);
        MultipartFile multipartFile = fileService.convertFileToMultipartFile(file);
        final List<CSVRecord> csvRecordsFromInputFile = fileService.getCSVRecordsFromInputFile(multipartFile);
        LOGGER.info(":::1:::csvRecordsFromInputFile.size==> {} ", csvRecordsFromInputFile.size());

        final List<List<Integer>> arrayFromCSVRecords = arrayTraversalService.getArrayFromCSVRecords(csvRecordsFromInputFile);

        LOGGER.info(":::2:::arrayFromCSVRecords.size==> {} ", arrayFromCSVRecords.size());

        for( List<Integer> integerList :arrayFromCSVRecords){

            for( Integer integer :integerList){
                System.out.println(integer);
            }

        }


    }
}
