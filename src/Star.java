public class Star {
    public String countStar(String rating){
        double sRating = Double.parseDouble(rating);
        int iRating = (int)sRating;
        
        String stars = "";

        for (int i = 0; i < iRating; i++) {
            stars += "⭐";
        }
        stars += " " + iRating + "/10";
        return stars;
    }
}
