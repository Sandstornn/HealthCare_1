package com.example.healthcare_1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

public class UserNicknameViewModel extends ViewModel {
    private LSHUserDataBase1 userDatabase;
    private MutableLiveData<String> nicknameLiveData = new MutableLiveData<>();

    // 생성자에서 Room 데이터베이스 인스턴스 초기화
    public UserNicknameViewModel(Application application) {
        userDatabase = Room.databaseBuilder(application, LSHUserDataBase1.class, "your_database_name").build();
        loadNickname(); // ViewModel이 생성될 때 닉네임을 미리 불러옵니다.
    }
    public UserNicknameViewModel() {
        // 생성자 내용이 필요한 경우 여기에 작성합니다.
    }

    // 사용자 닉네임을 LiveData로 노출하는 메서드
    public LiveData<String> getNickname() {
        return nicknameLiveData;
    }

    // 데이터베이스에서 사용자 닉네임을 가져와 LiveData에 설정하는 메서드
    private void loadNickname() {
        String nickname = userDatabase.getNickname();
        nicknameLiveData.setValue(nickname != null ? nickname : "닉네임을 찾을 수 없음");
    }
}

