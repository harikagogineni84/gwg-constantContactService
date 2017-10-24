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

## PushBulkContact API

### Request input

    {
      "accessToken": "accessToken",
      "bulkImportContacts": {<input as needed by constant contact bulk imports api>}
    }          

### Response returned
    {
    "id": "a07e1il97e1hddalkpk",
    "type": "ADD_CONTACTS",
    "error_count": 0,
    "contact_count": 3
    }

**Note** This can be tested using SOAPUI or RESTClient plugin using firefox/Chrome 

### Bulk Contact Payload Example

    {
        "import_data": [{
            "email_addresses": [
                "user1@example.com"
            ],
            "first_name": "John",
            "last_name": "Smith",
            "birthday_month":"1",
            "birthday_day":"25",
            "anniversary":"03/12/2005",
            "job_title": "",
            "company_name": "My Company",
            "home_phone": "5555551212",
            "addresses": [{
                "line1": "123 Partridge Lane",
                "line2": "Apt. 3",
                "city": "Anytown",
                "address_type": "PERSONAL",
                "state_code": "NH",
                "country_code": "US",
                "postal_code": "02145"
            }]
        },
        {
            "email_addresses": [
                "user2@example.com"
            ],
            "first_name": "Jane",
            "last_name": "Doe",
            "job_title": "",
            "company_name": "Acme, Inc.",
            "home_phone": "5555551213",
            "addresses": [{
                "line1": "456 Jones Road",
                "city": "AnyTownShip",
                "address_type": "PERSONAL",
                "state_code": "DE",
                "country_code": "US",
                "postal_code": "01234"
            }],
            "custom_fields": [{
                "name": "Custom Field 6",
                "value": "Blue Jeans"
            }, {
                "name": "Custom Field 12",
                "value": "Special Order"
            }]
        }, {
            "email_addresses": [
                "user3@example.com"
            ],
            "first_name": "Pradeep",
            "last_name": "Patel",
            "job_title": "",
            "company_name": "Acme Movers",
            "home_phone": "5555551214"
        }],
        "contactNames": [ //contact list names to which the above contact needs to be added??
                    "example1",
                    "example2",
                    "example3"
                ],
        "column_names": [
            "EMAIL",
            "FIRST NAME",
            "LAST NAME",
            "ADDRESS LINE 1",
            "ADDRESS LINE 2",
            "CITY",
            "STATE",
            "COUNTRY",
            "Zip/Postal Code",
            "JOB TITLE",
            "COMPANY NAME",
            "HOME PHONE",
            "Custom Field 6",
            "Custom Field 12"
        ]
    }

