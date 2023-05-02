package com.epam.training.ekaterina_sycheva.hardcore.service;

import com.epam.training.ekaterina_sycheva.hardcore.model.ComputeEngineCalculator;

public class CalculatorCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operatingSystemType";
    public static final String TESTDATA_PROVISIONING_MODEL = "testdata.provisioningModel";
    public static final String TESTDATA_SERIES = "testdata.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machineType";
    public static final String TESTDATA_ADD_GPU = "testdata.addGPU";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpuType";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.numberOfGpus";
    public static final String TESTDATA_LOCAL_SSD = "testdata.localSsd";
    public static final String TESTDATA_DATACENTER_LOCATION_ = "testdata.dataCenterLocation";
    public static final String TESTDATA_COMMITED_USAGE = "testdata.commitedUsage";



    public static ComputeEngineCalculator withCredentialsFromProperty() {
        return new ComputeEngineCalculator(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_PROVISIONING_MODEL),
                TestDataReader.getTestData(TESTDATA_SERIES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_ADD_GPU),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION_),
                TestDataReader.getTestData(TESTDATA_COMMITED_USAGE)
                );
    }
}
