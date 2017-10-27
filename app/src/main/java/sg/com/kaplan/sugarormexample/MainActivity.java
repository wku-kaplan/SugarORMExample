package sg.com.kaplan.sugarormexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextItem = (EditText) findViewById(R.id.editTextItem);
        final EditText editTextCost = (EditText) findViewById(R.id.editTextCost);
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextItem.getText().length() == 0 || editTextCost.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please input some values", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create
                String item = editTextItem.getText().toString();
                float cost = Float.parseFloat(editTextCost.getText().toString());
                Expense expense = new Expense(item, cost, new Date());
                expense.save();

                editTextItem.setText("");
                editTextCost.setText("");
                Toast.makeText(MainActivity.this, "item added", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView textViewList = (TextView) findViewById(R.id.textViewList);
        Button buttonRefresh = (Button) findViewById(R.id.buttonRefresh);
        buttonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Expense> list = Expense.listAll(Expense.class);
                if(list.size() > 0) {
                    StringBuffer sb = new StringBuffer();
                    for (Expense ex : list) {
                        sb.append(ex.getId() + ".\t" + ex.getItem() + "\t$" + ex.getCost() + "\n");
                    }
                    textViewList.setText(sb.toString());
                } else {
                    textViewList.setText("Nothing yet. Try adding an item");
                }
            }
        });
    }
}
