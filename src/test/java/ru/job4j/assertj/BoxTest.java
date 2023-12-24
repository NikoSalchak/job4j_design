package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .endsWith("re");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .contains("Cub")
                .startsWithIgnoringCase("c");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .contains("hedron")
                .startsWithIgnoringCase("tet");
    }

    @Test
    void numberOfVerticesTetrahedron() {
        Box box = new Box(4, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4)
                .isLessThan(5)
                .isGreaterThan(3);
    }

    @Test
    void numberOfVerticesCube() {
        Box box = new Box(8, 12);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8)
                .isLessThan(9)
                .isGreaterThan(7);
    }

    @Test
    void isSphereExist() {
        Box box = new Box(0, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true)
                .isNotEqualTo(false);
    }

    @Test
    void isUnknownObject() {
        Box box = new Box(5, 8);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isNotEqualTo(true)
                .isEqualTo(false);
    }

    @Test
    void getSphereArea() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(1256.63, withPrecision(0.01D))
                .isGreaterThan(1256.50D);
    }

    @Test
    void getTetrahedronArea() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isEqualTo(62.35, withPrecision(0.01))
                .isGreaterThan(62.0D)
                .isLessThan(62.36);
    }
}