package com.example.alvaro.academy;

import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.id.edit;
import static com.example.alvaro.academy.R.id.textView;
import static com.example.alvaro.academy.R.id.textView2;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    private EditText edit;
    TextView nombre;
    ListView Usuarios;
    ArrayList<String> Nombres;
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre=(TextView) findViewById(R.id.name);
        Usuarios= (ListView) findViewById(R.id.Users);
        Nombres=new ArrayList<String>();
        ArrayAdapter<String> Adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Nombres);
        Usuarios.setAdapter(Adapter);
        Button boton = (Button) findViewById(R.id.Tchr);
        boton.setOnClickListener(this);
        TextView nombre = (TextView) findViewById(R.id.name);
        Button boton2 = (Button) findViewById(R.id.Stdnt);
        boton2.setOnClickListener(this);
        Button boton3 = (Button) findViewById(R.id.Mngrl);
        boton3.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    }


    public void onClick(View v) {

        String Tipo=null;
        boolean validation = false;
        if (v.getId() == R.id.Stdnt) {
            String name =  nombre.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="student";
                validation = true;
            }

        }
        if (v.getId() == R.id.Mngrl) {
            String name =  nombre.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="managerial";
                validation = true;
            }

        }
        if (v.getId() == R.id.Tchr) {
            String name =  nombre.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getBaseContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();
            }
            else {
                Tipo="teacher";
                validation = true;
            }

        }
        if (validation == true){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("Add New Item");
            builder1.setMessage("Are you sure to add a new "+Tipo+" with name "+nombre.getText()+"?");
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "Add",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            edit = (EditText)findViewById(R.id.name);
                            String text= edit.getText().toString();
                            if(text != null && !text.isEmpty()){
                                AcademyFactory new_item = new AcademyFactory();
                                Academia academia = AcademyFactory.getAcademia("Recibiendo clases");
                                textView.setText(new StringBuilder().append(academia.asistencia()).toString());
                                dialog.cancel();
                        }
                    });



    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
