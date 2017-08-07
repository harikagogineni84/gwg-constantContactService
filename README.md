# Constant Contact to SQL DB Service API

This service exists as a middle tier to push an incoming payload from a SQL DB, to Constant contact's mashery API. The goal is to have a single addressable service which can take in a JSON string and allow an external contact management service to sync with Constant Contact.

Constant contact's REST API is managed by Mashery, so any references to MAshery are in the context of passing data to Constant contact in that manner.

## Installation Instructions

You can install gwg-constantContactService by simply running clean install with maven. Once the artifacts for the project have been obtained, simply run the project as a Spring Boot app in Eclipse or Intellij IDEA, or by running

`$  java -jar target/gwg-constantcontactservice-0.0.1-SNAPSHOT.jar`

In your terminal.

## Configuration

The project also needs to be configured, or you will not be able to pass any data to a live Constant Contact account. You need to obtain both an API key and Access token from mashery/constant contact before you can proceed.

[More information on obtaining your API key and Access token for your Account can be found here.](https://developer.constantcontact.com/api-keys.html)

### Cliff notes version

1. [sign up for Mashery](https://constantcontact.mashery.com/member/register) (the official API provider for constant contact)
2. Generate your public and private key and store them somewhere safe
3. [Enter your API key here and then choose "get access token"](https://constantcontact.mashery.com/io-docs)
4. Log in using your **Constant Contact** credentials
5. Obtain and save your Access token
