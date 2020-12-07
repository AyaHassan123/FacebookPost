package com.example.facebookpost.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookpost.pojo.PostModel;
import com.example.facebookpost.repostiory.PostRepo;

import java.util.List;


public class PostViewModel extends ViewModel {

   public static MutableLiveData<List<PostModel>> result = new MutableLiveData<>();
    public static MutableLiveData<String> error = new MutableLiveData<>();


    public PostViewModel() {
        this.result = PostRepo.result;
        this.error = PostRepo.error;
    }

    public void getPosts(){
        PostRepo.getPosts();
    }
}
