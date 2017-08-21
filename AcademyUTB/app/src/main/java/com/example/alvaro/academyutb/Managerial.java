package com.example.alvaro.academyutb;

/**
 * Created by Alvaro on 17/08/2017.
 */

public class Managerial extends MainActivity implements Academia {

    private String name;
    private String role;

    public Managerial(){}

    public Managerial (String nombre, String rol){
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
        return "Managerial{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public String assistance(){
        return "A Managerial has attended the event";
    }
}
