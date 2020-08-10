# Movie Case

Movie case is a project that reads information from text documents on users and a movie library and recomends movies to a user
Origionaly made for submission to Experis

## Features

- Includes [Library](https://github.com/Dyroha/MovieCase/blob/master/src/dyroha/Classes/Library.java), [Movie](https://github.com/Dyroha/MovieCase/blob/master/src/dyroha/Classes/Movie.java) and [User](https://github.com/Dyroha/MovieCase/blob/master/src/dyroha/Classes/User.java) classes.
- Includes [MovieFileHandler](https://github.com/Dyroha/MovieCase/blob/master/src/dyroha/Handlers/MovieFileHandler.java) that read the User.txt, Products.txt and CurrentUserSession.txt files and creates the above objects.
- Includes [UserMovieRecomender](https://github.com/Dyroha/MovieCase/blob/master/src/dyroha/Handlers/UserMovieRecomender.java) that takes in a user and has functionality to recomend movies they would be interested in and haven't purchaced

## Comments

### General

#### Problems with creating Movie objects and reading the Products.txt file
The file format for a movie in the two given files Products.txt and README.txt are different. In the example it show every string in a line for a movie is seperated by a ", " like so:
```
id, name, year, keyword 1, keyword 2, keyword 3, keyword 4, keyword 5, rating, price
```
However in the Products.txt file there are fromated like this example:
```
1, All Is Lost,2013, Action, Adventure, Drama, , ,3.5,15
```
Where the first two items and all of the genres are seperated with ", ", but the other items are just seperated with a ",".
This made creating the movie object more tricky, and I could have split the elements up with just a "," and then deleted any blank spaces before the genres and names of the movies.
In the end however I decided not to as it made no difference functionally and it gave the printed out names of the movies a slight indent when listing them in the console which made it more plesent to read.
```
The highest rated movies currently are: 
 Dr. Terror's House of Horrors Rated: 5
 La La Land Rated: 4.9
 GoldenEye Rated: 4.8
```


### Possible additions

Recomend by most watched genre:
  - I started working on this but thought as it wasn't nessasary I would focus on the needed functionality

Add acctual Exception implimentation:
 - I also started on doing this but I am no too familiar with the java convention for doing so, so I thought I would add it when I am more researched on the topic

### Possible changes

Making the packages com.experis.PACKAGE_NAME to show the convention for naming, I decided not to do that as I uploaded this to [github](https://github.com/Dyroha/MovieCase) and though putting someone else's domain would be inpropper.
