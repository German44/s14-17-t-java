package com.domain.groupsUser;

import java.util.List;
import com.dto.GroupsUserModel;

public interface GroupsUserService {

    GroupsUserModel createGroupsUser(GroupsUserModel groupsUserModel);
    GroupsUserModel updateGroupsUser(Long groupsUserId, GroupsUserModel groupsUserModel);

    GroupsUserModel getGroupsUserById(Long id);
    List<GroupsUserModel> getAllGroupsUser();

    void deleteGroupsUser(Long groupsUserId);
}
