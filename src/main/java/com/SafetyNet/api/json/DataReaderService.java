package com.SafetyNet.api.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class DataReaderService {


    private static final Logger logger = LogManager.getLogger(DataReaderService.class);

    private ObjectMapper objectMapper = new ObjectMapper();
    private File         file         = new File("src/main/resources/Data.json");
    private DataReader   dataReader;

    private DataReader readJSONFile() throws Exception {

        dataReader = objectMapper.readValue(file, DataReader.class);

        if (dataReader != null) {
            logger.info("<--- Data.json file correctly loaded");
            return dataReader;
        } else {
            logger.error("while trying to read the Data.json file");
            return null;
        }

    }


    public DataReader getData() throws Exception {

        logger.info("Read data.json file");
        dataReader = readJSONFile();
        return dataReader;
    }
}
