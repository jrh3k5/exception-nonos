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

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for {@link DaughterTheftApp}.
 * 
 * @author Joshua Hyde
 */

public class DaughterTheftAppTest {
    /**
     * Exercises the code to handle exceptions.
     * 
     * @throws Exception
     *             If any errors occur during the test run.
     */
    @Test
    public void testExceptionHandling() throws Exception {
        final JdbcHelper jdbcHelper = mock(JdbcHelper.class);
        when(jdbcHelper.executeQuery(anyString())).thenAnswer((InvocationOnMock invocation) -> {
            LoggerFactory.getLogger(DaughterTheftAppTest.class).error("A database error occurred!");
            throw new SQLException("A database error occurred!");
        });

        final DaughterTheftDao dao = new DaughterTheftDao(jdbcHelper);
        final DaughterTheftService service = new DaughterTheftService(dao);
        final DaughterTheftApp app = new DaughterTheftApp(service);

        app.kidnapMills();
    }
}
