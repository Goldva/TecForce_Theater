package com.tecforce.theater.services.DataServices.UsersServices;

import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Authenticate {
    @Autowired
    @Users
    private DataDaoInterface userDao;

    @Transactional
    public User authenticate(User user){
        User searchUser = (User) userDao.getEntity(user);
        if (searchUser == null)
            return null;
        if (user.getPassword().equals(searchUser.getPassword())){
            return searchUser;
        }
        return null;
    }

}
