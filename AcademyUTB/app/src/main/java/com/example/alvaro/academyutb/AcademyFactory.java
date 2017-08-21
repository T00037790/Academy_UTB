package com.example.alvaro.academyutb;

/**
 * Created by Alvaro on 17/08/2017.
 */

public class AcademyFactory {
    public static Academia getAcademia(String role)
    {
        switch (role) {
            case "Student":
                return new Student();
            case "Teacher":
                return new Teacher();
            case "Managerial":
                return new Managerial();
            default:
                break;
        }

        return null;
    }
}
