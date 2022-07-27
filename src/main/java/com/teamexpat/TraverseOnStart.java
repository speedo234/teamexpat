package com.teamexpat;


import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.FileService;
import com.teamexpat.util.Utility;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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

        Integer[][] multidimensionalArray = Utility.getArrayForTraversal();
        //
        List<List<Integer>> listArrayList = Arrays.stream(multidimensionalArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        //
        for(List<Integer> integerList: listArrayList){
            System.out.println(integerList);
        }
        //
        String resultString = arrayTraversalService.doArrayTraversal(listArrayList);
        System.out.println(resultString);
    }


}
