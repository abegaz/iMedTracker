package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyMedController extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_med_view);
        setTitle("My Medications");

        final ArrayList<String> medName = new ArrayList<>();
        final ArrayList<Integer> doseCount = new ArrayList<>();
        final ArrayList<Integer> doseFrequency = new ArrayList<>();
        DatabaseHelper dbMed = new DatabaseHelper(this);
        final List<MedModel> medList = dbMed.getAllMeds();
        for(MedModel med1:  medList)
        {
            medName.add(med1.getMedName());
            doseCount.add(med1.getDoseCount());
            doseFrequency.add(med1.getDoseCount());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, medName);
        ListView listView = (ListView) findViewById(R.id.myMedListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MyMedController.this, medName.toString(),  Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MyMedController.this, MedDetailController.class);
                String tokenMedName = medName.get(position).toString();
                String tokenDoseCount = doseCount.get(position).toString();
                String tokenDoseFrequency = doseFrequency.get(position).toString();
                intent.putExtra("medName", tokenMedName);
                intent.putExtra("doseCount", tokenDoseCount);
                intent.putExtra("doseFrequency", tokenDoseFrequency);
                startActivity(intent);
            }
        });
    }
}
