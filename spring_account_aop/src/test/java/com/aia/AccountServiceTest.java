package com.aia;

import com.aia.domain.Account;
import com.aia.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;
    @Test
    public void testTransfer() throws Exception {
        as.transfer("张三","李四",100);
    }

    @Test
    public void testFindAll() throws Exception {
       List<Account> accounts = as.findAllAccount();
        for (Account a:accounts) {
            System.out.println(a);
        }
    }

    @Test
    public void testFindById(){
        Account account  = as.findAccountById(1);
        System.out.println(account.getName());
    }
}
