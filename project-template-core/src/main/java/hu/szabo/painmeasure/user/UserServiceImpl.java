package hu.szabo.painmeasure.user;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Szabó Levente
 *
 *         Create save and update user service.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserDisplayVO> findAllUsers() {

		List<User> users = userRepository.findAll();

		if (CollectionUtils.isEmpty(users)) {
			Collections.emptyList();
		}

		return UserMapper.INSTANCE.usersToUserDisplayVos(users);
	}

	@Override
	public void saveUser(UserSaveVO userSaveVO) {

		userRepository.save(UserMapper.INSTANCE.userSaveVOToUser(userSaveVO));
	}

	@Override
	public UserSaveVO findUserSaveVOByUserId(Long userId) {
		Optional<User> userById = userRepository.findById(userId);

		if (userById.isPresent()) {
			return UserMapper.INSTANCE.userToUserSaveVO(userById.get());
		}

		return new UserSaveVO();
	}

	@Override
	public void deleteUserById(Long userId) {

		userRepository.deleteById(userId);
	}

	@Override
	public Boolean findByUsername(String username) {

		if (null != userRepository.findByUsername(username)) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	public Boolean checkOldPassword(String oldPassword, Long currentUserId) {

		Optional<User> findUserById = userRepository.findById(currentUserId);

		if (!findUserById.isPresent()) {
			return Boolean.FALSE;
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (encoder.matches(oldPassword, findUserById.get().getPassword())) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	@Override
	public void saveNewPassword(String firstNewPassword, Long userId) {
		Optional<User> findUserById = userRepository.findById(userId);

		if (!findUserById.isPresent()) {
			return;
		}

		findUserById.get().setPassword(new BCryptPasswordEncoder().encode(firstNewPassword));
		findUserById.get().setLastLogin(new Date());
		userRepository.save(findUserById.get());
	}

	@Override
	public boolean isUsernameExist(String username) {
		
		return !StringUtils.isEmpty(userRepository.findByUsername(username));
	}

	@Override
	public boolean isEmailExist(String email) {
		
		return null != userRepository.findUserByEmail(email);
	}
}
