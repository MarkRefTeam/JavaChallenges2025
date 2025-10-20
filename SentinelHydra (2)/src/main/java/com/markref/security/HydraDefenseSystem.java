package com.markref.security;

import java.util.ArrayList;
import java.util.List;

public class HydraDefenseSystem {

    private List<HydraNode> nodes = new ArrayList<>();
    private int generation = 0;

    public HydraDefenseSystem() {
        spawnNewNode(); // initial head
    }

    public void detectAttack(String threatLevel) {
        System.out.println("Threat detected: " + threatLevel);
        String level = threatLevel.toLowerCase();
        if (level.equals("high")) {
            growHeads(2);
        } else if (level.equals("medium")) {
            growHeads(1);
        } else {
            System.out.println("Minor threat - monitoring...");
        }
    }

    void growHeads(int count) { //I left "private" for testGrowHeads!
        for (int i = 0; i < count; i++) {
            spawnNewNode();
        }
    }

    public int getNodeCount() {
        return nodes.size();
    }

    private void spawnNewNode() {
        generation++;
        HydraNode node = new HydraNode("Node-" + generation);
        nodes.add(node);
        System.out.println("New Hydra node spawned: " + node.getName());
    }

    public void report() {
        System.out.println("Total active nodes: " + nodes.size());
        for (HydraNode node : nodes) {
            System.out.println(" - " + node.getName());
        }
    }

    private static class HydraNode {
        private final String name;

        public HydraNode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
