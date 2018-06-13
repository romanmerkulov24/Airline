package com.merkulov.airline.service.impl;
import com.merkulov.airline.entity.User;
import com.merkulov.airline.repository.UserRepository;
import com.merkulov.airline.repository.transaction.TransactionManager;
import com.merkulov.airline.repository.transaction.TransactionMethod;
import com.merkulov.airline.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private TransactionManager transactionManager;
    private UserRepository userRepository;

    public UserServiceImpl(TransactionManager transactionManager, UserRepository userRepository) {
        this.transactionManager = transactionManager;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return transactionManager.transaction(
                new TransactionMethod<List<User>>() {
                    @Override
                    public List<User> execute(Connection connection) throws SQLException {
                        return userRepository.getAllusers(connection);
                    }
                }
        );
    }
}