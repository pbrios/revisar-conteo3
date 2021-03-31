package com.example.inventarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.inventarios.Objetos.Persona;
import com.example.inventarios.Recursos.VolleySingleton;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtUsuario, edtPassword;
    private Persona[] persona;
    private Gson gson = new Gson();
    private String servidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializa();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin.setEnabled(false);
                validaUsuario(servidor+"loginApps.php");
            }
        });

        edtPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    if(i == KeyEvent.KEYCODE_ENTER){
                        btnLogin.setEnabled(false);
                        validaUsuario(servidor+"loginApps.php");
                    }
                }
                return false;
            }
        });
    }

    private void inicializa(){
        btnLogin = findViewById(R.id.btnLogin);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        servidor = getString(R.string.servername);
    }

    private void validaUsuario(String url){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    persona = gson.fromJson(response, Persona[].class);
                    Intent intent = new Intent(getApplicationContext(), ListaConteo.class);
                    intent.putExtra("usuario",persona);
                    startActivity(intent);
                    btnLogin.setEnabled(true);
                }else{
                    Toast.makeText(getApplicationContext(), "Error en Usuario o Contraseña", Toast.LENGTH_LONG).show();
                    btnLogin.setEnabled(true);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                btnLogin.setEnabled(true);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario", edtUsuario.getText().toString()+"@gdo.com");
                parametros.put("password", edtPassword.getText().toString());
                return parametros;
            }
        };
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}