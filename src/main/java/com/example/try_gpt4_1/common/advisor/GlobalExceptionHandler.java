package com.example.try_gpt4_1.common.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleEnumException(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            String msg = cause.getMessage();
            Pattern p = Pattern.compile(
                    "Cannot deserialize value of type `(.+?)` from String \\\"(.+?)\\\": not one of the values accepted for Enum class: \\[(.+?)\\]");
            Matcher m = p.matcher(msg);
            StringBuilder sb = new StringBuilder();
            boolean found = false;
            while (m.find()) {
                found = true;
                String enumType = m.group(1);
                String invalidValue = m.group(2);
                String allowed = m.group(3);
                String field = enumType.substring(enumType.lastIndexOf('.') + 1);
                sb.append(String.format("%sは[%s]のいずれかを指定してね！(入力値: %s)", field, allowed, invalidValue)).append("\n");
            }
            if (found) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString().trim());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("リクエストの値が不正だよ！");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Service層の手動バリデーション用: 複数エラーもまとめて返すギャル！
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    // 必要に応じて他の例外もここでハンドリングできるよ！
}
