package hu.szabo.painmeasure.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapperImplTest {

//	@Override
//	public UserDisplayVO userToUserDisplayVO(User user) {
//
//		UserDisplayVO userDisplayVO = new UserDisplayVO();
//
//		userDisplayVO.setId(user.getId());
//		userDisplayVO.setUsername(user.getUsername());
//		userDisplayVO.setFirstName(user.getFirstName());
//		userDisplayVO.setLastName(user.getLastName());
//		userDisplayVO.setEmail(user.getEmail());
//		userDisplayVO.setIsActive(user.getIsActive());
//		userDisplayVO.setRole(user.getRole());
//		userDisplayVO.setLastLogin(user.getLastLogin());
//
//		return userDisplayVO;
//	}
//
//	@Override
//	public List<UserDisplayVO> usersToUserDisplayVos(List<User> users) {
//		List<UserDisplayVO> results = new ArrayList<>(users.size());
//
//		for (User user : users) {
//			UserDisplayVO userDisplayVO = new UserDisplayVO();
//			userDisplayVO.setId(user.getId());
//			userDisplayVO.setUsername(user.getUsername());
//			userDisplayVO.setFirstName(user.getFirstName());
//			userDisplayVO.setLastName(user.getLastName());
//			userDisplayVO.setEmail(user.getEmail());
//			userDisplayVO.setIsActive(user.getIsActive());
//			userDisplayVO.setRole(user.getRole());
//			userDisplayVO.setLastLogin(user.getLastLogin());
//
//			results.add(userDisplayVO);
//		}
//
//		return results;
//	}
//
//	@Override
//	public User userSaveVOToUser(UserSaveVO userSaveVO) {
//		User user = new User();
//
//		user.setId(userSaveVO.getModifyId());
//		user.setUsername(userSaveVO.getUsername());
//		user.setFirstName(userSaveVO.getFirstName());
//		user.setLastName(userSaveVO.getLastName());
//		user.setEmail(userSaveVO.getEmail());
//		
//		if (null == userSaveVO.getModifyId()) {
//			user.setPassword(new BCryptPasswordEncoder().encode(userSaveVO.getPassword()));
//		}
//		
//		user.setIsActive(userSaveVO.getIsActive());
//		user.setRole(userSaveVO.getRole());
//		user.setLastLogin(userSaveVO.getLastLogin());
//
//		return user;
//	}
//
//	@Override
//	public UserSaveVO userToUserSaveVO(User user) {
//		UserSaveVO userSaveVO = new UserSaveVO();
//
//		userSaveVO.setModifyId(user.getId());
//		userSaveVO.setUsername(user.getUsername());
//		userSaveVO.setFirstName(user.getFirstName());
//		userSaveVO.setLastName(user.getLastName());
//		userSaveVO.setEmail(user.getEmail());
//		userSaveVO.setIsActive(user.getIsActive());
//		userSaveVO.setRole(user.getRole());
//		userSaveVO.setLastLogin(user.getLastLogin());
//		
//		return userSaveVO;
//	}
}
