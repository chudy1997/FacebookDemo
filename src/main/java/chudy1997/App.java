package chudy1997;

import static chudy1997.FacebookServiceImpl.getProfilesFromFacebookDummy;
import static java.lang.System.exit;

/**
 * App - class with example
 * Created by Karol on 2017-06-17.
 */

public class App {
    public static void main(String[] args){
        FacebookService f=getProfilesFromFacebookDummy("Jsons");
        if(f==null){System.out.println("Jsons ;/");exit(1);}
        try {
            System.out.println(f.findById("4").getLastname());
        }
        catch(NotFoundException e){
            System.err.println("There is no profile with given id");
            exit(1);
        }
        System.out.println(f.findMostCommonWords());
        System.out.println(f.findPostIdsByKeyword("as"));
        f.findAll().forEach(p->System.out.println(p.getId()+" "+p.getFirstname()+" "+p.getLastname()));
    }
}
