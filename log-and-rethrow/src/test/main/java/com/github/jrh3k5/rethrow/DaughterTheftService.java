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

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jrh3k5.rethrow.DaughterTheftDao.UnexpectedLiamNeesonException;

/**
 * A service used to kidnap a daughter.
 * 
 * @author Joshua Hyde
 */

public class DaughterTheftService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DaughterTheftService.class);
    private final DaughterTheftDao dao;

    /**
     * Create a service.
     * 
     * @param dao
     *            The {@link DaughterTheftDao} to back the service.
     * @throws NullPointerException
     *             If the given DAO is {@code null}.
     */
    public DaughterTheftService(DaughterTheftDao dao) {
        this.dao = Objects.requireNonNull(dao, "Daughter theft DAO cannot be null.");
    }

    /**
     * Kidnap a member of a family.
     * 
     * @param family
     *            A {@link Family} enum representing the family whose member is to be kidnapped.
     * @throws AngryDadException
     *             If an angry father from the family is encountered.
     */
    public void kidnap(Family family) throws AngryDadException {
        try {
            dao.kidnap(family);
        } catch (UnexpectedLiamNeesonException e) {
            LOGGER.error("An unexpected Liam Neeson was encountered when kidnapping a member of the family {}", family,
                    e);
            throw new AngryDadException("He has a very specific set of skills.", e);
        }
    }

    /**
     * An exception to indicate that an angry dad was encountered.
     * 
     * @author Joshua Hyde
     */
    public static class AngryDadException extends Exception {
        private static final long serialVersionUID = -6098308587900799185L;

        /**
         * Create an exception.
         * 
         * @param message
         *            The message of the exception.
         * @param cause
         *            The cause of the exception.
         */
        public AngryDadException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
