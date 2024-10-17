package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Dto.Response.UserResponse;
import com.pierandrei.bludit.Exception.CommunityNotExistsException;
import com.pierandrei.bludit.Exception.UserIsMemberOfTheCommunityException;
import com.pierandrei.bludit.Exception.UserIsNotMemberOfTheCommunityException;
import com.pierandrei.bludit.Exception.UserNotExistsException;
import com.pierandrei.bludit.Model.Community;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.CommunityRepository;
import com.pierandrei.bludit.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;

    // ================== USER PART ================== //

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
            return "Solicitation send for "+ community.getName();

        }else{
            List<User> members = community.getListMembers();
            members.add(user);
            community.setListMembers(members);
            this.communityRepository.save(community);
            return "You joined in the community "+ community.getName();

        }
    }

    // Leave the community
    private String leaveTheCommunity(User user, Community community) {
        if (user == null) throw new UserNotExistsException();
        if (community == null) throw new CommunityNotExistsException();

        List<User> members = community.getListMembers();

        if (!members.contains(user)) {
            throw new UserIsNotMemberOfTheCommunityException();
        }


        members.remove(user);
        community.setListMembers(members);
        this.communityRepository.save(community);

        return "You left the community " + community.getName();
    }



    // ================== MODERATOR PART ================== //

    // Get all Users of the community
    private List<UserResponse> listAllUserOfCommunity(Community community){

    }








}
