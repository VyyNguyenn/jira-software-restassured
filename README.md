# jira-software-restassured

##Setup
1. Install JDK (Recommend JDK 8 or later version)
2. Install IDE (Recommend InteliJ https://www.jetbrains.com/idea/download/)
3. Install Allure commandline (use Homebrew for MacOS, Scoop for Windows)
4. Install dependencies: `mvn install`

###Run test
1. The tests can be found at src/test/java/com/testcases
2. To run test suite from terminal, use below command line
   `mvn clean test -DxmlSuite={suitepath}
   i.e `mvn clean test -DxmlSuite=src/test/java/testrunner/runTest.xml`

###Generate report
1. To generate Allure report, run below command `allure generate allure-results --clean -output allure-report`
