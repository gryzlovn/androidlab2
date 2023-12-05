package hse.course.android_lab2;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private final List<String> products;
    public ProductAdapter(List<String> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int ViewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.getProduct().setText(products.get(position));
        holder.getRemoveButton().setOnClickListener(v -> clearone(position));
        Context context = holder.itemView.getContext();
        String pr=products.get(position);
        holder.getChangeButton().setOnClickListener(v -> change(position, context,pr));
    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void add(String productName) {
        products.add(productName);
        notifyDataSetChanged();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void change(int i,Context context,String productName) {
        final String[] d ={""};
        d[0]=productName;
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        // Создание и отображение диалогового окна с возможностью ввода
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Введите новое название товара");
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userInput = input.getText().toString();
                d[0] =userInput;
                products.set(i, d[0]);
                notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();


    }
    @SuppressLint("NotifyDataSetChanged")
    public void clearone(int position) {

        products.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearAll() {
        products.clear();
        notifyDataSetChanged();
    }

}
