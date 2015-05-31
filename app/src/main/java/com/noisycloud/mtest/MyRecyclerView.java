package com.noisycloud.mtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

	private final TypedValue mTypedValue = new TypedValue();
	private List<String> mValues;

	public MyRecyclerView(Context context, List<String> items) {
		context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
		mValues = items;
	}

	public String getValueAt(int position) {
		return mValues.get(position);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_muppet, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		holder.mBoundString = mValues.get(position);
		holder.mTextView.setText(mValues.get(position));

		holder.mView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Context context = v.getContext();
				Intent intent = new Intent(context, MuppetDetail.class);
				intent.putExtra(MuppetDetail.EXTRA_MUPPET_NAME, holder.mBoundString);

				context.startActivity(intent);
			}
		});
	}

	@Override
	public int getItemCount() {
		return mValues.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public String mBoundString;

		public final View mView;
		public final TextView mTextView;

		public ViewHolder(View view) {
			super(view);
			mView = view;
			mTextView = (TextView) view.findViewById(R.id.item_muppet_name);
		}

		@Override
		public String toString() {
			return super.toString() + " '" + mTextView.getText();
		}
	}
}
