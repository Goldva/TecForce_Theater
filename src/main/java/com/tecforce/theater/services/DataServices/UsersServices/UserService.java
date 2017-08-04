package com.tecforce.theater.services.DataServices.UsersServices;

import com.tecforce.theater.annotations.Users;
import com.tecforce.theater.dao.DataDaoInterface;
import com.tecforce.theater.data.entities.EntityInterface;
import com.tecforce.theater.data.entities.User;
import com.tecforce.theater.services.DataServices.DataServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Users
public class UserService implements DataServiceInterface {
    @Autowired
    @Users
    private DataDaoInterface userDao;

    @Transactional
    public User authenticate(User user){
        User searchUser = (User) getEntity(user);
        if (searchUser == null)
            return null;
        if (user.getPassword().equals(searchUser.getPassword())){
            return searchUser;
        }
        return null;
    }

    @Override
    @Transactional
    public void add(EntityInterface entity) {
        userDao.add(entity);
    }

    @Override
    @Transactional
    public EntityInterface getById(long entityId) {
        return userDao.getById(entityId);
    }

    @Override
    @Transactional
    public List<EntityInterface> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public EntityInterface getEntity(EntityInterface entity) {
        return userDao.getEntity(entity);
    }

    @Override
    @Transactional
    public List<EntityInterface> getEntities(EntityInterface entity) {
        return userDao.getEntities(entity);
    }

    @Override
    @Transactional
    public void update(EntityInterface entity) {
        userDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(long entityId) {
        userDao.delete(entityId);
    }
}
