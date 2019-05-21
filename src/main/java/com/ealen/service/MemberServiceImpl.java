package com.ealen.service;

import com.ealen.config.Result;
import com.ealen.dao.MemberMapper;

import com.ealen.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lhm
 * @date 2019/4/29 9:55
 **/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 用户登录
     * @param registerPhone
     * @param loginPassWord
     * @return
     */
    @Override
    public Result loginMember(String registerPhone, String loginPassWord) {
        Member member= memberMapper.selectByRegisterPhone(registerPhone);
        String pwd=member.getLoginPassword();
        if(pwd!=null&&pwd==loginPassWord){
            return  new Result(false,200,"登录成功" );
        }
        return new Result(true,500,"请重新登录");
    }

    /**
     * 用户注册
     * @param member
     * @return
     */
    @Override
    public Result insertMember(Member member) {
        //插入一条数据  先判断此手机号是否存在  存在则登录 不存在 则注册
        String registerPhone=member.getRegisterPhone();
        String pwd=member.getLoginPassword();
        Member member1=memberMapper.selectByRegisterPhone(registerPhone);
        //说明此手机号已经注册
        if(member1.getRegisterPhone()!=null){
            return  new Result(false,200,"此手机号已注册，请直接登录");
        }
        //直接注册
        memberMapper.insertSelective(member);

        return new Result(true,200,"注册成功");
    }
}
