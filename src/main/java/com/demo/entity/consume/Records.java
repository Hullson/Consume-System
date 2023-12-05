package com.demo.entity.consume;

import com.demo.business.EntityUtils;
import com.demo.entity.sys.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-12-04
 * @Description : 消费记录实体
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Records extends EntityUtils {
    private String item;            // 消费项
    private String style;           // 消费类型
    private BigDecimal amount;          // 消费金额
    private Date amountDate;        // 消费时间
    private String description;     // 消费详情
    private User user;              // 消费用户
}
