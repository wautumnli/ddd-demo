package com.ql.ddd.port.demand.persistent.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wanqiuli
 * @date 2022/2/22 17:36
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_TIME = "updateTime";
    public static final String CREATE_USER = "createUser";
    public static final String UPDATE_USER = "updateUser";

    /**
     * insert时调用
     *
     * @param metaObject the metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = this.getFieldValByName(CREATE_TIME, metaObject);
        if (createTime == null) {
            this.setFieldValByName(CREATE_TIME, new Date(), metaObject);
        }

        Object updateTime = this.getFieldValByName(UPDATE_TIME, metaObject);
        if (updateTime == null) {
            this.setFieldValByName(UPDATE_TIME, new Date(), metaObject);
        }

        Object createUser = this.getFieldValByName(CREATE_USER, metaObject);
        if (createUser == null) {
            this.setFieldValByName(CREATE_USER, "system", metaObject);
        }

        Object updateUser = this.getFieldValByName(UPDATE_USER, metaObject);
        if (updateUser == null) {
            this.setFieldValByName(UPDATE_USER, "system", metaObject);
        }
    }


    /**
     * function is updateFill
     *
     * @param metaObject the metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(UPDATE_TIME, new Date(), metaObject);
        this.setFieldValByName(UPDATE_USER, "system", metaObject);
    }
}
