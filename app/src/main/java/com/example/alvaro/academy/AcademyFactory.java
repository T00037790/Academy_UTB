package com.example.alvaro.academy;

/**
 * Created by Alvaro on 17/08/2017.
 */

public class AcademyFactory {
    public static Academia getAcademia(String criteria)
    {
        switch (criteria) {
            case "Recibiendo clases":
                return new Student();
            case "Dando clases":
                return new Teacher();
            case "Laborando":
                return new Managerial();
            default:
                break;
        }

        return null;
    }
}
