package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private ApplicationConfigurationProperties configurationProperties;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(CreateUserDto createUserDto) {
        User user = new User();
        updateUser(user, createUserDto);

        return userRepository.save(user);
    }

    public User save(ModifyUserDto modifyUserDto, String userName) throws UpdatedUserNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (!userOptional.isPresent()) {
            throw new UpdatedUserNotFoundException(userName);
        }

        User user = userOptional.get();
        updateUser(user, modifyUserDto);

        return userRepository.save(user);
    }

    public void delete(User user) {
        timeEntryRepository.deleteByUserName(user.getUserName());
        userRepository.delete(user);
    }

    private void updateUser(User user, CreateUserDto userDto) {
        user.setFullName(userDto.getFullName());
        user.setUserName(userDto.getUserName());
        user.setPassword(
                encryptPassword(userDto.getPassword())
        );

        user.setRoles(configurationProperties.getDefaultUserRoles());
    }

    private void updateUser(User user, ModifyUserDto userDto) {
        user.setFullName(userDto.getFullName());
        if (!StringUtils.isEmpty(userDto.getPassword())) {
            user.setPassword(
                    encryptPassword(userDto.getPassword())
            );
        }
        user.setRoles(userDto.getRoles());
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    public void setTimeEntryRepository(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }
}
