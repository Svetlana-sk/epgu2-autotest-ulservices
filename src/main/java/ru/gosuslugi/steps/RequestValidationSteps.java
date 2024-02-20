package ru.gosuslugi.steps;

public interface RequestValidationSteps {

    String getSmev3BusinessRequestAsString(long orderId, String schemaFile);

}