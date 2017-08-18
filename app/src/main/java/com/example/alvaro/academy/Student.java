package com.example.alvaro.academy;

/**
 * Created by Alvaro on 17/08/2017.
 */

public class Student extends MainActivity implements Academia {
    @Override
    public void asistencia()
    {
        System.out.println("Asistió");
    }
}
