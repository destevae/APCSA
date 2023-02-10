import java.util.ArrayList;

public class ReviewCollector {

    public static void main(String[] args){

        System.out.println("book");
    }

    private ArrayList<ProductReview> reviewList;

    private ArrayList<String> productList;

    /** Constructs a ReviewCollector object and initializes the instance variables. */

    public ReviewCollector(){
        reviewList = new ArrayList<ProductReview>();

        productList = new ArrayList<String>();

    }

/** Adds a new review to the collection of reviews, as described in part (a). */

public void addReview(ProductReview prodReview){

    for(String name : productList){
        if(name.equals(prodReview.getName())){
            reviewList.add(prodReview);
            return;
        }
    }

    productList.add(prodReview.getName());
    reviewList.add(prodReview);

}

    /** Returns the number of good reviews for a given product name, as described in part (b). */

public int getNumGoodReviews(String prodName){  
    int nGood = 0;
    for(int i = 0; i < reviewList.size(); i++){
        if(reviewList.get(i).getName().equals(prodName)){
            if(reviewList.get(i).getReview().contains("best") == true){
                nGood++;
            }
        }
    }

    return nGood;

}

    // There may be instance variables, constructors, and methods not shown.
}
