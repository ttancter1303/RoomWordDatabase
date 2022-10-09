package com.example.roomwordssample.datas;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.roomwordssample.WordDAO;

import java.util.List;

public class WordRepository {
    private static WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDAO = db.wordDAO();
        mAllWords = mWordDAO.getAllWords();
    }
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert (Word word) {
        new insertAsyncTask(mWordDAO).execute(word);
    }
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDAO mAsyncTaskDao;

        insertAsyncTask(WordDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
