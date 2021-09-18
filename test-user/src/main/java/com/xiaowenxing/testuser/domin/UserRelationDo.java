package com.xiaowenxing.testuser.domin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户关系实体类
 *
 * @author XWX
 * @date 2021/9/18 16:59
 * @since 4.2
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_relation")
public class UserRelationDo {

    private static final long serialVersionUID= -4850247546446690546L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long userId;

    /**
     * 上级id
     */
    private Long parentId;

    /**
     * 上上级id
     */
    private Long grandparentId;

    /**
     * 会员等级 1:A 2:B 3:C 4:D
     */
    private Integer level;

    /**
     * 合伙人id 可为自己的uid
     */
    private Long partnerId;

    /**
     * 累计上级分佣
     */
    private BigDecimal parentCommission;

    /**
     * 累计上上级分佣
     */
    private BigDecimal grandparentCommission;

    /**
     * 累计合伙人贡献佣金
     */
    private BigDecimal partnerCommission;

    /**
     * 加入时间
     */
    private LocalDateTime joinTime;

    /**
     * 邀请的原因：1:首次绑定设备,2:首次加入家庭,3:注册后输入邀请码,4:老数据邀请关系订正
     */
    private Integer source;

    /**
     * 老用户二级代理的会员身份可能会回退
     */
    private LocalDateTime expireTime;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isEmployee;

}
