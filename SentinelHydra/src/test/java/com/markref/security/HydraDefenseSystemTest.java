package com.markref.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydraDefenseSystemTest {

    private HydraDefenseSystem hydraDefenseSystem;

    @BeforeEach
    void setup() {
        hydraDefenseSystem = new HydraDefenseSystem();
    }

    @Test
    void testInitialNodeCount() {
        assertEquals(1, hydraDefenseSystem.getNodeCount());
    }

    @Test
    void testDetectAttackHighThreat() {
        hydraDefenseSystem.detectAttack("High");
        assertEquals(3, hydraDefenseSystem.getNodeCount());
    }

    @Test
    void testDetectAttackMediumThreat() {
        hydraDefenseSystem.detectAttack("Medium");
        assertEquals(2, hydraDefenseSystem.getNodeCount());
    }

    @Test
    void testDetectAttackLowThreat() {
        hydraDefenseSystem.detectAttack("Low");
        assertEquals(1, hydraDefenseSystem.getNodeCount());
    }

    @Test
    void testGrowHeads() {
        hydraDefenseSystem.growHeads(5);
        assertEquals(6, hydraDefenseSystem.getNodeCount());
    }
}