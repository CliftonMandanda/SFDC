package com.example.sfdc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;

public class ScansViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ScansViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Scans fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}