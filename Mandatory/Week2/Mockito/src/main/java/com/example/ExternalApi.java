package com.example;

public interface ExternalApi {
    String getData();

    String getData(String parameter);

    void saveData(String data);
}
// This interface represents an external API that can be mocked in tests.