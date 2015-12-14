
In order to run the tests, you will need to install [Apache Maven](http://maven.apache.org),
and Appium (according to the Appium [installation instructions](https://github.com/appium/appium).

You will then need to start appium

To compile and run all tests, run:

    mvn clean test

To run a single test, run:

    mvn -Dtest=wav.ios.test.AutomatingKinokeiOSTest test
    
To run on sauce:

   mvn -Dsauce=true clean test