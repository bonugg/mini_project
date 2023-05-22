package com.example.mini_project.controller;

import com.example.mini_project.link_user.User;
import com.example.mini_project.link_user.UserLike;
import com.example.mini_project.oauth.UserLikeRepository;
import com.example.mini_project.oauth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class LikeController {
    private final UserRepository userRepository;
    private final UserLikeRepository userLikeRepository;

    @ResponseBody
    @RequestMapping(value = "/userlike", method = RequestMethod.POST) //좋아요
    public void userlike(@RequestParam("no") long no, @RequestParam("uno") long uno) throws Exception {
        UserLike userLike = new UserLike();
        userLike.setNouser(no);
        userLike.setNolikeuser(uno);
        User user = userRepository.findByNo(uno).get();
        user.plusLike();
        userRepository.save(user);
        userLikeRepository.save(userLike);
    }
    @ResponseBody
    @RequestMapping(value = "/userdislike", method = RequestMethod.POST) //좋아요 삭제
    public void userdislike(@RequestParam("no") long no, @RequestParam("uno") long uno) throws Exception {
        UserLike userLike = new UserLike();
        userLike.setUserlikeid(userLikeRepository.findByUserLikeId(uno, no));
        userLike.setNouser(no);
        userLike.setNolikeuser(uno);
        User user = userRepository.findByNo(uno).get();
        user.minusLike();
        userRepository.save(user);
        userLikeRepository.delete(userLike);
    }

    @ResponseBody
    @RequestMapping(value = "/likeshow", method = RequestMethod.POST) //좋아요 체크 및 좋아요 수
    public Map<String, Integer> likeshow(@RequestParam("no") long no, @RequestParam("uno") long uno) throws Exception {
        int count = 0;
        int likeCount = userLikeRepository.LikeCount(uno);
        count = userLikeRepository.LikeidCheck(uno, no);

        Map<String, Integer> likecc = new HashMap<>();
        likecc.put("count", count);
        likecc.put("likeCount", likeCount);
        return likecc;
    }
}
