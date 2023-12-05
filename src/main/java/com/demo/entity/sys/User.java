package com.demo.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.business.EntityUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-30
 * @Description : 用户实体
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("comm_user")
public class User extends EntityUtils {
    private String userType;        // 用户类型
    private String nickname;        // 用户昵称
    private String gender;          // 用户性别
    private Account account;

}
