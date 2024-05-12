package com.example.healthcare_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class SignUpActivity extends AppCompatActivity {

    private EditText etNickname, etWeight, etAge, etHeight;
    private RadioGroup radioGroupGender;
    private Button btnSubmit;

    private SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etNickname = findViewById(R.id.etNickname);
        etWeight = findViewById(R.id.etWeight);
        etAge = findViewById(R.id.etAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        btnSubmit = findViewById(R.id.btnSubmit);
        etHeight = findViewById(R.id.etHeight);

        // ViewModel 초기화
        signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 사용자가 입력한 정보를 가져옴
                String nickname = etNickname.getText().toString();
                String weightStr = etWeight.getText().toString();
                String ageStr = etAge.getText().toString();
                String heightStr = etHeight.getText().toString();

                // 입력값이 비어있는지 확인
                if (nickname.isEmpty() || weightStr.isEmpty() || ageStr.isEmpty() || heightStr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 숫자 입력란에 숫자가 아닌 값이 있는지 확인
                double weight, height;
                int age;
                try {
                    weight = Double.parseDouble(weightStr);
                    height = Double.parseDouble(heightStr);
                    age = Integer.parseInt(ageStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(SignUpActivity.this, "모든 항목은 숫자로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String genderString = getSelectedGender();
                int gender;
                if(genderString=="남성"){
                    gender =0;
                }
                else{
                    gender=1;
                }
                // UserInfo 객체 생성
                LSHUser1 userInfo = new LSHUser1();
                userInfo.setNickname(nickname);
                userInfo.setWeight(weight);
                userInfo.setHeight(height);
                userInfo.setAge(age);
                userInfo.setGender(gender);

                // ViewModel을 통해 회원가입 정보 저장
                signUpViewModel.insertUser(userInfo);

                // 회원가입 성공 알림 표시
                Toast.makeText(SignUpActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                finish();
                // MainActivity로 이동
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // 선택된 성별을 반환
    private String getSelectedGender() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }
}
