package com.teamexpat.service;

import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {


    File convertStringToFile(String inputDirectoryString);

    MultipartFile convertFileToMultipartFile(File inputDirectoryFile) throws IOException;

    List<CSVRecord> getCSVRecordsFromInputFile(MultipartFile file) throws IOException;


}
