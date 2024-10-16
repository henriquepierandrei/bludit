package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Dto.Input.LoginDto;
import com.pierandrei.bludit.Dto.Input.RegisterDto;
import com.pierandrei.bludit.Dto.Response.LoginResponse;
import com.pierandrei.bludit.Dto.Response.RegisterResponse;
import com.pierandrei.bludit.Exception.EmailAlreadyExistsException;
import com.pierandrei.bludit.Exception.PhoneAlreadyExistsException;
import com.pierandrei.bludit.Exception.UsernameAlreadyExistsException;
import com.pierandrei.bludit.Infra.Security.Token;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Token tokenService;

    public LoginResponse loginService(@Validated LoginDto loginDto) {
        Optional<User> user = userRepository.findByEmail(loginDto.email());

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        if (!passwordEncoder.matches(loginDto.password(), user.get().getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        String token = tokenService.generateToken(user.get());
        return new LoginResponse(token, user.get().getUsername(), user.get().getRoles());
    }


    public RegisterResponse registerService(@Validated RegisterDto registerDto){
        if (userRepository.existsByEmail(registerDto.email())){
            throw new EmailAlreadyExistsException();
        }

        if (userRepository.existsByUsername(registerDto.username())){
            throw new UsernameAlreadyExistsException();
        }

        if (userRepository.existsByPhone(registerDto.phone())){
            throw new PhoneAlreadyExistsException();
        }




    }

}
