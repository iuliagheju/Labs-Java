public class Book {
    private String title;
    private double totalRating;  // Sum of all ratings received
    private int numberOfRatings;

    // Constructor
    public Book(String title) {
        this.title = title;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addRating(int rating) {
        totalRating += rating;
        numberOfRatings++;
    }

    public double getAverageRating() {
        return totalRating / numberOfRatings;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }
}
