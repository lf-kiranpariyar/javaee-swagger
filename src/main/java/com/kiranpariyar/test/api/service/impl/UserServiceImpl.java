package com.kiranpariyar.test.api.service.impl;

import com.kiranpariyar.test.api.dao.UserDao;
import com.kiranpariyar.test.api.entity.User;
import com.kiranpariyar.test.api.exception.ObjectNotFoundException;
import com.kiranpariyar.test.api.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lftechnology.remittance.service.CrudService#save(java.lang.Object)
     */
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lftechnology.remittance.service.CrudService#update(java.lang.Object)
     */
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lftechnology.remittance.service.CrudService#merge(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    public User merge(UUID id, User newUser) {
        User user = this.findById(id);
        if (user == null) {
            throw new ObjectNotFoundException();
        }
        user.setAddress(newUser.getAddress());
        user.setName(newUser.getName());
        return this.update(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lftechnology.remittance.service.CrudService#remove(java.lang.Object)
     */
    @Override
    public void remove(User user) {
        userDao.remove(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.lftechnology.remittance.service.CrudService#removeById(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    public void removeById(UUID id) {
        User user = this.findById(id);
        if (user == null) {
            throw new ObjectNotFoundException();
        }
        this.remove(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.lftechnology.remittance.service.CrudService#findById(java.lang.
     * Object)
     */
    @Override
    public User findById(UUID id) {
        return userDao.findById(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.lftechnology.remittance.service.CrudService#findByFilter()
     */
    @Override
    public List<User> findByFilter() {
        return userDao.findByFilter();
    }
}
