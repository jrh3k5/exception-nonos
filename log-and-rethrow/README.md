# Log and Rethrow

This project demonstrates the "log and rethrow" anti-pattern. An anti-pattern is, at its core, a pattern that, at first glimpse, appears to be a helpful and productive pattern, but ultimately turns out to be onerous or even outright destructive.

The "log and rethrow" pattern is innocently intending to give as much insight into the cause of an error as possible - this could be especially helpful in applications that tend to swallow and *never* log a caught exception.

However, the end result, more often than not, is a cluttered and jumbled log file repeating the same material, at successively higher parts of an application. This log can quickly become so jumbled to be on the verge (or driving with all wheels spinning hard) of being useless.

This project, when you execute the solitary unit test within it, will generated a `log4j.log` file in the `target/` directory beneath the project that demonstrates the pitfalls of this anti-pattern.
