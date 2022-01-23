# Locks Management
A sample Android application is made in Kotlin to demonstrate the implementation of MVVM with Clean Architecture.

The application fetches the Locks list from the [SampleAPI](https://simonsvoss-homework.herokuapp.com/sv_lsm_data.json) and stores them in a local database. Data is always displayed using the Single Source of Truth principle which is SQLite Database.

- Data refresh policy: ***Once a day***

# Used Libraries
 - ***Dagger Hilt*** - Used for Dependency Injection.
 - ***Retrofit*** - Used to make easier Network API calls.
 - ***Coroutines*** - For managing long running or network tasks off the main thread.
 - ***GSON*** - A converter for JSON Serialization.
 - ***ViewModel*** - Stores and manages UI related data in a lifecycle aware way.
 - ***Room*** - Used for persistent storage in Android.
 - ***DataStore*** - Used for SharePreferences in Android.
 
 # Screen Shots
Loading  | Locks List  | Serach and Highlight
------------- | -------------  | -------------
![Screenshot_1642950080](https://user-images.githubusercontent.com/50651962/150685909-71465f71-c43c-4358-9fdb-f95faa706a2c.png)|![Screenshot_1642949960](https://user-images.githubusercontent.com/50651962/150685916-a106e241-d7ea-4f4e-95a8-188a7b322f62.png)|![Screenshot_1642950115](https://user-images.githubusercontent.com/50651962/150685921-c1e85ae3-447c-4670-aecc-bc63642a4551.png)
