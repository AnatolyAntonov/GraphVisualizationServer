package com.example.GraphVisualizationServer.algorithm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class State {
    private int length;
    private int from;
    private boolean isFinal;

    @Override
    public String toString() {
        return "(" + length + ", " + from + ", " + isFinal + ")";
    }
}
