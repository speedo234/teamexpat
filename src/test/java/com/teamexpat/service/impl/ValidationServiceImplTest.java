package com.teamexpat.service.impl;

import com.teamexpat.service.ValidationService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ValidationServiceImplTest {


    @InjectMocks
    ValidationServiceImpl validationService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void isInputAnInteger() {

        final String number = "9";
        boolean expected = true;

        boolean actual = validationService.isInputAnInteger(number);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isValidArrayFormat() throws IOException {

        FileInputStream inputFile = new FileInputStream( "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv");
        MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);

        boolean expected = true;

        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        List<CSVRecord> csvRecordList = records.getRecords();

        boolean actual = validationService.isValidArrayFormat(csvRecordList);

        assertThat(actual).isEqualTo(expected);

    }
}