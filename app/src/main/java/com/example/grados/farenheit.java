package com.example.grados;

public class farenheit {

    public static int toCelsius(int fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static int toKelvin(int fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273;
    }

}
