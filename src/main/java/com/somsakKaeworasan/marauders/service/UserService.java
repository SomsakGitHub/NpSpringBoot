package com.somsakKaeworasan.marauders.service;

import com.somsakKaeworasan.marauders.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Boolean register(User user);
    Boolean login(User user);
}
