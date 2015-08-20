package edu.ganesh.ms.dao;

import java.util.List;

import edu.ganesh.ms.domain.UserLogin;

/**
 * @author Bharat
 *
 */
public interface UserDao {
	public void saveUser(UserLogin user);

	public void deleteUser(int id);

	public List<UserLogin> listAllUsers();

	public UserLogin getUserById(int id);

	public UserLogin getUserByUsername(String username);

	public UserLogin getUserByVerification(String code);
}
