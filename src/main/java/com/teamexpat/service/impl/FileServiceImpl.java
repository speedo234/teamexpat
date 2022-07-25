package com.teamexpat.service.impl;


import com.teamexpat.service.ArrayTraversalService;
import com.teamexpat.service.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {


    @Override
    public File convertStringToFile(String inputDirectoryString) {
        return new File(inputDirectoryString);
    }

    @Override
    public MultipartFile convertFileToMultipartFile(File inputDirectoryFile) throws IOException {
        FileInputStream input = new FileInputStream(inputDirectoryFile);
        MultipartFile multipartFile = new MockMultipartFile("file",
                inputDirectoryFile.getName(), "text/plain", IOUtils.toByteArray(input));
        return multipartFile;
    }

    @Override
    public List<CSVRecord> getCSVRecordsFromInputFile(MultipartFile file) throws IOException {
        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        return records.getRecords();
    }
}
