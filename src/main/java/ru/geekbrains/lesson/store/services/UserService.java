package ru.geekbrains.lesson.store.services;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson.store.data.UserData;
import ru.geekbrains.lesson.store.entities.Role;
import ru.geekbrains.lesson.store.entities.User;
import ru.geekbrains.lesson.store.repositories.UserRepository;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User findByUsername(String username){
        return  userRepository.findByUsername(username);
    }

    public User getCurrentUser(Principal principal){
        System.out.println("UserService = "+ principal);
        System.out.println("userService name = " + principal.getName());
        return findByUsername(principal.getName());
    }

    public User getOne(Long id){
        return userRepository.getOne(id);
    }

    public User createUser(UserData userData){
        User user = new User();
        user.setName(userData.getName());
        user.setUsername(userData.getUsername());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(user);
    }

    public User createUserWithRole(UserData userData){
        User user = new User();
        user.setName(userData.getName());
        user.setUsername(userData.getUsername());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        Collection<Role> roles = userData.getRoles().stream()
                .map(roleService::findByName)
                .collect(Collectors.toList());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public void authenticateUser(User user){
        Collection<?extends GrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        authorities),
                null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
