package com.example.atomikos.db2.service.account;
import com.example.atomikos.db2.dao.account.AccountMapper;
import com.example.atomikos.db2.model.account.Account;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @ClassName: AccountService
* @Description:
* @author tangliangdong
* @date 2019-12-6
*/
@Service("accountService")
public class AccountService{
    @Autowired
    private AccountMapper accountMapper;

    //---------增删改查基础部分S--------
    //保存
    public Integer save(Account account){
        return accountMapper.insert(account);
    }
    //根据id删除条目
    public Integer deleteById(String  uuid){
        Account account = new Account();
        account.setName(uuid);
        return accountMapper.delete(account);
    }
    //根据主键查询
    public Account selectByUuid(String uuid){
        if(!StringUtils.hasText(uuid)){
        return null;
        }
        Account account = new Account();
        account.setName(uuid);
        return accountMapper.selectOne(account);
    }
    //根据传入条件查询列表
    public List<Account> selectByService(Account account){
        return accountMapper.select(account);
    }
    //根据传入值更新，空则不变
    public Integer updateByIdSelective(Account account){
        return accountMapper.updateByPrimaryKeySelective(account);
    }
    //更新所有信息
    public Integer updateById(Account account){
        return accountMapper.updateByPrimaryKey(account);
    }
    //---------增删改查基础部分E--------
}