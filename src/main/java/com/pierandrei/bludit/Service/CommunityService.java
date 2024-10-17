package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Dto.Response.PostResponse;
import com.pierandrei.bludit.Dto.Response.UserResponse;
import com.pierandrei.bludit.Exception.CommunityExceptions.CommunityNotExistsException;
import com.pierandrei.bludit.Exception.CommunityExceptions.PostIsApprovedException;
import com.pierandrei.bludit.Exception.CommunityExceptions.UserIsMemberOfTheCommunityException;
import com.pierandrei.bludit.Exception.CommunityExceptions.UserIsNotMemberOfTheCommunityException;
import com.pierandrei.bludit.Exception.UserException.UserNotExistsException;
import com.pierandrei.bludit.Model.Community.Community;
import com.pierandrei.bludit.Model.Community.Posts;
import com.pierandrei.bludit.Model.User;
import com.pierandrei.bludit.Repository.CommunityRepository;
import com.pierandrei.bludit.Repository.PostRepository;
import com.pierandrei.bludit.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
    private final PostRepository postRepository;

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
    private List<UserResponse> listAllUserOfCommunity(Community community, int page, int size) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (community == null) throw new CommunityNotExistsException();


        List<User> members = community.getListMembers();


        Page<User> paginatedMembers = this.communityRepository.findListMembersByCommunity(community, pageable);


        List<UserResponse> response = paginatedMembers.stream()
                .map(user -> new UserResponse(user.getProfilePhotoUrl(), user.getUsername()))
                .collect(Collectors.toList());

        return response;
    }


    // Accept the post
    private PostResponse acceptThePost(Posts post, Community community, User moderator){
        if (community.getModerators() == null || !community.getModerators().contains(moderator)){
            throw new UserIsNotMemberOfTheCommunityException();
        }
        if (post.isApproved()) throw new PostIsApprovedException();

        post.setApproved(true);
        this.postRepository.save(post);

        return new PostResponse(post.getOwnerUser().getUsername(), post.getTitle(), LocalDateTime.now(), post.getContent());

    }






}
