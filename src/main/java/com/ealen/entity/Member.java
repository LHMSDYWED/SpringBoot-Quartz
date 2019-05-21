package com.ealen.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
public class Member implements Serializable {
    private Integer id;

    private String memberUuid;

    private String memberName;

    private String memberNickname;

    private String loginName;

    private String loginPassword;

    private String registerPhone;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}