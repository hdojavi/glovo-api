package com.jhernando.glovo.model.services;


import com.jhernando.glovo.model.repositories.IUserRepository;
import com.jhernando.glovo.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.security.KeyStore;
import java.util.List;

@Service
public class UserService implements IService<User, Long> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        User userToBeUpdated;

        if (user.getId() == null) {
            userToBeUpdated = user;
        } else {
            userToBeUpdated = userRepository.findById(user.getId()).orElse(null);
            userToBeUpdated.setEmail(user.getEmail());
            userToBeUpdated.setNickname(user.getNickname());

            if (user.getTlfn().isEmpty()) {
                userToBeUpdated.setTlfn(null);
            }
        }
        return userRepository.save(userToBeUpdated);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User login(User user) {
        User userToBeChecked = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        return (userToBeChecked != null && userToBeChecked.getPassword().equals(user.getPassword())) ? userToBeChecked : null;
    }
}
