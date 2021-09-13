# Canis Catalog 🐶

Canis Catalog is an Android app that allows the user to browse various dog breeds and check information about them. The data is provided by [The Dog API](https://thedogapi.com/).

This project has been developed for the SwordHealth Android Code Challenge.

## Setup
Clone the repository, checkout ```main```, build the project and you should be ready to go :)

You will need to provide your own API key for The Dog API.
This key must be placed in the ```local.properties``` file (if you don't have it, then please
create it in the root of project). Example of the file's content:
```
THE_DOG_API_KEY=YOUR_API_KEY_HERE
```
In case you need a key, please open an issue and I'll see what can be done.

## Features
 - Written in Kotlin
 - MVVM architecture (with a repository)
 - UI created using Jetpack Compose
 - Coil for image loading
 - API calls performed using Retrofit
 - Local data persistence with Room
 - Dependency injection with Hilt
 - Pagination for the Home screen implemented using Paging 3
 - LiveData for UI to consume the data from the ViewModel
 - Kotlin Coroutines for async operations

 ## TODO
 At the moment, there are still some things that need to be implemented/improved in this project which I'm aware of, mainly:
 1. Improve the offline mode (eventually, implementing a [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator) will be the ideal solution to ensure a proper "caching" solution is used and balance between using the remote/local data).
 2. Add code coverage (implement unit and integration tests)
 3. Improve the error handling logic/messages when getting data from the API
 4. UI can use some adjustments/polish (mainly the details page can use some extra work)
 5. Listen for network changes and update the UI accordingly (either show a message saying the app is offline or fetch the data in case the connection is established successfully)
 6. Add pagination support to the Search results
