package com.example.controller;

import com.example.bo.UserService;
import com.example.domain.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class InfoController {
    private final UserService userService;
    @PostMapping("/info")
    public ResponseEntity<?> getUserInfo(Authentication authentication, @RequestBody UserInfo dto) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HttpStatus status = HttpStatus.OK;
        Map<String, String> userInfoMap = userService.getiIfo(dto.getUserName(), dto.getPassword());
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("rtnCd", status.value());
        resultMap.put("rtnMsg", status.getReasonPhrase());
        resultMap.put("timestamp", now.format(formatter));
        resultMap.put("UserName", authentication.getName());
        resultMap.put("E-mail", userInfoMap.get("E-mail"));
        resultMap.put("Phone", userInfoMap.get("Phone-number"));

        return ResponseEntity.ok().body(resultMap);
    }
}
