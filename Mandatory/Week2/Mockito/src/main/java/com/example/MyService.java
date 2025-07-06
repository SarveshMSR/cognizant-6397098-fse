package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataWithParameter(String param) {
        return externalApi.getData(param);
    }

    public void processAndSaveData(String input) {
        String processedData = "Processed: " + input;
        externalApi.saveData(processedData);
    }
}
// This class uses an ExternalApi to fetch and process data.
// It can be tested using Mockito to mock the ExternalApi interactions.
// The methods can be verified for correct interactions with the mock.