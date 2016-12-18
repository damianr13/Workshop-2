package com.workshop.best.colinde;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
            implements AdapterView.OnItemClickListener{

    private HashMap<String, String> mapColinde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.listview);
        myListView.setOnItemClickListener(this);

        List<String> listaColinde = new ArrayList<>();
        listaColinde.add("Impodobeste mama bradul!");
        listaColinde.add("O ce veste minunata!");
        listaColinde.add("Leru-i ler");
        listaColinde.add("Deck the halls");
        listaColinde.add("Jingle bells");

        mapColinde = new HashMap<>();
        mapColinde.put("Deck the halls", "https://www.youtube.com/watch?v=SIFqnEoctI4");
        mapColinde.put("O ce veste minunata", "https://www.youtube.com/watch?v=jWZX-yZD0DE");
        mapColinde.put("Leru-i ler", "https://www.youtube.com/watch?v=iC07sznz1ZM");
        mapColinde.put("Impodobeste mama bradul", "https://www.youtube.com/watch?v=ALoPRQFHaM4");
        mapColinde.put("Jingle bells", "https://www.youtube.com/watch?v=3PgNPc-iFW8");


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(
                this, R.layout.list_item,
                new ArrayList<String>(mapColinde.keySet()));

        myListView.setAdapter(itemsAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView clickedTextView = (TextView) view;

        startActivity(new Intent(Intent.ACTION_VIEW,
            Uri.parse(mapColinde.get(clickedTextView.getText()))));
    }
}
