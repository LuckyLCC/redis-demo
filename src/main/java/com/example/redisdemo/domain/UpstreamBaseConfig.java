package com.example.redisdemo.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-10-18  17:03
 */

@Data
@Builder
public class UpstreamBaseConfig implements Serializable {

    private Integer id;

    private String adCode;

    private String cityName;

    private String upAddress;

    private String tokenURL;

    private Boolean isUpFlag;

    private String grantType;

    private String appId;

    private String appSecret;

    private String createTime;

    private String updateTime;

    private String updateTime17;
    private String updateTime3;
    private String updateTime4;


    private String updateTime1;
    private String updateTime5;
    private String updateTime6;


}
