package com.epam.training.ekaterina_sycheva.hardcore.model;

public class ComputeEngineCalculator {

    private String numberOfInstances;
    private String operatingSystemType;
    private String provisioningModel;
    private String series;
    private String machineType;
    private String gpu;
    private String gpuType;
    private String numberOfGpu;
    private String localSSD;
    private String datacenterLocation;
    private String commitedUsage;

    public ComputeEngineCalculator(String numberOfInstances,
                                   String operatingSystemType,
                                   String provisioningModel,
                                   String series,
                                   String machineType,
                                   String gpu,
                                   String gpuType,
                                   String numberOfGpu,
                                   String localSSD,
                                   String datacenterLocation,
                                   String commitedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemType = operatingSystemType;
        this.provisioningModel = provisioningModel;
        this.series = series;
        this.machineType = machineType;
        this.gpu = gpu;
        if (gpu == null) {
            this.gpuType = gpuType;
            this.numberOfGpu = numberOfGpu;
        }
        else {
            this.gpuType = null;
            this.numberOfGpu = null;
        }
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystemType() {
        return operatingSystemType;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpu() {
        return gpu;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    @Override
    public String toString() {
        String gpuInformation = "";
        if (this.gpu != null) {
            gpuInformation = "gpuType: " + this.gpuType +  "\n" +
                             "numberOfGpu: " + this.numberOfGpu + "\n";
        }
        return "ComputeEngineCalculator {\n" +
                "numberOfInstances: " + this.numberOfInstances + "\n" +
                "operatingSystemType:" + this.operatingSystemType + "\n" +
                "provisioningModel:" + this.provisioningModel + "\n" +
                "series:" + this.series + "\n" +
                "machineType: " + this.machineType + "\n" +
                "gpu: " + this.gpu + "\n" +
                gpuInformation + "\n" +
                "localSSD: " + this.localSSD + "\n" +
                "datacenterLocation:" + this.datacenterLocation + "\n" +
                "commitedUsage: " + this.commitedUsage + "\n" +
                "}";
    }
}
