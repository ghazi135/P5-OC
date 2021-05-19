package com.SafetyNet.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Log4j2
public class DataReaderService {



    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File         file         = new File("src/main/resources/Data.json");
    private       DataReader   dataReader;

    private DataReader readJSONFile() throws Exception {

        dataReader = objectMapper.readValue(file, DataReader.class);

        if (dataReader != null) {
            log.info("<--- Data.json file correctly loaded");
            return dataReader;
        } else {
            log.error("while trying to read the Data.json file");
            return null;
        }

    }


    public DataReader getData() throws Exception {

        log.info("Read data.json file");
        dataReader = readJSONFile();
        return dataReader;
    }
}
