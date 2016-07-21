package com.github.jrh3k5.rethrow;

/*-
 * #%L
 * Log and Rethrow
 * %%
 * Copyright (C) 2016 jrh3k5
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
