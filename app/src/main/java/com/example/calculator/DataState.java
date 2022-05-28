package com.example.calculator;

public class DataState {

    private String currentDataState;
    private String previousDataState;
    public DataState()
    {
        currentDataState = "decimal";
        previousDataState= "decimal";
    }

    public DataState(String currentDataState, String previousDataState)
    {
        this.currentDataState = currentDataState;
        this.previousDataState = previousDataState;
    }

    public String getCurrentDataState() {
        return currentDataState;
    }

    public void setCurrentDataState(String currentDataState) {
        this.currentDataState = currentDataState;
    }

    public String getPreviousDataState() {
        return previousDataState;
    }

    public void setPreviousDataState(String previousDataState) {
        this.previousDataState = previousDataState;
    }
}