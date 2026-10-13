package com.example.firsttaskapi.exception;

public class FighterNotFoundException extends RuntimeException {
    public FighterNotFoundException(Integer id) {
        super("指定されたファイターのIDが見つかりません：" + id);
    }
}
