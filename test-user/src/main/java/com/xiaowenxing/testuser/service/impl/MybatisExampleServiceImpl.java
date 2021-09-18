package com.xiaowenxing.testuser.service.impl;

import com.xiaowenxing.testuser.dao.UserRelationDao;
import com.xiaowenxing.testuser.domin.UserRelationDo;
import com.xiaowenxing.testuser.service.MyBatisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/9/18 17:11
 * @since 4.2
 **/
@Service
public class MybatisExampleServiceImpl implements MyBatisExampleService {

    @Autowired
    private UserRelationDao userRelationDao;

    @Override
    public UserRelationDo find() {
        UserRelationDo relationDo = userRelationDao.getById(2);
        return relationDo;
    }
}
