package hu.szabo.painmeasure.account;

import hu.szabo.painmeasure.user.Role;
import hu.szabo.painmeasure.user.UserDisplayVO;

public interface AccountService {

	Role getRoleByUserName(String name);

	UserDisplayVO getUserDisplayVOByUserName(String username);
}
