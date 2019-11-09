package com.aia.service.impl;

import com.aia.dao.IAccountDao;
import com.aia.dao.impl.AccountDaoImpl;
import com.aia.domain.Account;
import com.aia.service.IAccountService;
import com.aia.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = null;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() throws Exception{
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    /**
     * 转账
     * @param  sourceName   转出账号
     * @param targetName    转入账号
     * @param money         转账金额
     */
    public void transfer(String sourceName, String targetName, float money) throws Exception {
        System.out.println("动态代理开始执行");
        //转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //转入账号
        Account target = accountDao.findAccountByName(targetName);
        //转出账号减钱
        source.setMoney(source.getMoney() - money);
        //转入账号加钱
        target.setMoney(target.getMoney() + money);
        //更新转出账户
        accountDao.updateAccount(source);
//        int i = 1/0;
        //更新转入账户
        accountDao.updateAccount(target);
    }


}
