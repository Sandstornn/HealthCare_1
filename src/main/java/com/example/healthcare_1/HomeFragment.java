package com.example.healthcare_1;

import android.content.ContentValues;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {
    private TextView bmiTextView;
    // 닉네임 표시에 사용
    private TextView textViewNickname;
    private UserNicknameViewModel userNicknameViewModel;
    // BMI 표시에 사용
    private TextView textViewBMI;
    private LSHUserDataBase1 user_database;

    // 어제 대비 칼로리량에 사용
    private TextView textViewCalorieChange;
    private CalorieViewModel calorieViewModel;
    private LSHUserDataBase2 database2;
    private ImageView profileImg;
    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calorieViewModel = new ViewModelProvider(this).get(CalorieViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // 프로필 클릭 시
        profileImg = rootView.findViewById(R.id.profile_img);
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 설정 프래그먼트 띄우기
                // 설정 프래그먼트 생성
                SettingsFragment settingsFragment = new SettingsFragment();

                // 프래그먼트 매니저를 사용하여 설정 프래그먼트를 트랜잭션에 추가하고 커밋
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, settingsFragment)  // fragment_container는 설정 프래그먼트가 표시될 레이아웃입니다.
                        .addToBackStack(null)  // 백 스택에 추가하여 이전 프래그먼트로 돌아갈 수 있도록 합니다.
                        .commit();
            }
        });



        // 닉네임 가져오기
        // TextView 초기화
        textViewNickname = rootView.findViewById(R.id.textViewNickname);

        // UserNicknameViewModel 초기화
        userNicknameViewModel = new ViewModelProvider(this).get(UserNicknameViewModel.class);

        // 사용자 닉네임 LiveData 관찰
        userNicknameViewModel.getNickname().observe(getViewLifecycleOwner(), nickname -> {
            // 사용자 닉네임이 변경될 때마다 TextView 업데이트
            textViewNickname.setText(nickname);
        });


        //BMI 표시
        // TextView 초기화
        textViewBMI = rootView.findViewById(R.id.BMI_home);

        // BMIViewModel 초기화
        BMIViewModel bmiViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication())).get(BMIViewModel.class);

        // BMI LiveData 관찰
        bmiViewModel.getBMI().observe(getViewLifecycleOwner(), bmi -> {
            // BMI가 변경될 때마다 TextView 업데이트
            textViewBMI.setText(String.format(Locale.getDefault(), "%.2f", bmi));
        });

        // BMI 계산 및 업데이트
        bmiViewModel.calculateAndSetBMI();


        // 가운데 칼로리 값 표시
        // TextView 초기화
        TextView textViewCalorieChange = rootView.findViewById(R.id.calorie_change);
        calorieViewModel.getCalorieChangeLiveData().observe(getViewLifecycleOwner(), calorieChange -> {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedCalorieChange = decimalFormat.format(calorieChange);
            textViewCalorieChange.setText(formattedCalorieChange);
        });

        // 어제와 오늘의 칼로리를 계산하고 LiveData를 업데이트
        calorieViewModel.calculateCalorieChange(-1);


        return rootView;
    }
    @Override
    public void onStart()
    {
        super.onStart();
    }
    @Override
    public void onPause()
    {
        super.onPause();
    }
    @Override
    public void onResume()
    {
        super.onResume();
    }


}

