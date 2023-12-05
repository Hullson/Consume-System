package com.demo.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.business.EntityUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-29
 * @Description : 登录账号实体类
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("comm_account")
public class Account extends EntityUtils {
    private String account;     // 登录账号
    private String pwd;         // 账号密码
}
