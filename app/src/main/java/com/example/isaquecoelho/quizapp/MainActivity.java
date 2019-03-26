package com.example.isaquecoelho.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final boolean LOADING_FORM = false;

    private EditText mEditTextFirstQuestion;
    private RadioButton mRadioButtonSecondQuestionFirstOption;
    private RadioButton mRadioButtonSecondQuestionSecondOption;
    private RadioButton mRadioButtonSecondQuestionThirdOption;
    private CheckBox mCheckBoxThirdQuestionFirstOption;
    private CheckBox mCheckBoxThirdQuestionSecondOption;
    private CheckBox mCheckBoxThirdQuestionThirdOption;
    private SwitchCompat mSwitchCompatFourthQuestion;
    private Button mButtonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        listeningView();
    }

    private void initView() {
        mEditTextFirstQuestion = findViewById(R.id.edittext_firstquestion);
        mRadioButtonSecondQuestionFirstOption = findViewById(R.id.radiobutton_secondquestion_firstoption);
        mRadioButtonSecondQuestionSecondOption = findViewById(R.id.radiobutton_secondquestion_secondoption);
        mRadioButtonSecondQuestionThirdOption = findViewById(R.id.radiobutton_secondquestion_thirdoption);
        mCheckBoxThirdQuestionFirstOption = findViewById(R.id.checkbox_thirdquestion_firstoption);
        mCheckBoxThirdQuestionSecondOption = findViewById(R.id.checkbox_thirdquestion_secondoption);
        mCheckBoxThirdQuestionThirdOption = findViewById(R.id.checkbox_thirdquestion_thirdoption);
        mSwitchCompatFourthQuestion = findViewById(R.id.switch_fourthquestion);
        mButtonConfirm = findViewById(R.id.button_confirmform);
    }

    private void listeningView(){

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingForm(LOADING_FORM);
                validateQuiz();
            }
        });
    }

    private void loadingForm(final boolean STATUS_FORM) {
        mEditTextFirstQuestion.setEnabled(STATUS_FORM);
        mRadioButtonSecondQuestionFirstOption.setEnabled(STATUS_FORM);
        mRadioButtonSecondQuestionSecondOption.setEnabled(STATUS_FORM);
        mRadioButtonSecondQuestionThirdOption.setEnabled(STATUS_FORM);
        mCheckBoxThirdQuestionFirstOption.setEnabled(STATUS_FORM);
        mCheckBoxThirdQuestionSecondOption.setEnabled(STATUS_FORM);
        mCheckBoxThirdQuestionThirdOption.setEnabled(STATUS_FORM);
        mSwitchCompatFourthQuestion.setEnabled(STATUS_FORM);
        mButtonConfirm.setEnabled(STATUS_FORM);
    }

    private void validateQuiz() {

        int points = 0;
        String CONSTANT_RESULT_FIRST_QUESTION = "ANDROID";

        if(mEditTextFirstQuestion.getText().toString().trim().equalsIgnoreCase(CONSTANT_RESULT_FIRST_QUESTION)){
            points++;
        }

        if (mRadioButtonSecondQuestionSecondOption.isChecked()){
            points++;
        }

        if (mCheckBoxThirdQuestionFirstOption.isChecked()
                && mCheckBoxThirdQuestionThirdOption.isChecked()
                && !mCheckBoxThirdQuestionSecondOption.isChecked()){
            points++;
        }

        if(mSwitchCompatFourthQuestion.isChecked()){
            points++;
        }

        showResult(points);

    }

    private void showResult(int points) {
        String message;

        if(points == 4){
            message = "You passed the Quiz with score " + points + ", it's AMAZING!";
        } else {
            message = "You failed with score " + points + " points, TRY AGAIN!";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        loadingForm(true);
        cleanForm();
    }

    private void cleanForm() {
        mEditTextFirstQuestion.setText(null);
        mRadioButtonSecondQuestionFirstOption.setChecked(false);
        mRadioButtonSecondQuestionSecondOption.setChecked(false);
        mRadioButtonSecondQuestionThirdOption.setChecked(false);
        mCheckBoxThirdQuestionFirstOption.setChecked(false);
        mCheckBoxThirdQuestionSecondOption.setChecked(false);
        mCheckBoxThirdQuestionThirdOption.setChecked(false);
        mSwitchCompatFourthQuestion.setChecked(false);
    }
}
