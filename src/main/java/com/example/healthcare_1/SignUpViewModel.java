package com.example.healthcare_1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class SignUpViewModel extends AndroidViewModel {
    private LSHUserDataBase1 lshUserDataBase1;

    public SignUpViewModel(@NonNull Application application) {
        super(application);
        // 데이터베이스 인스턴스 초기화
        lshUserDataBase1 = LSHUserDataBase1.getInstance(application);
    }

    // 회원가입 정보 저장 메소드
    public void insertUser(LSHUser1 user) {
        // AsyncTask를 사용하여 백그라운드 스레드에서 데이터베이스 작업 수행
        new InsertUserAsyncTask().execute(user);
    }

    // AsyncTask 클래스 정의
    private class InsertUserAsyncTask extends AsyncTask<LSHUser1, Void, Void> {
        @Override
        protected Void doInBackground(LSHUser1... users) {
            // 여기서 데이터베이스에 사용자 정보 저장
            if (users != null && users.length > 0) {
                lshUserDataBase1.lshuserDao1().setInsertUser(users[0]);
            }
            return null;
        }
    }
}
