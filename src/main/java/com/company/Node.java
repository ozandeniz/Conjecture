package com.company;

import java.util.HashMap;

public class Node {

    private double value;
    private double previousValue;
    private int level;
    private int operation;

    public HashMap<Integer, Node> childs = new HashMap<>();

    public double getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(double previousValue) {
        this.previousValue = previousValue;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Node(double value, int operation){
        this.value = value;
        this.operation = operation;
        this.level = 0;
        this.previousValue = 0;
    }
}
