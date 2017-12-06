package ch.ralena.sampleapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ch.ralena.sampleapplication.R;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {
	List<String> strings;

	public StringAdapter(List<String> strings) {
		this.strings = strings;
	}

	@Override
	public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string, parent, false);
		return new StringViewHolder(view);
	}

	@Override
	public void onBindViewHolder(StringViewHolder holder, int position) {
		holder.bindView(strings.get(position));
	}

	@Override
	public int getItemCount() {
		return strings.size();
	}

	class StringViewHolder extends RecyclerView.ViewHolder {
		TextView itemName;

		public StringViewHolder(View itemView) {
			super(itemView);
			itemName = itemView.findViewById(R.id.itemName);

		}

		public void bindView(String s) {
			itemName.setText(s);
		}
	}
}
