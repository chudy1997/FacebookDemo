package chudy1997;

/**
 * Created by Karol on 2017-06-17.
 * NotFoundException - exception thrown, when facebook profile is not found
 */
public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Index not found");
    }
}
