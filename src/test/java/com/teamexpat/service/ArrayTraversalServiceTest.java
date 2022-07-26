package com.teamexpat.service;

import com.teamexpat.service.impl.ArrayTraversalServiceImpl;
import com.teamexpat.service.impl.ValidationServiceImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ArrayTraversalServiceTest {


    FileInputStream inputFile;
    MockMultipartFile file;

    @InjectMocks
    ArrayTraversalServiceImpl arrayTraversalService;

    @Mock
    ValidationServiceImpl validationService;

    private List<List<Integer>> integerList1;

    @BeforeEach
    void setUp() throws IOException {
        inputFile = new FileInputStream( "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv");
        file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);

        integerList1 = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(1,2,3);
        integerList1.add(integerList);
        integerList = Arrays.asList(4,5,6);
        integerList1.add(integerList);
        integerList = Arrays.asList(7,8,9);
        integerList1.add(integerList);
    }

    @Test
    void getArrayFromCSVRecords() throws IOException {

        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        List<CSVRecord> csvRecordList = records.getRecords();

        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);

        List<List<Integer>> listArrayList = arrayTraversalService.getArrayFromCSVRecords(csvRecordList);

        assertThat(listArrayList.size()).isGreaterThan(0);

    }

    @Disabled
    void doArrayTraversal() {
    }
}