package com.aia.factory;

import com.aia.service.IAccountService;
import com.aia.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象的工厂
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    /**
     * 获取service代理对象
     * @return
     */
    public IAccountService getAccountService() {
       return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            txManager.beginTransaction();
                            rtValue = method.invoke(accountService,args);
                            txManager.commit();
                            return rtValue;
                        } catch (Exception e){
                            txManager.rollback();
                        }finally {
                            txManager.release();
                            return rtValue;
                        }
                    }
                });
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
