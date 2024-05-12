package com.example.healthcare_1;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.io.Closeable;
import java.util.Calendar;
import java.util.List;

public class CalorieViewModel extends AndroidViewModel {
    private MutableLiveData<Double> calorieChangeLiveData = new MutableLiveData<>();

    private LSHUserDataBase2 database2;


    public CalorieViewModel(Application application) {
        super(application);
        database2 = Room.databaseBuilder(application, LSHUserDataBase2.class, "your_database_name").build();
        calorieChangeLiveData = new MutableLiveData<>();
    }

    public LiveData<Double> getCalorieChangeLiveData() {
        return calorieChangeLiveData;
    }

    public void calculateCalorieChange(int offset) {
        new AsyncTask<Integer, Void, Double>() {
            @Override
            protected Double doInBackground(Integer... offsets) {
                int offset = offsets[0];
                return getCaloriesForDate(offset);
            }

            @Override
            protected void onPostExecute(Double calorieChange) {
                super.onPostExecute(calorieChange);
                // LiveData가 활성 상태이고, UI 스레드에서 실행되도록 보장
                if (calorieChangeLiveData != null && calorieChangeLiveData.hasActiveObservers()) {
                    calorieChangeLiveData.setValue(calorieChange);
                }
            }
        }.execute(offset);
    }

    private double getCaloriesForDate(int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        List<LSHUser2> userEntries = database2.lshuserDao2().getCaloriesForDate(year, month, day);
        double totalCalories = 0;
        for (LSHUser2 user : userEntries) {
            totalCalories += user.getKcal();
        }

        return totalCalories;
    }
}

