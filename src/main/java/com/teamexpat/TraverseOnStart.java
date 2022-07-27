package com.teamexpat;


import com.teamexpat.exception.ApplicationException;
import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.ValidationService;
import com.teamexpat.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class TraverseOnStart implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraverseOnStart.class);

    @Autowired
    ArrayTraversalService arrayTraversalService;

    @Autowired
    ValidationService validationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Integer[][] multidimensionalArray = Utility.getArrayForTraversal();

        if(!validationService.isValueMissing(multidimensionalArray))
            throw new ApplicationException("provided array has missing values in one or more elements.");

        final List<List<Integer>> listArrayList = Utility.convertMultidimensionalArrayToList(multidimensionalArray);

        for( List<Integer> list :listArrayList){
            System.out.println(list);
        }

        final String resultString = arrayTraversalService.doArrayTraversal(listArrayList);
        System.out.println(resultString);
    }


}
