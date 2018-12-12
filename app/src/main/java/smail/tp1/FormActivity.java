package smail.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    static final String TEXT_RESULT = "username";
    private EditText editTextName;
    private Button buttonBack;


    private void initViews()
    {
        editTextName = findViewById(R.id.activity_form_editText);
        buttonBack = findViewById(R.id.activity_form_button_back);
        buttonBack.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_form_button_back :
                saveData();
                //startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void saveData()
    {
        // Solution sans DataManager
        /*
        Intent intent = new Intent();
        intent.putExtra(TEXT_RESULT, editTextName.getText().toString());

        setResult(RESULT_OK, intent);
        */

        // Solution avec DataManager
        String name = editTextName.getText().toString();
        if(!name.isEmpty())
            DataManager.getDataManager().addName(name);
        finish();
    }
}
