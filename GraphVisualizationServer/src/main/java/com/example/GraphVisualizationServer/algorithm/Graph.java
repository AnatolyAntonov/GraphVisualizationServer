package com.example.GraphVisualizationServer.algorithm;

public class Graph {
    private final int[][] graphArray;
    private State[] path;

    public Graph(int[][] graphArray) {
        this.graphArray = graphArray;
        this.path = new State[graphArray.length];
    }

    public String getPath(int from, int to) {
        foundPath(0, 7);
        StringBuilder pathStr = new StringBuilder();
        int currentFrom = to;
        while (currentFrom != from){
            pathStr.append(currentFrom).append(" ");
            currentFrom = path[currentFrom].getFrom();
        }
        return pathStr.toString();
    }

    public State[] foundPath(int from, int to) {
        path[0] = new State(0, from, true);
        for (int i = 1; i < path.length; i++) {
            path[i] = new State(-1, 0, false);
        }
        while (from != to) {
            for (int i = 0; i < graphArray.length; i++) {
                if (graphArray[from][i] > 0 && !path[i].isFinal()) {
                    if (path[i].getLength() < 0) {
                        path[i] = new State(graphArray[from][i] + path[from].getLength(), from, false);
                    } else {
                        if (path[i].getLength() < graphArray[from][i] + path[from].getLength()) {
                            path[i] = new State(path[i].getLength(), path[i].getFrom(), false);
                        } else {
                            path[i] = new State(graphArray[from][i] + path[from].getLength(), from, false);
                        }
                    }
                }
            }
            int min = 0;
            int indexMin = 0;
            for (int i = 0; i < path.length; i++) {
                if (!path[i].isFinal() && path[i].getLength() > 0) {
                    if (min == 0 || min > path[i].getLength()) {
                        min = path[i].getLength();
                        indexMin = i;
                    }
                }
            }
            path[indexMin].setFinal(true);
            from = indexMin;
        }
        return path;
    }


}
