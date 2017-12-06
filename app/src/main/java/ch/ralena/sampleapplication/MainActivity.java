package ch.ralena.sampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
			String itemName = editText.getText().toString();
			if (!itemName.isEmpty()) {
				items.add(editText.getText().toString());
				editText.setText("");
				adapter.notifyItemInserted(items.size() - 1);
			} else {
				Toast.makeText(this, "Item name must not be empty!", Toast.LENGTH_SHORT).show();
			}
		});
		// recycler view
		RecyclerView recyclerView = findViewById(R.id.recyclerView);
		adapter = new StringAdapter(items);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
}
