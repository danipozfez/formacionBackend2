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
        int resultado = calculadora.resta(10, 5);
        assertThat(resultado, is(5));
    }

    @Test
    void division() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(10.0, 5.0);
        assertThat(resultado, is(2.0));
    }

    @Test
    void multiplicacion() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(10, 5);
        assertThat(resultado, is(50));
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
        int resultado = calculadora.resta(10, 5);
        assertEquals(5, resultado);
    }

    @Test
    void division2() {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.division(10.0, 5.0);
        assertEquals(2.0, resultado);
    }

    @Test
    void multiplicacion2() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicacion(10, 5);
        assertEquals(50, resultado);
    }

    //BASE

    @Test
    public void ejemploIsEqual() {

        assertThat("cadena", is("cadena"));
        assertThat("cadena", equalTo("cadena"));
//	assertThat("cadena", equalToIgnoringCase("CAdeNa"));
//  assertThat("cadena", equalToIgnoringWhiteSpace("    cadena  "));
        assertThat("cadena", is(equalTo("cadena")));

    }

    @Test
    public void ejemploNot() {

        assertThat("cadena", is(not("bar")));// Pasa

    }


    //OBJETOS

    @Test
    public void ejemploEqualTo() {

        // Pasa porque ambos arrays tienen la misma longitud y los objetos en las mismas posiciones
        assertThat(new String[]{"foo", "bar"}, is(equalTo(new String[]{"foo", "bar"})));
        // Falla porque en el matcher el array primero tiene el String bar y luego el foo
        assertThat(new String[]{"foo", "bar"}, is(equalTo(new String[]{"foo", "bar"})));
        // Pasa porque estamos negando la anterior
        assertThat(new String[]{"bar", "foo"}, is(not(equalTo(new String[]{"foo", "bar"}))));

    }

    @Test
    public void ejemploSameInstance() {

        String cadena = "cadena";
        String sameCadena = cadena;
        assertThat(cadena, is(sameInstance(sameCadena)));// Pasa

    }

    @Test
    public void ejemploInstanceOf() {

        assertThat("foo", is(not(instanceOf(Integer.class))));// Pasa porque no es instancia de Integer
        assertThat("foo", is(instanceOf(String.class))); // Pasa porque es instancia de String
        assertThat("foo", isA(String.class)); // Es abreviatura del caso anterior por lo que también pasa

    }

    @Test
    public void ejemploAny() {

        //assertThat("foo", is(not(any(Integer.class)))); No funciona porque "foo" es String no Integer
        assertThat("foo", is(any(String.class)));

    }


    //STRINGS

    @Test
    public void ejemploStartsWith() {

        assertThat("cadena bar restaurante", startsWith("cadena"));// Pasa porque empieza por "cadena"

    }

    @Test
    public void ejemploEndsWith() {

        assertThat("Helicoptero", startsWithIgnoringCase("HEL"));// Pasa porque el string "Helicoptero" empieza en "HE" pero: "He"

    }

    @Test
    public void ejemploEndsWith2() {

        assertThat("cadena bar restaurante", endsWith("te"));// Pasa


    }


}