package com.example.GoogleLogin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "/loginSuccesfull", "/dashboard"})
    public String forwardReactRoutes() {
        return "forward:/index.html";
    }


    @GetMapping("/user")
    @ResponseBody
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User oAuth2User) {

        Map<String, Object> data = new HashMap<>();
        data.put("name", oAuth2User.getAttribute("name"));
        data.put("email", oAuth2User.getAttribute("email"));

        Object picture = oAuth2User.getAttribute("picture");

        data.put("image", picture != null ? picture.toString() : "");

        return data;
    }
}
