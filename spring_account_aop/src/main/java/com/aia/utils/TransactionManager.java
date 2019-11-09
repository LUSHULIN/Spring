package com.aia.utils;

import java.sql.SQLException;

/**
 * 事务管理相关的工具类
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public  void beginTransaction() throws SQLException {
        connectionUtils.getThreadConnection().setAutoCommit(false);
    }
    /**
     * 提交事务
     */
    public  void commit() throws SQLException {
        connectionUtils.getThreadConnection().commit();
    }
    /**
     * 回滚事务
     */
    public  void rollback() throws SQLException {
        connectionUtils.getThreadConnection().rollback();

    }
    /**
     * 释放连接
     */
    public void release() throws SQLException {
        connectionUtils.getThreadConnection().close();
        connectionUtils.removeConnection();
    }
}
