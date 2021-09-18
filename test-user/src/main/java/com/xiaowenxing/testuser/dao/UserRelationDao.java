package com.xiaowenxing.testuser.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaowenxing.testuser.dao.mapper.UserRelationMapper;
import com.xiaowenxing.testuser.domin.UserRelationDo;
import org.springframework.stereotype.Component;

/**
 * 数据库连接层
 *
 * @author XWX
 * @date 2021/9/18 17:07
 * @since 4.2
 **/
@Component
public class UserRelationDao extends ServiceImpl<UserRelationMapper, UserRelationDo> {
}
