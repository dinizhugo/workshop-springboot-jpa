package com.hugodiniz.course.services;

import com.hugodiniz.course.entities.User;
import com.hugodiniz.course.repositories.UserRepository;
import com.hugodiniz.course.services.exceptions.DatabaseException;
import com.hugodiniz.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return  repository.save(obj);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) throw new ResourceNotFoundException(id);

            repository.deleteById(id);
        } catch (DataIntegrityViolationException e1) {
            throw new DatabaseException((e1.getMessage()));
        }
    }

    public User update(Long id, User data) {
        User user = repository.getReferenceById(id);
        updateData(user, data);
        return repository.save(user);
    }

    private void updateData(User user, User data) {
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPhone(data.getPhone());
    }
}
