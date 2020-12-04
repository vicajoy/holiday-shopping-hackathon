This repository has been designed for 
[Applitools Holiday Shopping Hackathon](https://applitools.com/hackathon-v20-3-instructions).

## Languages and Frameworks
The project uses the following languages and frameworks:
* Java 11 as the programming language
* TestNG as the test framework
* Selenium WebDriver as the web browser automation framework
* Apache Maven as the build automation tool
* WebDriverManager as the Selenium binaries manager
* Applitools Eyes SDK for visual testing

## Running Tests
* Applitools API Key has been stored in the system environment variables.
* To run the tests on the specific version, use the following command:   
`mvn clean test -Durl="https://demo.applitools.com/tlcHackathonMasterV1.html"`.  
Acceptable versions are: [V1 production version](https://demo.applitools.com/tlcHackathonMasterV1.html), 
[Dev-branch version](https://demo.applitools.com/tlcHackathonDev.html), and [Final production version](https://demo.applitools.com/tlcHackathonMasterV2.html).

## Author
Vica Markosyan