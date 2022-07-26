package com.teamexpat.service.impl;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class FileServiceImplTest {


    @InjectMocks
    FileServiceImpl fileService;

    @Value("${input.file.directory}")
    private String inputDirectoryString;


    @BeforeEach
    void setUp() {
    }

    @Test
    void convertStringToFile() {

        String inputDirectoryString = "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv";

        File actual = fileService.convertStringToFile(inputDirectoryString);

        assertThat(actual).isFile();

    }


    @Test
    void getCSVRecordsFromInputFile() throws IOException {

        String inputDirectoryString = "C:/Users/ibren/gitrepositories/java projects/teamexpat/src/main/resources/array.csv";

        File file = fileService.convertStringToFile(inputDirectoryString);

        List<CSVRecord> actual = fileService.getCSVRecordsFromInputFile( file );

        assertThat(actual.size()).isGreaterThan(0);
    }
}