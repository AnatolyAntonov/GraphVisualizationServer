package com.example.GraphVisualizationServer;

import com.example.GraphVisualizationServer.algorithm.Graph;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/graph")
public class GraphController {
    private Graph graph;

    @PostMapping("/create")
    public void createGraph(@RequestBody CreateGraph createGraph) {
        graph = new Graph(createGraph.graphArray);
    }

    @GetMapping(value = "/path")
    public String getPath(@RequestParam int from, @RequestParam int to) {
        return graph.getPath(from, to);
    }

    @Data
    public static class CreateGraph {
        private int[][] graphArray;
    }
}
