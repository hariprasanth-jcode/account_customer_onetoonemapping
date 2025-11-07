package com.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Connection {

	
	public static EntityManager getEntityManager() {
		return Persistence
				.createEntityManagerFactory("postgres")
				.createEntityManager();
	}
}
