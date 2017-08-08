package com.mindworx.dao;

import com.mindworx.model.Admin;

public interface AdminDao {
	public Admin getByLoginId(String custLogin);
}
