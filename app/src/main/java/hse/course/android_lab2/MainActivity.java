package hse.course.android_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.main_activity_layout);

        RecyclerView recyclerView = findViewById(R.id.productList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        productAdapter = new ProductAdapter(new ArrayList<>());
        recyclerView.setAdapter(productAdapter);

        super.onCreate(savedInstanceState);
    }

    public void add(View view) {
        EditText productNameEditText = findViewById(R.id.productName);
        String productName = productNameEditText.getText().toString();
        productNameEditText.setText("");


        productAdapter.add(productName);
    }

    public void clear(View view) {
        productAdapter.clearAll();
    }
}
