public class rectangle {
    int width;
    int height;

    rectangle(int h, int w){ // constructor, sets up the objects
        width = w;
        height = h;
    }

    int area(){
        return height*width;
    }

    int perimeter(){
        return 2*height + 2*width;
    }

    double notdiagonal(){
        return Math.sqrt(height*height + width*width); // Math.exp takes the first input to the power of the second input
    }
} 
