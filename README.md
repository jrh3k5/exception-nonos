# Exception No-No's

This project contains a collection of projects demonstrating "no-no"s to avoid when handling exceptions in your application.

The available projects are:

* [log-and-rethrow](./log-and-rethrow): A project demonstrating the flaws of the "log and rethrow" anti-pattern
* [always-nested](./always-nest): A project demonstrating why it's important to always nest your caught exceptions as the cause of the exception you are throwing

This project assumes a Maven organization and requires Java 8.
