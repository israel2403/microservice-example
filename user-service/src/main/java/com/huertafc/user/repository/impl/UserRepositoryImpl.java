package com.huertafc.user.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.huertafc.user.entity.User;
import com.huertafc.user.repository.AbstractJpaDAO;
import com.huertafc.user.repository.UserResository;

@Repository
@EnableTransactionManagement
public class UserRepositoryImpl extends AbstractJpaDAO<User> implements UserResository {

	public UserRepositoryImpl() {
		super(User.class);
	}

}
