package com.github.jrh3k5.rethrow;

import java.sql.SQLException;

/**
 * Definition of an arbitrary object that executes SQL.
 * 
 * @author Joshua Hyde
 */

public interface JdbcHelper {
    /**
     * Execute SQL.
     * 
     * @param sql
     *            The SQL to execute.
     * @return The result of the call.
     * @throws SQLException
     *             If any errors occur during the execution.
     */
    <T> T executeQuery(String sql) throws SQLException;
}
