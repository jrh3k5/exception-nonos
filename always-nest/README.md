# Always Nest

This is a project that demonstrates what happens when you don't nest your caught exceptions as the cause of the exceptions that you throw.

This project leverages a test that randomly selects from a list of turtles a turtle that will fail when it tries to move a given `Universe` object.

If you leave line 44 of `Turtle.java` uncommented, then you will only receive an exception stacktrace of:

```
com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:44)
    at com.github.jrh3k5.nest.UniverseTest.testNonNestedException(UniverseTest.java:44)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)
    at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)
```

However, if you un-comment line 45 of `Turtle.java` and comment out line 44, you get a much more helpful stacktrace that identifies which turtle in the list failed:

```
com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.UniverseTest.testNonNestedException(UniverseTest.java:44)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)
    at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
    at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 24 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 25 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 26 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 27 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 28 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:45)
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 29 more
Caused by: com.github.jrh3k5.nest.MoveException: Kaboom!
    at com.github.jrh3k5.nest.Turtle.move(Turtle.java:42)
    ... 30 more
```

This example is arbitrary, but it demonstrates the importance of nesting your caught exceptions as the cause of your thrown exception: erasing the trail of exceptions hides the causes of errors and makes it much more difficult to identify where the error occurred in your code.