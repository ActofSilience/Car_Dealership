package com.dev.hagan.service;

import java.util.List;

import com.dev.hagan.dao.OwnedDAO;
import com.dev.hagan.dao.OwnedDAOImpl;
import com.dev.hagan.models.Owned;

public class OwnedService {
	public static OwnedDAO od = new OwnedDAOImpl();

	public static List<Owned> getOwned(String username) {
		return od.getOwned(username);
	}
}
