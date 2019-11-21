package com.mitsko.poputka.dao;

import com.mitsko.poputka.entity.User;

public interface UserDAO {
    boolean addUser(User user);
    User getUser();
}
