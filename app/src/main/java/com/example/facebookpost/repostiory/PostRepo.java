package com.example.facebookpost.repostiory;

import androidx.lifecycle.MutableLiveData;

import com.example.facebookpost.network.RetrofitModule;
import com.example.facebookpost.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostRepo {

    public  static MutableLiveData<List<PostModel>> result = new MutableLiveData<>();
    public  static MutableLiveData<String> error = new MutableLiveData<>();

    public static void getPosts() {
     RetrofitModule.getService()
             .getPost()
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<List<PostModel>>() {
                 @Override
                 public void onSubscribe(@NonNull Disposable d) {

                 }

                 @Override
                 public void onNext(@NonNull List<PostModel> postModels) {

                     result.setValue(postModels);
                 }

                 @Override
                 public void onError(@NonNull Throwable e) {

                     error.setValue(e.getLocalizedMessage());
                 }

                 @Override
                 public void onComplete() {

                 }
             });
    }
}
