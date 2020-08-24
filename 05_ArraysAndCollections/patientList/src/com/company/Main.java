package com.company;

import java.text.DecimalFormat;
import java.text.Format;

public class Main {
    private static final int PATIENT_COUNT = 30;

    public static void main(String[] args) {

        float temperatureList[] = new float[PATIENT_COUNT];
        float temperature;
        String stringTemperature;
        float middleTemperature = 0.0f;
        int healthyPatient = 0;
        System.out.print("Температуры пациентов: ");
        for (int i = 0; i < temperatureList.length; i++) {
            temperature = (float) (32 + 8 * Math.random());
            stringTemperature = Float.toString(temperature);
            temperatureList[i] = Float.parseFloat(stringTemperature.substring(0,4));
            System.out.print(temperatureList[i] + " ");
            middleTemperature = middleTemperature + temperatureList[i];
            if (temperatureList[i] > 36.2f && temperatureList[i] < 36.9f) healthyPatient++;

        }
        middleTemperature = middleTemperature / PATIENT_COUNT;
        stringTemperature = Float.toString(middleTemperature);
        System.out.println("\n" +"Средняя температура пациентов равна: " + stringTemperature.substring(0, 4));
        System.out.println("Здоровых пациентов: " + healthyPatient);

    }
}
