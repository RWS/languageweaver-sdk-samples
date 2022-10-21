## Java SDK samples

### Requirements
The Java SDK samples require a valid JDK setup as well as the [maven](https://maven.apache.org/install.html) dependency management tool to be installed.<br/>
The project dependencies can then be installed using the following command:
```shell
mvn clean compile
```
### Configuration
You need to set up your API Credentials as environment variables in order to run the samples. These should be set according to your operating system.
```
LW_CLIENT_ID=your-client-id
LW_CLIENT_SECRET=your-client-secret
```
### Running the Java samples
We advise using an IDE like [Intellij IDEA](https://www.jetbrains.com/idea/) in order to run the samples faster and more easily. </br>
If you want to run the samples from the command line, the following commands should be used:
```shell
mvn clean compile
mvn exec:java -Dexec.mainClass=com.languageweaver.sdk.samples.dictionaries.CloudDictionaryService
```
where the desired sample to be run can be set using the `-Dexec.mainClass` property.