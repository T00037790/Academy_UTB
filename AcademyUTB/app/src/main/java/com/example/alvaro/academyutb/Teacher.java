package com.example.alvaro.academyutb;

/**
 * Created by Alvaro on 17/08/2017.
 */

public class Teacher extends MainActivity implements Academia {

    private String name;
    private String role;

    public Teacher(){}

    public Teacher (String nombre, String rol){
        this.name = nombre;
        this.role = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public String assistance()
    {
        return "A teacher has attended the event";
    }
}
