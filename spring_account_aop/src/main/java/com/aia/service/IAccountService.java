package com.aia.service;

import com.aia.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws Exception;

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

    /**
     * 转账功能
     * @param  sourceName   转出账号
     * @param targetName    转入账号
     * @param money         转账金额
     */
    void transfer(String sourceName,String targetName,float money) throws Exception;
}
