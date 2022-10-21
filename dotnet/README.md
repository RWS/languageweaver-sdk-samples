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