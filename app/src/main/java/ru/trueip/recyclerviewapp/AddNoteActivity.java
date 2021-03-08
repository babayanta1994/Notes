package ru.trueip.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText titleEt;
    EditText descriptionEt;
    Spinner daysOfWeakS;
    RadioGroup priorityRg;

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        titleEt = findViewById(R.id.title);
        descriptionEt = findViewById(R.id.description);
        daysOfWeakS = findViewById(R.id.spinnerDaysOfWeak);
        priorityRg = findViewById(R.id.radioGroupPriority);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    public void addNewNote(View view) {
        String title = titleEt.getText().toString();
        String description = descriptionEt.getText().toString();
        String daysOfWeak = ""+daysOfWeakS.getSelectedItemPosition();
        RadioButton radioButton = findViewById(priorityRg.getCheckedRadioButtonId());
        String priority=radioButton.getText().toString();

        if(!title.isEmpty()&&!description.isEmpty()){
            Note note = new Note(title,description,daysOfWeak,priority);
            viewModel.insertNote(note);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Заполните данные",Toast.LENGTH_SHORT).show();
        }




    }
}