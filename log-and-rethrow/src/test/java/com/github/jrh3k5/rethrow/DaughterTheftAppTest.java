package com.github.jrh3k5.rethrow;

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
