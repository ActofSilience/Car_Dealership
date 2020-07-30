package com.dev.hagan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dev.hagan.models.Car;
import com.dev.hagan.models.Owned;

public interface OwnedDAO {
	public List<Owned> getOwned(String username);
	
}