package com.yi.androidprojectpractice.classes;

import androidx.annotation.Nullable;

import java.util.List;

public class Result<T> {

    public final static class Success<T> extends Result{
        private T data;

        public Success(T data){this.data = data;}

        public T getData(){return data;}
    }

    public final static class Error extends Result{
        private Exception e;

        public Error(Exception e){this.e = e;}

        public Exception getError(){return e;}

    }
}
