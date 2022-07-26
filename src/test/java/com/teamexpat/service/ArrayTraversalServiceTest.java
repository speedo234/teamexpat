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


    @InjectMocks
    ArrayTraversalServiceImpl arrayTraversalService;

    @Mock
    ValidationServiceImpl validationService;

    @BeforeEach
    void setUp() throws IOException {
    }

    @Test
    void getArrayFromCSVRecords() throws IOException {

        FileInputStream inputFile = new FileInputStream( "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv");
        MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);

        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        List<CSVRecord> csvRecordList = records.getRecords();

        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);

        List<List<Integer>> actual = arrayTraversalService.getArrayFromCSVRecords(csvRecordList);

        assertThat(actual.size()).isGreaterThan(0);

    }

    @Test
    void doArrayTraversal() {

        List<List<Integer>> integerList1 = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(1,2,3,4);
        integerList1.add(integerList);
        integerList = Arrays.asList(5,6,7,8);
        integerList1.add(integerList);
        integerList = Arrays.asList(9,10,11,12);
        integerList1.add(integerList);
        integerList = Arrays.asList(13,14,15,16);
        integerList1.add(integerList);

        final String expected = "1,2,3,4, 8,12,16, 15,14,13, 9,5, 6,7, 11,10";

        String actual = arrayTraversalService.doArrayTraversal(integerList1);

        assertThat(actual).isEqualTo(expected);

    }
}