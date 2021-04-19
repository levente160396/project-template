package hu.szabo.painmeasure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u.username FROM User u WHERE u.username=:username")
	String findByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findUserByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	User findUserByEmail(@Param("email") String email);

	@Query("SELECT u FROM User u WHERE u.username=:username")
	User getUserByUsername(@Param("username") String username);

	@Query("SELECT u.role FROM User u WHERE u.username=:username")
	Role getRoleByUsername(@Param("username") String username);
}
