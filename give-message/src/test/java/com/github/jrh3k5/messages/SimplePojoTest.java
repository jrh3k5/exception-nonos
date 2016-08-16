package com.github.jrh3k5.messages;

/*-
 * #%L
 * give-message
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@link SimplePojo}.
 * 
 * @author Joshua Hyde
 */

public class SimplePojoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePojoTest.class);

    /**
     * Test the construction that throws an NPE.
     */
    @Test
    public void testNullPointerException() {
        NullPointerException caught = null;
        try {
            new SimplePojo("test", null);
        } catch (NullPointerException e) {
            caught = e;
        }
        assertThat(caught).isNotNull();
        LOGGER.info("Encountered error as expected.", caught);
    }
}
