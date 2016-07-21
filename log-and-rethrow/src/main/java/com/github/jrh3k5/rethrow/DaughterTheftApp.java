package com.github.jrh3k5.rethrow;

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
