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
    void isValueMissing() throws IOException {

        Integer[][] integerArrays = new Integer[4][4];
        integerArrays[0][0] = 1;
        integerArrays[0][1] = 2;
        integerArrays[0][2] = 3;
        integerArrays[0][3] = 4;
        //
        integerArrays[1][0] = 5;
        integerArrays[1][1] = 6;
        integerArrays[1][2] = 7;
        integerArrays[1][3] = 8;
        //
        integerArrays[2][0] = 9;
        integerArrays[2][1] = 10;
        integerArrays[2][2] = 11;
        integerArrays[2][3] = 12;
        //
        integerArrays[3][0] = 13;
        integerArrays[3][1] = 14;
        integerArrays[3][2] = 15;
        integerArrays[3][3] = 16;

        boolean expected = false;

        boolean actual = validationService.isValueMissing(integerArrays);

        assertThat(actual).isEqualTo(expected);

    }
}