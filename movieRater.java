public class  movieRater{
    public static void main(String [] args){
        double totalRatings = 0;
        double numberOfRatings = 0;

        for (int i = 0; i < args.length; i++) {
            double rating = Double.parseDouble(args[i]);
            numberOfRatings++;
            totalRatings += rating;
        }

        double averageRating = totalRatings / numberOfRatings;
        //could also do averageRating = totalRatings / args.length;

        System.out.println("Average Rating: " + averageRating);

        if (averageRating < 4) {
            System.out.println("Recommendation: Horrible!");
        } else if (averageRating < 7) {
            System.out.println("Recommendation: Not bad, but not the best!");
        } else if (averageRating < 9) {
            System.out.println("Recommendation: Amazing!");
        } else {
            System.out.println("Recommendation: Must watch!");
        }
    }
    
}
