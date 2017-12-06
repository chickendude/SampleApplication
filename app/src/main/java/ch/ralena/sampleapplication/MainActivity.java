package ch.ralena.sampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import ch.ralena.sampleapplication.adapters.StringAdapter;

public class MainActivity extends AppCompatActivity {
	List<String> items;
	StringAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		items = new ArrayList<>();

		EditText editText = findViewById(R.id.editText);
		Button button = findViewById(R.id.submitButton);
		button.setOnClickListener(v -> {
			items.add(editText.getText().toString());
			editText.setText("");
			adapter.notifyItemInserted(items.size()-1);
		});
		// recycler view
		RecyclerView recyclerView = findViewById(R.id.recyclerView);
		adapter = new StringAdapter(items);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
