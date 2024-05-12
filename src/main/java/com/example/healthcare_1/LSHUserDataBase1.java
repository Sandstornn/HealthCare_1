package com.example.healthcare_1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LSHUser1.class},version=2)
public abstract class LSHUserDataBase1 extends RoomDatabase {
    public abstract LSHUserDao1 lshuserDao1();

    // 추가: 마이그레이션 하래서 추가하긴 하는데, 무슨 버근지 모르겠다.
    static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 이전 버전과 새로운 버전 간의 스키마 변경 내용을 여기에 작성
        }
    };

    // 추가: 닉네임을 뽑아내는 메서드
    public String getNickname() {
        // DAO를 통해 쿼리를 실행하여 닉네임을 가져옵니다.
        LSHUserDao1 dao = lshuserDao1();
        if (dao != null) {
            // 모든 사용자 프로필을 가져옵니다.
            List<LSHUser1> users = dao.getUserAll();
            // 첫 번째 사용자의 닉네임을 반환합니다.
            if (!users.isEmpty()) {
                return users.get(0).getNickname();
            }
        }
        return null; // 사용자가 없거나 DAO가 null일 경우 null 반환
    }

    // 추가 : 인스턴스마다 각 데이터베이스

    private static volatile LSHUserDataBase1 INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static LSHUserDataBase1 getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (LSHUserDataBase1.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LSHUserDataBase1.class, "LSHUserInformationDataBase1")
                            .addMigrations(LSHUserDataBase1.MIGRATION_1_2)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
