package com.example.ebook.resp;

public class CommonResp<T> {

    private boolean success = true;

    private String message;

//    登录成功的用户信息
    private T content;


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
