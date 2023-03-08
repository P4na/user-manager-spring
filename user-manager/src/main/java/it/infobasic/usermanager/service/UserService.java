package it.infobasic.usermanager.service;

import it.infobasic.usermanager.model.User;
import it.infobasic.usermanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> getAll(){
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    public Optional<User> getById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
        return;
    }

    public User save(User newUser) {
        User user = new User(newUser.getUsername(), newUser.getPassword(), newUser.getEmail(), newUser.getDataNascita());
        userRepository.save(user);
        return user;
    }

    public Optional<User> updateById(long id, User newUser) {
        Optional<User> utenteOld = userRepository.findById(id);
        utenteOld.get().setUsername(newUser.getUsername());
        utenteOld.get().setPassword(newUser.getPassword());
        utenteOld.get().setEmail(newUser.getEmail());
        utenteOld.get().setDataNascita(newUser.getDataNascita());
        userRepository.save(utenteOld.get());
        return utenteOld;
    }
}

