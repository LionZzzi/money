package com.eric.base.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充策略
 * 如果token为空,则代表公用接口(无创建人,更新人)
 *
 * @author Eric
 * @date 2019-05-23
 */
@Component
public class AutoFillConfig implements MetaObjectHandler {

    public static final String CREATE_USER = "createBy";
    public static final String UPDATE_USER = "updateBy";
    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.strictInsertFill(metaObject, CREATE_USER, String.class, "eric");
        this.strictInsertFill(metaObject, UPDATE_USER, String.class, "eric");
        this.strictInsertFill(metaObject, CREATE_TIME, Date.class, now);
        this.strictInsertFill(metaObject, UPDATE_TIME, Date.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, UPDATE_USER, String.class, "eric");
        this.strictInsertFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }
}

