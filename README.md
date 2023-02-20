# languageweaver-sdk-samples

## JavaScript SDK - Node.JS samples
### Requirements
The JavaScript SDK samples require Node.js and npm to be installed.<br/>
We strongly recommend using a Node version manager like [nvm](https://github.com/nvm-sh/nvm) to install Node.js and npm. </br>
All other dependencies can be installed using the following command:
```
npm install
```
### Configuration
You need to set up your API Credentials in order to run the samples. You can do this by creating a file named .env in the **javascript** directory and add your credentials:
```
LW_CLIENT_ID=your-client-id
LW_CLIENT_SECRET=your-client-secret
```
The credentials can also be defined directly in the command line.
```
LW_CLIENT_ID=your-client-id LW_CLIENT_SECRET=your-client-secret node path_to_sample // MacOS and Linux
set LW_CLIENT_ID=your-client-id&& set LW_CLIENT_SECRET=your-client-secret&& node path_to_sample // Windows
```
### Running the Node.JS samples
Run the following command:
```
node path_to_sample
```
where path_to_sample is the relative path to the sample you want to run. </br>
E.g.:
```
node samples/translations/text/TextTranslationService.js
```

## JavaScript SDK - Browser samples
### Requirements
The JavaScript SDK samples require Node.js and npm to be installed.<br/>
We strongly recommend using a Node version manager like [nvm](https://github.com/nvm-sh/nvm) to install Node.js and npm. </br>
All other dependencies can be installed using the following command:
```
npm install
```
### Running the browser samples
Run the following command to start the React application:
```
npm start
```
Set your API credentials in the fields displayed at the top of the page. </br>
Choose the code sample that you want to run. </br>
The response will be available in the browser console.

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

## .Net SDK samples
### Requirements
The .Net SDK samples require a valid [.Net Runtime](https://dotnet.microsoft.com/en-us/download) installation as well as the [nuget package manager](https://www.nuget.org/downloads) to be installed.<br/>
The project dependencies can then be installed using the following command:
```
nuget restore
```
### Configuration
You need to set up your API Credentials in order to run the samples as environment variables.
```
LW_CLIENT_ID=your-client-id
LW_CLIENT_SECRET=your-client-secret
```
These can be set in the `Properties/launchSettings.json` file as follows:
```json
"environmentVariables": {
    "LW_CLIENT_ID": "your-client-id",
    "LW_CLIENT_SECRET": "your-client-secret",
    "LW_EDGE_OVERWRITE_URL": "your-edge-overwrite-url",
    "LW_PRODUCT" : "CLOUD"
}
```
### Running the .Net samples
Running the following command will execute the main class defined in the `dotnet.csproj` file, where the StartupObject property is specified:
```
dotnet run
```
```xml
<PropertyGroup>
        <StartupObject>LanguageWeaver.Sdk.Samples.Dictionaries.CloudDictionaryService</StartupObject>
</PropertyGroup>
```