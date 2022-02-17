package cn.itcast.user.service;

import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
    @Transactional
    public void delete(Long id){
        userMapper.deleteById(id);
        userService.deleteByName();
    }
    @Transactional(propagation = Propagation.NEVER)
    public void deleteByName(){
        userMapper.deleteByName("123");
    }

}