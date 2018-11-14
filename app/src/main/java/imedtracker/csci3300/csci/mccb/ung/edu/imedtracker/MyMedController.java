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
        setTitle("My Medication");

        final ArrayList<String> pillName = new ArrayList<>();
        final ArrayList<Integer> doseCount = new ArrayList<>();
        final ArrayList<Integer> doseFrequency = new ArrayList<>();
        DatabaseHelper dbPill = new DatabaseHelper(this);
        final List<PillModel> pillList = dbPill.getAllPills();
        for(PillModel pill1:  pillList)
        {
            pillName.add(pill1.getPillName());
            doseCount.add(pill1.getDoseCount());
            doseFrequency.add(pill1.getDoseFrequency());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, pillName);
        ListView listView = (ListView) findViewById(R.id.myMedListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MyMedController.this, MedDetailController.class);
                String tokenPillName = pillName.get(position).toString();
                String tokenDoseCount = doseCount.get(position).toString();
                String tokenDoseFrequency = doseFrequency.get(position).toString();
                intent.putExtra("pillName", tokenPillName);
                intent.putExtra("doseCount", tokenDoseCount);
                intent.putExtra("doseFrequency", tokenDoseFrequency);
                startActivity(intent);
            }
        });
    }
}
