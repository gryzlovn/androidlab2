package hse.course.android_lab2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView product;

    private final Button removeButton;
    private final Button changeButton;
    public ItemViewHolder(View view) {
        super(view);
        product = view.findViewById(R.id.product);
        removeButton = view.findViewById(R.id.removeButton);
        changeButton = view.findViewById(R.id.changeButton);
    }

    public TextView getProduct() {
        return product;
    }

    public Button getRemoveButton() {
        return removeButton;
    }
    public Button getChangeButton() {
        return changeButton;
    }
}