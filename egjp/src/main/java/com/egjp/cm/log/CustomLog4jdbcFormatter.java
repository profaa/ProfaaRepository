package com.egjp.cm.log;

import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;

public class CustomLog4jdbcFormatter extends Log4JdbcCustomFormatter {
	@Override
	public void setSqlPrefix(String sqlPrefix) {
		super.setSqlPrefix(sqlPrefix + "\n");
    }
}
