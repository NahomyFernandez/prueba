package com.example.prueba;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.prueba.WebServices.Asynchtask;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class consulta_chofer extends AppCompatActivity implements Asynchtask
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_chofer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Map<String, String> datos = new HashMap<String, String>();
        com.example.listview_is_2024.WebService.WebService ws= new com.example.listview_is_2024.WebService.WebService(
                "https://uteqia.com/api/choferes" ,
                datos, consulta_chofer.this, consulta_chofer.this);
        ws.execute("GET");
    }



    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtRes = findViewById(R.id.txtRes);
        txtRes.setText("Resp: " + result );

    }
}