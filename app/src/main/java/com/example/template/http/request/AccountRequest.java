package com.example.template.http.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ViewModel;

import com.example.template.data.bean.User;
import com.example.template.repository.DataRepository;
import com.kunminx.architecture.data.response.DataResult;
import com.kunminx.architecture.domain.message.MutableResult;

public class AccountRequest extends ViewModel implements DefaultLifecycleObserver {

    private final MutableResult<DataResult<String>> tokenResult = new MutableResult<>();

    public void requestLogin(User user) {
//        DataRepository dataRepository = new DataRepository();
        DataRepository.getInstance().login(user, tokenResult::postValue);
    }
}
