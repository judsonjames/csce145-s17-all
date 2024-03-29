package movie_database;

public class MovieDatabaseBackEnd {
  
  private Movie[] movies = new Movie[10];
  private static final String FILE_NAME = "database_file.txt";
  
  public MovieDatabaseBackEnd() {
    for (int i = 0; i < movies.length; ++i) {
      movies[i] = null;
    }
  }
  
  public void addMovie(Movie aMovie) {
    int i = 0;
    for (i = 0; movies[i] != null; ++i);
    movies[i] = aMovie;
  }
  
  public void removeMovie (String aName) {
    int i = 0;
    while (movies[i].getName().equalsIgnoreCase(aName) == false) {
      ++i;
    }
    movies[i] = null;
    
    // Remember to move everything forward to prevent null pointers.
    for (i = 0; movies[i] != null && i < movies.length - 2; ++i) {
      if (movies[i+1] != null && movies[i+2] == null) {
        movies[i+1] = movies[i+2];
        movies[i+2] = null;
      }
    }
  }
  
  public void printToFile() {
    MovieFileIO.printToFile(movies);
  }
  
  public void readFromFile() {
    movies = MovieFileIO.readFromFile(FILE_NAME);
  }
  
  public void sortByTitle() {
    int shorterLength = 0;
    
    for (int i = 0; movies[i] != null; ++i) {
      // if the first letter is greater numerically than the
      // second number shift the second one in place of the first.
      if (movies[i].getName().charAt(0) 
          > movies[i+1].getName().charAt(0)) {
        Movie temp = movies[i];
        movies[i] = movies[i+1];
        movies[i+1] = temp;
      }

      // else if the first letters of each title are identical
      // we have to run through the String and find the next char
      // that is not identical in each string. 
      else if (movies[i].getName().charAt(0) 
          == movies[i+1].getName().charAt(0)) {
        if (movies[i].getName().length() 
            > movies[i+1].getName().length()) {
          shorterLength = movies[i+1].getName().length();
        }
        else if (movies[i].getName().length() 
            < movies[i+1].getName().length()) {
          shorterLength = movies[i].getName().length();
        }
      }
      
      // now we have to go through the rest of the names to determine
      // the lower one alphabetically (using Unicode)
      for (int j = 1; j < shorterLength; ++j) {
        if (movies[i].getName().charAt(j) 
            > movies[i+1].getName().charAt(j)) {
          Movie temp = movies[i];
          movies[i] = movies[i+1];
          movies[i+1] = temp;
          break;
        }
        else if (movies[i].getName().charAt(j) 
            < movies[i+1].getName().charAt(j)) {
          Movie temp = movies[i];
          movies[i] = movies[i+1];
          movies[i+1] = temp;
          break;
        }
      }
    } // end of sorting
  } // end of sortByTitle()
  
  public void sortByRating() {
    
  }
  
  public void sortByGross() {
    
  }
  
  public void showByDirector() {
    
  }
} // end of MovieDatabaseBackEnd
