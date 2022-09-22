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
LW_CLIENT_ID=your-client-id LW_CLIENT_SECRET=your-client-secret node path_to_sample
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
