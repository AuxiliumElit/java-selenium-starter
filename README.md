# java-selenium-starter
Java and Selenium base Test Automation Framework. Best examples, demo and practice

TestNG Execution commands:
Run Regression Test Suite via CMD:
mvn test -P RegressionTest -Dbrowser=edge
Run Regression Test Suite via CMD in headless mode:
mvn test -P RegressionTest -Dbrowser=chrome_headless
Run Smoke Test Suite via CMD:
mvn test -P SmokeTest -Dbrowser=chrome

Cucumber BDD Execution commands:
To run Features you need clean target folder after each change and run TestNGTestRunner class
Run Test Suite via CMD:
mvn test -P CucumberTest -Dbrowser=edge
(Specific Tag should be integrated in .pom Profile
and specified in TestNGTestRunner class)

JUit Execution Commands:
First, if we want to use the native JUnit 5 support of the Maven Surefire Plugin,
we must ensure that at least one test engine implementation is found from the classpath.
That's why we ensured that the junit-jupiter-engine dependency is found from the classpath
when we configured the dependencies of our Maven build.

Second, if we use the default configuration of the Maven Surefire Plugin,
it runs all test methods found from a test class if the name of the test class:
Starts or ends with the string: Test.
Ends with the string: Tests.
Ends with the string: TestCase.

Run all test cases:
mvn clean test
Run Regression Test Suite via CMD:
mvn test -Dgroups=Regression -Dbrowser=edge
Run Regression Test Suite via CMD in headless mode:
mvn test -Dgroups=Regression -Dbrowser=chrome_headless
Run Smoke Test Suite via CMD:
mvn test -Dgroups=Smoke -Dbrowser=chrome
