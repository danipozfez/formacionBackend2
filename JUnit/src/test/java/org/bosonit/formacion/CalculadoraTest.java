package org.bosonit.formacion;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
class CalculadoraTest {

    @Test
    void suma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertThat(resultado, is(126));
    }

    @Test
    void resta() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.resta(10,5);
        assertThat(resultado,is(5));
    }

    @Test
    void division() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(10.0,5.0);
        assertThat(resultado,is(2.0));
    }

    @Test
    void multiplicacion() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(10,5);
        assertThat(resultado,is(50));
    }

    @Test
    void suma1() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertEquals(126, resultado);
    }

    @Test
    void resta2() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.resta(10,5);
        assertEquals(5, resultado);
    }

    @Test
    void division2() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(10.0,5.0);
        assertEquals(2.0, resultado);
    }

    @Test
    void multiplicacion2() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(10,5);
        assertEquals(50, resultado);
    }

}