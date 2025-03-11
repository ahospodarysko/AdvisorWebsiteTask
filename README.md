# AdvisorWebsiteTask - Client task to demonstrate Java/Selenium skills

Tools needed to run tests:

1. Download Java jdk
-https://www.oracle.com/technetwork/java/javase/downloads/

2. Setup JAVA HOME
Windows 10 - https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/
Mac OS - https://www.mkyong.com/java/how-to-set-java_home-environment-variable-on-mac-os-x/

3. Download Maven (binary archive)
-https://maven.apache.org/download.cgi

4. Setup MAVEN_HOME
Windows - https://www.mkyong.com/maven/how-to-install-maven-in-windows/
Mac OS - https://www.mkyong.com/maven/install-maven-on-mac-osx/

5. Download and install chrome and(or) firefox browsers
Chrome - https://www.google.com/chrome/
Firefox - https://www.mozilla.org/en-US/firefox/new/

How to run tests:

Download project from git, unzip it.

(Run test from command line with maven)
1. Go to project directory
2. Run command line(windows) or terminal(mac os)
3. Type command:
    # Run all tests:
    - mvn clean test

    # Run a single test class.
    - mvn clean -Dtest=YourClassName test

     # Run a single test package.
    - mvn clean -Dtest=yourpackage.* test

    # Run different browser.
    - mvn clean -Dbrowser=chrome test
    - mvn clean -Dbrowser=firefox test

Example:
    - mvn clean -Dbrowser=chrome test
