package edu.ganesh.ms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ganesh.ms.dao.UserDao;
import edu.ganesh.ms.dao.util.ConnectionUtil;
import edu.ganesh.ms.domain.UserLogin;

/**
 * @author Bharat
 *
 */
@Repository
public class UserDaoImpl extends ConnectionUtil implements UserDao {

	@Override
	public void saveUser(UserLogin user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		UserLogin user = getUserById(id);
		if (user != null)
			getSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserLogin> listAllUsers() {
		return getSession().createQuery("FROM UserLogin").list();
	}

	@Override
	public UserLogin getUserById(int id) {
		return (UserLogin) getSession().get(UserLogin.class, id);
	}

	@Override
	public UserLogin getUserByUsername(String username) {
		return (UserLogin) getSession()
				.createQuery("SELECT u FROM UserLogin u WHERE u.username = ?")
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public UserLogin getUserByVerification(String code) {
		return (UserLogin) getSession()
				.createQuery(
						"SELECT u FROM UserLogin u WHERE u.verification = ?")
				.setParameter(0, code).uniqueResult();
	}

}
