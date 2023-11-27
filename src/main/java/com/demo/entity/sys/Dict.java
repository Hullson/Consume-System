package com.demo.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.business.EntityUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author      : Hullson
 * @Date        : create in 2023-11-27
 * @Description : 系统字典实体
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_dict")
public class Dict extends EntityUtil {
    private String label;           // 字典标签
    private String value;           // 字典数据值
    private String style;           // 字典类型
    private String description;     // 字典描述
}
