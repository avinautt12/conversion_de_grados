package com.example.grados;

public class kelvin {

    public static int toCelsius(int kelvin) {
        return kelvin - 273;
    }

    public static int toFahrenheit(int kelvin) {
        return (kelvin - 273) * 9/5 + 32;
    }

}
