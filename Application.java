import java.util.Arrays;
public class Application {
    private final inputDevice inputdevice;
    private final OutputDevice outputdevice;

    public Application(inputDevice input, OutputDevice output) {
        this.inputdevice = input;
        this.outputdevice = output;
    }

    public void run() {
        this.outputdevice.writeMessage("Application started");
        this.outputdevice.writeMessage("Today’s lucky numbers are: " + inputdevice.nextInt() + " and " + inputdevice.nextInt());
        playGame();
    }
    public void sortNumbers(int[] arr) {
        Arrays.sort(arr);
    }

    public  void randomArraySort(){
        int N=5;
        int[] arr = inputDevice.getNumbers(N);
        sortNumbers(arr);

    }
    protected int[] wordSizeHistogram(String sentence){
        int[] histogram = new int[7];
        String[] words = sentence.split("");

        for(String word : words){
            while(word.length() >= histogram.length){
                histogram = Arrays.copyOf(histogram, histogram.length+1);
            }
            histogram[word.length()] += 1;
        }
        return histogram;
    }
    // Add a review for the book
    public void addReview(int index, User user, String reviewText) {
        if (index >= user.getReviews().length) {
            outputdevice.writeMessage("Invalid index for review.");
        } else {
            Review newReview = new Review(reviewText);
            user.addReview(index, newReview);
            outputdevice.writeMessage("Review added for book: " + user.getBook().getTitle());
        }
    }

    public void displayUserReviews(User user) {
        outputdevice.writeMessage("Displaying reviews for user: " + user.getUsername());
        outputdevice.writeMessage("Book: " + user.getBook().getTitle());
        for (Review review : user.getReviews()) {
            if (review != null) {
                outputdevice.writeMessage("- " + review.getReviewText());
            }
        }
    }
    public void rateBook(User user, int rating) {
        Book book = user.getBook();
        if (rating >= 1 && rating <= 5) {  // Rating should be between 1 and 5
            book.addRating(rating);
            outputdevice.writeMessage("You rated \"" + book.getTitle() + "\" " + rating + " stars.");
        } else {
            outputdevice.writeMessage("Invalid rating. Please provide a rating between 1 and 5.");
        }
    }

    public void displayBookRating(User user) {
        Book book = user.getBook();
        double averageRating = book.getAverageRating();
        int numberOfRatings = book.getNumberOfRatings();

        if (numberOfRatings > 0) {
            outputdevice.writeMessage("The book \"" + book.getTitle() + "\" has an average rating of " + averageRating + " stars (" + numberOfRatings + " ratings).");
        } else {
            outputdevice.writeMessage("No ratings available for the book \"" + book.getTitle() + "\".");
        }
    }

    public void playGame() {
        int player1 = 0;
        int player2 = 0;

        while (player1 < 5 && player2 < 5) {
            int player1win = inputdevice.nextInt();
            int player2win = inputdevice.nextInt();

            outputdevice.writeMessage("Player 1 chose: " + player1win);
            outputdevice.writeMessage("Player 2 chose: " + player2win);

            if (player1win == player2win) {
                player1 += 2;
                player2 += 2;
                outputdevice.writeMessage("Both players chose the same number. Each gets 2 points.");
            } else {
                int highestnumber = Math.max(player1win, player2win);
                int lowestnumber = Math.min(player1win, player2win);

                if (highestnumber % lowestnumber == 0 && lowestnumber >= 10) {
                    if (highestnumber == player1win) {
                        player2++;
                        outputdevice.writeMessage("Player 2 wins this round by special rule.");
                    } else {
                        player1++;
                        outputdevice.writeMessage("Player 1 wins this round by special rule.");
                    }
                } else {
                    if (highestnumber == player1win) {
                        player1++;
                        outputdevice.writeMessage("Player 1 wins this round.");
                    } else {
                        player2++;
                        outputdevice.writeMessage("Player 2 wins this round.");
                    }
                }
            }
            outputdevice.writeMessage("Score: Player 1 - " + player1 + ", Player 2 - " + player2);
        }
        if (player1 >= 5) {
            outputdevice.writeMessage("Player 1 wins the game!");
        } else {
            outputdevice.writeMessage("Player 2 wins the game!");
        }
    }

}


