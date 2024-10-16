package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Exception.UserNotExistsException;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Changing user biography
    private String changeTheBiography(User user, String biography){
        if (user == null){
            throw new UserNotExistsException();
        }

        user.setBiography(biography);
        this.userRepository.save(user);
        return "Biography changed!";
    }
}
