package smail.tp1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int FORM_REQUEST = 1;

    //private TextView textViewName;
    private RecyclerView recyclerView;
    private Button buttonNext;
    private NameListAdapter nameListAdapter;

    private void initViews()
    {
        //textViewName = findViewById(/*ressource.id...*/ R.id.activity_main_text);
        recyclerView = findViewById(R.id.activity_main_recyclerview);
        buttonNext = findViewById(R.id.activity_main_button_next);

        //textViewName.setText(R.string.activity_main_button_next);

        // Handle buttonNext's onClick  event
        buttonNext.setOnClickListener(this);
    }

    private void initList()
    {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nameListAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameListAdapter = new NameListAdapter();
        initViews();
        initList();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //textViewName.setText(DataManager.getDataManager().getName());
        nameListAdapter.updateData(DataManager.getDataManager().getNameList());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.activity_main_button_next: /*  only 1 fct call*/
               // startActivityForResult(new Intent(this, FormActivity.class), FORM_REQUEST);
                startActivity(new Intent(this, FormActivity.class));
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
        {
            // a faire avec object serializable ou parcelable
            //voir patern mvvm
            // utiliser modele mvp (modele vue presenteur
            if(resultCode == RESULT_OK && data.getExtras() != null){
                Bundle args = data.getExtras();
                String username = args.getString(FormActivity.TEXT_RESULT);
                //textViewName.setText(username);
            }
            else
            {// handle error

            }
        }
    }
}
