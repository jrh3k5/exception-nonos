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

import java.util.Objects;

/**
 * A simple, plain old Java object.
 * 
 * @author Joshua Hyde
 */

public class SimplePojo {
    private final String string;
    private final Integer integer;

    /**
     * Create a POJO.
     * 
     * @param string
     *            The string.
     * @param integer
     *            The integer.
     */
    public SimplePojo(String string, Integer integer) {
        this.string = Objects.requireNonNull(string);
        this.integer = Objects.requireNonNull(integer);
    }

    /**
     * Builds the value.
     * 
     * @return The value.
     */
    public String buildValue() {
        return String.format("%s-%d", string, integer);
    }
}
