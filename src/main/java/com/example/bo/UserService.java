package com.example.bo;

import com.example.domain.dto.SiteUser;
import com.example.exception.AppException;
import com.example.exception.ErrorCode;
import com.example.jwt.JwtTokenUtil;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Value("${jwt.token.secret}")
    private String key;
    private Long expireTimeMs = 1000 * 60 * 60l; //1시간
    /**
     * 화면에서 LoginRequest(loginId, password)을 입력받아 loginId와 password가 일치하면 User return
     * userName이 존재하지 않거나 password가 일치하지 않으면 null return
     */
    public String login(String userName, String password) {
        // userName 없음
        SiteUser selectedUser = userRepository.findByUsername(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + "은 존재하지 않는 ID입니다."));
        // password 틀림
        // log.info("selectedPw: {} pw:{}", selectedUser.getPassword(), password);
        if(!encoder.matches(password, selectedUser.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD, "패스워드를 잘못 입력했습니다.");
        }
        // Exception 없으면 토큰 발행
        String token = JwtTokenUtil.createToken(selectedUser.getUsername(), key, expireTimeMs);
        return token;
    }

    // email, number 가져오기
    public Map<String, String> getiIfo(String userName, String password) {
        SiteUser selectedUser = userRepository.findByUsername(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, ":: " + userName + "은 존재하지 않는 ID입니다."));
        Map<String, String> userMap = new HashMap<>();
        userMap.put("E-mail", selectedUser.getEmail());
        userMap.put("Phone-number", selectedUser.getNumber());

        return userMap;
    }
}
