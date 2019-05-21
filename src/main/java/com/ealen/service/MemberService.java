package com.ealen.service;


import com.ealen.config.Result;
import com.ealen.entity.Member;

/**
 * @author lhm
 * @date 2019/4/29 9:55
 **/
public interface MemberService {
    /**
     * 用户登录
     * @param registerPhone
     * @return
     */
    Result loginMember(String registerPhone, String loginPassWord);

    /**
     * 用户注册
     * @param member
     * @return
     */
    Result insertMember(Member member);
}
