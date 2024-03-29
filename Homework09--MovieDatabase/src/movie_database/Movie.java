package movie_database;

public class Movie {
  private String name;
  private int year;
  private int rating;
  private String director;
  private double boxOfficeGross;
  
  public Movie () {
    this.name = "";
    this.year = 0;
    this.rating = 0;
    this.director = "";
    this.boxOfficeGross = 0.0;
  }
  
  public Movie (String aName, int aYear, int aRating,
      String aDirector, double aBOG) {
    setName(aName);
    setYear(aYear);
    setRating(aRating);
    setDirector(aDirector);
    setBoxOfficeGross(aBOG);
  }

  public String getName() {
    return name;
  }

  public int getYear() {
    return year;
  }

  public int getRating() {
    return rating;
  }

  public String getDirector() {
    return director;
  }

  public double getBoxOfficeGross() {
    return boxOfficeGross;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setYear(int year) {
    if (year > 0) {
      this.year = year;
    }
  }

  public void setRating(int rating) {
    if (rating > 0 && rating < 6) {
      this.rating = rating;
    }
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setBoxOfficeGross(double boxOfficeGross) {
    if (boxOfficeGross > 0) {
      this.boxOfficeGross = boxOfficeGross;
    }
  }
}
