package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Exception.CommunityNotExistsException;
import com.pierandrei.bludit.Exception.UserIsMemberOfTheCommunityException;
import com.pierandrei.bludit.Exception.UserNotExistsException;
import com.pierandrei.bludit.Model.Community;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.CommunityRepository;
import com.pierandrei.bludit.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;


    // Changing user biography
    @Transactional
    private String changeTheBiography(User user, String biography){
        if (user == null){
            throw new UserNotExistsException();
        }

        user.setBiography(biography);
        this.userRepository.save(user);
        return "Biography changed!";
    }



    // Join the community
    private String joinTheCommunity(User user, Community community){

        if (user == null) throw new UserNotExistsException();
        if (community == null) throw new CommunityNotExistsException();


        if (community.getListMembers().contains(user)) throw new UserIsMemberOfTheCommunityException();

        if (!community.isPublic()){
               List<User> usersRequests = community.getListOfRequests();
               usersRequests.add(user);
               community.setListOfRequests(usersRequests);
               this.communityRepository.save(community);
               return "Solicitação enviada para "+ community.getName();

        }else{
            List<User> members = community.getListMembers();
            members.add(user);
            community.setListMembers(members);
            this.communityRepository.save(community);
            return "Você entrou na comunidade "+ community.getName();

        }
    }


}
