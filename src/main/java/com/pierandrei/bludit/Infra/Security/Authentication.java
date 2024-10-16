package com.pierandrei.bludit.Infra.Security;


import com.pierandrei.bludit.Enum.Roles;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Authentication {
    private final UserRepository userRepository;

    public User loadUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado!"));
    }

    public List<SimpleGrantedAuthority> getAuthorities(User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (user.getRoles() == Roles.USER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        if (user.getRoles() == Roles.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        if (user.getRoles() == Roles.SUPER_ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
        }

        if (user.getRoles() == Roles.MODERATOR) {
            authorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }

        return authorities;
    }
}