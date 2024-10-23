public class User {
    private Book book;
    private Review[] reviews;
    private String username;

    // Constructor
    public User(String username, Book book, int numberOfReviews) {
        this.username = username;
        this.book = book;
        this.reviews = new Review[numberOfReviews]; // Array to hold Review objects
    }

    // Getter and Setter for username and book
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Book getBook() {
        return book;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void addReview(int index, Review newreview) {
        if (index < reviews.length) {
            reviews[index] = newreview;
        }
    }
}

