package com.example.healthcare_1;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    // 데이터베이스 생성
    LSHUserDataBase1 userDatabase;

    // 마이그레이션 설정


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());

        // 데이터베이스 생성 및 마이그레이션 설정
        userDatabase = Room.databaseBuilder(this, LSHUserDataBase1.class, "LSHUserDataBase1")
                .addMigrations(LSHUserDataBase1.MIGRATION_1_2)
                .build();

        // 클릭했을 때, 홈으로 가는 코드다.
        // 네비게이션 아이콘 관련 코드
        FloatingActionButton fabNavigation = findViewById(R.id.fab_navigation);

        // PopupMenu를 표시합니다.
        fabNavigation.setOnClickListener(this::showPopupMenu);
    }

    // 네비게이션 아이콘 관련 코드. 클릭하면, 관련 프래그먼트 띄워줌.
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.navigation_menu); // 네비게이션 메뉴 아이템을 인플레이트합니다.

        // PopupMenu의 각 아이템에 대한 클릭 이벤트 처리
        // 프래그먼트 추가할 때 까지만 주석처리
        popupMenu.setOnMenuItemClickListener(item -> {
            // 클릭된 아이템에 따라 해당 프래그먼트를 로드합니다.
            if (item.getItemId() == R.id.menu_home) {
                loadFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_allergy) {
                // loadFragment(new AllergyFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_diet) {
                // 식단 프래그먼트 로드
                // loadFragment(new DietFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_exercise) {
                // 운동 프래그먼트 로드
                // loadFragment(new ExerciseFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_callender) {
                // 보상 프래그먼트 로드
                // loadFragment(new CallenderFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_settings) {
                // 설정 프래그먼트 로드
                // loadFragment(new SettingsFragment());
                return true;
            } else {
                return false;
            }
        });

        popupMenu.show();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
