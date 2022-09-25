package jobsheet2.polinema.ac.id.a04androidrecyclerviewrara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Word> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData(Data.data());

        RecyclerView word_recyclerView = findViewById(R.id.recycler_view);
        WordAdapter adapter = new WordAdapter(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        word_recyclerView.setLayoutManager(layoutManager);
        word_recyclerView.setAdapter(adapter);
    }

    public void setData(String data){
        try {
            JSONArray jsonArray = new JSONArray(data);
            dataList = new ArrayList<>();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Word word = new Word(jsonObject.getString("word"),
                        jsonObject.getString("no"));
                dataList.add(word);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}