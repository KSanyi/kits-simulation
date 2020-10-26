package kits.simulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import kits.simulation.util.BaseStats;

public class BaseStatsTest {

    private final double DELTA = 0.001;
    
    @Test
    void oneElement() {
        
        BaseStats baseStats = BaseStats.calculate(Arrays.asList(2.0));
        
        assertDoubleEquals(2.0, baseStats.min());
        assertDoubleEquals(2.0, baseStats.max());
        assertDoubleEquals(2.0, baseStats.avg());
        assertDoubleEquals(0.0, baseStats.stDev());
        assertEquals(1, baseStats.count());
    }
    
    @Test
    void moreElement() {
        
        BaseStats baseStats = BaseStats.calculate(Arrays.asList(2.0, 3.0, 10.0));
        
        assertDoubleEquals(2.0, baseStats.min());
        assertDoubleEquals(10.0, baseStats.max());
        assertDoubleEquals(5.0, baseStats.avg());
        assertDoubleEquals(3.559, baseStats.stDev());
        assertEquals(3, baseStats.count());
    }
    
    private void assertDoubleEquals(double expected, double actual) {
        assertEquals(expected, actual, DELTA);
    }
    
}
