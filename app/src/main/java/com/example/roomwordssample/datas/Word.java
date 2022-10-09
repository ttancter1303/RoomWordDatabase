package com.example.roomwordssample.datas;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {
    public Word(String mWord) {
        this.mWord = mWord;
    }

    public String getWord() {
        return mWord;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

}
