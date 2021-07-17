# Quotes 

### its a web app that git for you a random quote on every run by tow way :
1- from an API 
2- from a JSON file 

*it contains with the following :*

* App class : which is the main of the web app that you run .
* Quote class : which is the model of how the view of the property of the quote.
* Quote class : using for  filter the data that comming from the API to save it in our JSON file .
* QuoteServece class : to deal with the main methods
## the main method in the app :
### for the first way to get the data from API , we used Tow method:
     * setConnectionAPI : to connect and get the api
     *setApiGson: to get the data from the api and save it on our JSON file

### for the second way , which it used just when the connection to the API failed:
     *ifConnectionWentWrong : to get the data(quotes) from our JSON file