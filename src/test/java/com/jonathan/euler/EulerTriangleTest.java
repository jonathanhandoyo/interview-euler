package com.jonathan.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EulerTriangleTest {

    @Test
    public void solve() {
        EulerTriangle euler = new EulerTriangle();
        assertEquals(1074, euler.solve("1074.txt"));
        assertEquals(1320, euler.solve("1320.txt"));
        assertEquals(7273, euler.solve("7273.txt"));
    }

}