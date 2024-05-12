package com.example.healthcare_1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

public class BMIViewModel extends ViewModel {
    private LSHUserDataBase1 userDatabase;
    private MutableLiveData<Double> bmiLiveData = new MutableLiveData<>();

    public BMIViewModel() {
        // 생성자 내용이 필요한 경우 여기에 작성합니다.
    }
    // 생성자에서 Room 데이터베이스 인스턴스 초기화
    public BMIViewModel(Application application) {
        userDatabase = Room.databaseBuilder(application, LSHUserDataBase1.class, "your_database_name").build();
    }


    // BMI를 LiveData로 노출하는 메서드
    public LiveData<Double> getBMI() {
        return bmiLiveData;
    }

    // BMI 계산 및 LiveData 업데이트
    public void calculateAndSetBMI() {
        new Thread(() -> {
            // 데이터베이스가 null이면 LiveData에 null을 전달
            if (userDatabase == null) {
                bmiLiveData.postValue(null);
                return;
            }

            // 데이터베이스에서 몸무게와 키를 가져와 BMI 계산
            LSHUserDao1 dao = userDatabase.lshuserDao1();
            if (dao == null) {
                bmiLiveData.postValue(null);
                return;
            }

            double weight = dao.getWeight();
            double height = dao.getHeight();

            // 데이터베이스에서 값이 null인 경우 처리
            if (Double.isNaN(weight) || Double.isNaN(height)) {
                bmiLiveData.postValue(null);
                return;
            }

            // BMI 계산
            double bmi = calculateBMI(weight, height);

            // LiveData 업데이트를 메인 스레드에서 수행해야 함
            bmiLiveData.postValue(bmi);
        }).start();
    }

    // BMI 계산 메서드
    private double calculateBMI(double weight, double height) {
        // BMI 계산 로직 추가
        return weight / (height * height);
    }
}
