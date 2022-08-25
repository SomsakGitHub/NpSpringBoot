package com.somsakKaeworasan.marauders.service.implement;

import com.somsakKaeworasan.marauders.model.User;
import com.somsakKaeworasan.marauders.repository.UserRepo;
import com.somsakKaeworasan.marauders.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Boolean register(User user) {

        User username = userRepo.findByUsername(user.getUsername());
        if(username.getUsername().isEmpty()){
            userRepo.save(user);
        }else {
            //System.out.println("username=>" + username.get().getUsername());
            return false;
        }

        User usernameSave = userRepo.findByUsername(user.getUsername());
        if(usernameSave.getUsername().isEmpty()){
            return false;
        }else {
            return true;
        }

//        Optional<User> usernameSave = userRepo.findByUsername(user.getUsername());
//        if(usernameSave.isPresent()){
//            return true;
//        }

//        String sql = "SELECT * FROM user WHERE username = ?";
//        ArrayList param  = new ArrayList<>();
//        param.add(user.getUsername());
//        List<User> result = jdbcTemplate.query(sql, param.toArray(), BeanPropertyRowMapper.newInstance(User.class));
//
//        if (result.size() > 0) {
//            System.out.println("username>" + result.get(0).getUsername());
//        }

    }

    @Override
    public Boolean login(User user) {

        User userData = userRepo.findByUsername(user.getUsername());
        if(!userData.getUsername().isEmpty()){
            System.out.println("username>" + userData.getPassword());
            System.out.println("username>" + user.getPassword());
            if(userData.getPassword().equals(user.getPassword())){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

}
