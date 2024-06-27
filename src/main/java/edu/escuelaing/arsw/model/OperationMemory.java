package edu.escuelaing.arsw.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class OperationMemory {
    private double value = 0;

    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        this.value = newValue;
    }

    public void clear() {
        this.value = 0;
    }
}