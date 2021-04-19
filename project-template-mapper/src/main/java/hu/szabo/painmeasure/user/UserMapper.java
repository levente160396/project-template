package hu.szabo.painmeasure.user;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDisplayVO userToUserDisplayVO(User user);

	List<UserDisplayVO> usersToUserDisplayVos(List<User> users);

	User userSaveVOToUser(UserSaveVO userSaveVO);

	UserSaveVO userToUserSaveVO(User user);
}
