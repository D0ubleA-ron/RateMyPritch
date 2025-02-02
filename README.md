# RateMyPritch

## What are we about?
Our project is a rating app for the Pritchard Dining Hall. We noticed that with the variety of food, it can often times be confusing as to what to pick and which foods fit dietary restrictions. Our rating app aims to ease those concerns, with a few clicks of a button, you can rate Pritchard items to see which ones are the right fit for you!

## How to run the code?
Our code's final product will be an APK file that can run on android devices. Currently, we are using Android Studio's mobile device emulator to emulate a real phone as we make adjustments to the app.

## What we've done so far?
We worked through the implementation of the interaction between pages that we first designed on Figma. Once we were happy with our UI design, we divided the work between team members to design the XML pages and then worked on its implementation. 

However, from our last design, we didn't have a proper system for login/signup as well as the review database system. We also just had one dish that is a Pritchard usual that was being reviewed and saved using intents from Android Studios.

In this verison of our project, we worked through the database systems for the login/signup, webscraping through the NutriSlice for the daily menu items, and working through the database connection for the review system. We researched and learnt more about database systems using SQLite and MySQl for both the databases and __ for the webscraping.

**List of Features worked on for this version:**
- Login/Signup Database System
  Used SQLite to stores the signup information and allows users to login to make reviews. Information is stored on the database and can be accessed even once the program is reopened. Implemented via the DBHelper class created.
  
  Sample outputs for the Login System -

  <img src = "https://user-images.githubusercontent.com/69047981/201797430-429c9232-1f3f-4b24-9e3f-27fe1960ca4b.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797446-6ee10842-7aa5-4837-8a4b-865d394cbd6f.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797468-d296c17f-776b-4e71-b47c-5e533e25916c.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797474-01de3bd2-c894-453b-9ad4-acce60fbbdf7.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797483-b34b5112-0ac8-4708-812b-d3adf0295a49.jpeg" width = "170"/>

  
- Database System for the Reviews to be stored
  Added functions to the DBHelper to store the reviews that users make such as getReviewtop() and getReviewbot(). The review either contains stars for scores or stars along with the comments. This information is stored in the database that can be accessed by its unique ratingId. Also created a for loop to have the latest ratings on the top of the list of menu items.
  
  Sample outputs for the Review System -
  
  <img src = "https://user-images.githubusercontent.com/48756230/201819395-ce065a61-78df-4e6b-b1c6-fb7fd52224d5.jpeg" width = "400"/>
  <img src = "https://user-images.githubusercontent.com/48756230/201819397-cb2d46e3-129a-4f10-a140-f090ce561c88.jpeg" width = "400"/>
  <img src = "https://user-images.githubusercontent.com/48756230/201819399-805e8559-fdd2-4a4e-ae97-63dfd703230d.jpeg" width = "400"/>
  <img src = "https://user-images.githubusercontent.com/48756230/201819400-e11738ad-3690-4456-bdc4-881f1e279f5b.jpeg" width = "400"/>

  
- Webscraping Nutrislice
  Exported the Nutrislice website, and used open-sourced libraries to convert it into a csv file. Then, via SQL select statements the csv file strings are then extract the daily menu information into the User-Interface system for the users to then leave reviews on. 
  
  Sample outputs for the Webscraped Data -
  
## Things Added in the Individual Project

For my individual project I thought back to the core concept of why we made RateMyPritch, to serve the average student/user of our UBCO community. Therefore my goal was to add features that provided a service that would help the user. Using APIs I have decided to add the following features 

- Weather Conditions Display using the OpenWeatherMap API
  
  When I lived in first year residences the first thing I would do in the morning was go to Pritchard for breakfast. However, I often times did not know what they were serving nor the appropiate clothes to wear for the weather outside. Therefore, using the OpenWeatherAPI I was able to implement a feature that would tell the user the weather condition type (snowy, rainy, etc.) along with the temperature. I used JSON libraries and Android Volleys to make a request using the API key to return a JSON Array which I can then take JSON Objects from and translate to the appropiate data type to be displayed.


  Sample outputs for the OpenWeatherMap API - 
  
  <img src = "https://user-images.githubusercontent.com/77289762/205416529-2906deb0-cc4e-4b17-8be6-e0a3208a066a.png" width = "170" />

- Pritchard Location and Directions using the Google Maps API

  As a Residence Advisor I noticed that Pritchard is mainly frequented by first year students. I also noticed that first year students are not aware on how to navigate campus and therefore need assistance. Therefore using the Google Maps API and the Android Maps Library, I am able to create a feature that pinpoints the exact location of Pritchard on a map. Clicking the point allows the user to use Google Maps to find directions to Pritchard given their current location. This feature not only allows for a visual representation of where Pritchard is on campus, it also allows users audible and visible directions to Pritchard. This can be useful if the user is visually impaired or would rather put their phone away on their walk. Using the Android Maps library I also Street View button that gives a street view representation of the location.
  
  Sample outputs for the Google Maps API and Google Street View features (Google Street View has not been updated since 2012 however, this feature will work once Google updates their Street View)  - 
  
   <img src = "https://user-images.githubusercontent.com/77289762/205416176-df783c08-e84e-4e70-808b-22096d168d8b.png" width = "170" />
  
   Clicking the StreetViewButton - 
  
   <img src = "https://user-images.githubusercontent.com/77289762/205416260-e33a1f0f-34c6-47aa-9f3b-889c49d4ca02.png" width = "170" />

   Clicking the Take me to Pritchard Button - 
   
   <img src = "https://user-images.githubusercontent.com/77289762/205416367-b5dba8b1-c581-4f2e-b839-27fa9203412a.png" width = "170" />
   <img src = "https://user-images.githubusercontent.com/77289762/205416375-7dba74e1-3902-4e7f-8d3b-66cbb1e65c79.png" width = "170" />
   <img src = "https://user-images.githubusercontent.com/77289762/205416383-946fbf70-bc5e-4a96-b900-2fa414d55cd0.png" width = "170" />

  
## Class Organization
Our classes are organized by each unique page our users will encounter throughout their use of our app. 
Our classes are as follows:
- AssignReview (Assign reviews page)
- CurrentReviews (List of Current Reviews for a Particular Item)
- MainView (The apps homescreen which includes different departments, meal of the day, time and home and settings)
- LandingPage (Sign-up page with option to continue without signing up)
- My_Reviews (List of users current reviews as well as user control buttons)
- Sign_Up_Page (Sign up page)
- DepartmentalReviews (Reviews for different departments)
- RateMyPritchMap (map for finding pritchard with directions)
- StreetView (google streetview of pritchard)
