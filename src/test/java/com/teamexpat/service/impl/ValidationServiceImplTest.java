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

import java.io.*;
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

        final String inputFileDirectory = "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv";
        final File file = new File(inputFileDirectory);

        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader( new FileInputStream( file ) ));
        List<CSVRecord> csvRecordList = records.getRecords();

        boolean expected = true;

        boolean actual = validationService.isValidArrayFormat(csvRecordList);

        assertThat(actual).isEqualTo(expected);

    }
}