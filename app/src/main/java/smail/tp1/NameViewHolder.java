package smail.tp1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NameViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.item_name_textview_name);
    }

    public void setContent(String name)
    {
        textView.setText(name);
    }
}
