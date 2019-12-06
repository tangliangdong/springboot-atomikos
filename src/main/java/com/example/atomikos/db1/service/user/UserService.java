package com.example.atomikos.db1.service.user;
import com.example.atomikos.db1.dao.user.UserMapper;
import com.example.atomikos.db1.model.user.User;
import com.example.atomikos.db2.model.account.Account;
import com.example.atomikos.db2.service.account.AccountService;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
* @ClassName: UserService
* @Description:
* @author tangliangdong
* @date 2019-12-6
*/
@Service("userService")
public class UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountService accountService;

    //---------增删改查基础部分S--------
    //保存
    public Integer save(User user){
        return userMapper.insert(user);
    }
    //根据id删除条目
    public Integer deleteById(String  uuid){
        User user = new User();
        user.setName(uuid);
        return userMapper.delete(user);
    }
    //根据主键查询
    public User selectByUuid(String uuid){
        if(!StringUtils.hasText(uuid)){
        return null;
        }
        User user = new User();
        user.setName(uuid);
        return userMapper.selectOne(user);
    }
    //根据传入条件查询列表
    public List<User> selectByService(User user){
        return userMapper.select(user);
    }
    //根据传入值更新，空则不变
    public Integer updateByIdSelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
    //更新所有信息
    public Integer updateById(User user){
        return userMapper.updateByPrimaryKey(user);
    }
    //---------增删改查基础部分E--------

    @Transactional
    public String testAtomikos(String name){
        Account account = new Account();
        account.setName(name);
        accountService.save(account);
        User user = new User();
        user.setName(name);
        save(user);
//        int i = 1 / 0;
        return "done";
    }
}