package com.aia.dao;

import com.aia.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存用户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账号
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 根据账号ID删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户信息
     * @param accountName  账号名称
     * @return
     */
    Account findAccountByName(String accountName);
}
