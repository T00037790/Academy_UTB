package com.example.alvaro.academyutb;

import android.content.DialogInterface;
import android.provider.Contacts;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> People;
    ArrayList<String> Roles;
    EditText texto;
    ListView name_list;
    ListView role_list;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_student = (Button) findViewById(R.id.Student);
        button_student.setOnClickListener(this);
        Button button_teacher = (Button) findViewById(R.id.Teacher);
        button_teacher.setOnClickListener(this);
        Button button_managerial = (Button) findViewById(R.id.Managerial);
        button_managerial.setOnClickListener(this);
        name_list= (ListView) findViewById(R.id.name_view);
        role_list= (ListView) findViewById(R.id.role_view);
        People=new ArrayList<String>();
        Roles=new ArrayList<String>();
        texto =(EditText) findViewById(R.id.editText2);
        ArrayAdapter<String> Adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,People);
        ArrayAdapter<String> Adapter2= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Roles);
        name_list.setAdapter(Adapter);
        role_list.setAdapter(Adapter2);
    }

    @Override
    public void onClick(View v) {
        String Tipo=null;
        boolean validation = false;
        if (v.getId() == R.id.Student) {
            String name =  texto.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="Student";
                validation = true;
            }

        }
        if (v.getId() == R.id.Teacher) {
            String name =  texto.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="Teacher";
                validation = true;
            }

        }
        if (v.getId() == R.id.Managerial) {
            String name =  texto.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="Managerial";
                validation = true;
            }

        }

        if (validation == true){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("Add New Item");
            builder1.setMessage("Are you sure to add a new "+Tipo+" with name "+texto.getText()+"?");
            builder1.setCancelable(true);
            type = Tipo;
            builder1.setPositiveButton(
                    "Add",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            texto.getText().toString();
                            People.add(texto.getText().toString());
                            Roles.add(type);
                            Academia item = AcademyFactory.getAcademia(type);
                            String message = item.assistance();
                            Toast.makeText(getBaseContext(), message , Toast.LENGTH_LONG).show();
                            Assitance tmp = Assitance.getInstance( );
                            int cont = Assitance.getContadorPersonas();
                            texto.setText("");
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();

        }







    }
}