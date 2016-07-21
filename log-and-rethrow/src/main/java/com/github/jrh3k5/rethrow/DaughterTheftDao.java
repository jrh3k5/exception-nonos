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
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A DAO for handling the theft of a daughter.
 * 
 * @author Joshua Hyde
 */

public class DaughterTheftDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DaughterTheftDao.class);
    private final JdbcHelper jdbcHelper;

    /**
     * Create a DAO.
     * 
     * @param jdbcHelper
     *            A {@link JdbcHelper} used to execute JDBC commands.
     * @throws NullPointerException
     *             If the given helper is {@code null}.
     */
    public DaughterTheftDao(JdbcHelper jdbcHelper) {
        this.jdbcHelper = Objects.requireNonNull(jdbcHelper, "JDBC helper cannot be null.");
    }

    /**
     * Kidnap a daughter from a family.
     * 
     * @param family
     *            The {@link Family} from which a daughter is to be kidnapped.
     * @throws UnexpectedLiamNeesonException
     *             If a Liam Neeson is unexpectedly encountered during the kidnapping.
     */
    public void kidnap(Family family) throws UnexpectedLiamNeesonException {
        try {
            jdbcHelper.executeQuery("UPDATE DAUGHTER SET KIDNAPPED = 1 WHERE FAMILY = '" + family + "'");
        } catch (SQLException e) {
            LOGGER.error("Unexpected Liam Neeson error for family: {}", family, e);
            throw new UnexpectedLiamNeesonException("Unexpected Liam Neeson discovered for family: " + family, e);
        }
    }

    /**
     * An exception to indicate that an unexpected Liam Neeson was encountered.
     * 
     * @author Joshua Hyde
     */
    public static class UnexpectedLiamNeesonException extends Exception {
        private static final long serialVersionUID = -8250932072049861485L;

        /**
         * Create an exception.
         * 
         * @param message
         *            The message of the exception.
         * @param cause
         *            The cause of the exception.
         */
        public UnexpectedLiamNeesonException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
