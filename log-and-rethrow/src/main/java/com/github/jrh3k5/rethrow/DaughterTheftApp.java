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

import com.github.jrh3k5.rethrow.DaughterTheftService.AngryDadException;

/**
 * An application used to kidnap a daughter.
 * 
 * @author Joshua Hyde
 */

public class DaughterTheftApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(DaughterTheftApp.class);
    private final DaughterTheftService service;

    /**
     * Create an application.
     * 
     * @param service
     *            The {@link DaughterTheftService} to back the application.
     * @throws NullPointerException
     *             If the given service is {@code null}.
     */
    public DaughterTheftApp(DaughterTheftService service) {
        this.service = Objects.requireNonNull(service, "Daughter theft service cannot be null.");
    }

    /**
     * Kidnaps the Mills daughter.
     */
    public void kidnapMills() {
        try {
            service.kidnap(Family.MILLS);
        } catch (AngryDadException e) {
            LOGGER.error("Angry Mills father encountered.", e);
        }
    }
}
