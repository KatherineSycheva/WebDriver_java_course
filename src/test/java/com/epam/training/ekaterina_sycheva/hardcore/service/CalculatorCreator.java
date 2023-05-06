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
        TestDataReader testDataReader = new TestDataReader();
        return new ComputeEngineCalculator(testDataReader.readProperty(TESTDATA_NUMBER_OF_INSTANCES),
                testDataReader.readProperty(TESTDATA_OPERATING_SYSTEM),
                testDataReader.readProperty(TESTDATA_PROVISIONING_MODEL),
                testDataReader.readProperty(TESTDATA_SERIES),
                testDataReader.readProperty(TESTDATA_MACHINE_TYPE),
                testDataReader.readProperty(TESTDATA_ADD_GPU),
                testDataReader.readProperty(TESTDATA_GPU_TYPE),
                testDataReader.readProperty(TESTDATA_NUMBER_OF_GPUS),
                testDataReader.readProperty(TESTDATA_LOCAL_SSD),
                testDataReader.readProperty(TESTDATA_DATACENTER_LOCATION_),
                testDataReader.readProperty(TESTDATA_COMMITED_USAGE)
                );
    }
}
