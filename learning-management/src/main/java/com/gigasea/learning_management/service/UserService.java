package com.gigasea.learning_management.service;



import com.gigasea.learning_management.repository.UserRepository;
import com.gigasea.learning_management.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}

