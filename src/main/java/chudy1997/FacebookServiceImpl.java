package chudy1997;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * FacebookServiceImpl- class ,implementing FacebookService interface,
 * serving to look through facebook profiles
 * Created by Karol on 2017-06-17.
 */

public class FacebookServiceImpl implements FacebookService {
    private LinkedList<Facebook> profiles = new LinkedList<>();
    ;

    public LinkedList<Facebook> getProfiles() {
        return profiles;
    }

    public void setProfiles(LinkedList<Facebook> profiles) {
        this.profiles = profiles;
    }

    public void addProfile(Facebook profile) {
        profiles.add(profile);
    }

    /**
     * prywatny konstruktor
     */
    private FacebookServiceImpl() {
    }


    /**
     * nullable!!!
     * Fabryka-Zwraca obiekt implementujący FacebookService z profilami
     * z plików JSON z katalogu directoryPath
     * w naszym projekcie "Jsons"
     */
    public static FacebookServiceImpl getProfilesFromFacebookDummy() {
        return getProfilesFromFacebookDummy("Jsons");
    }

    public static FacebookServiceImpl getProfilesFromFacebookDummy(String directoryPath) {
        FacebookServiceImpl res = new FacebookServiceImpl();
        Gson gson = new Gson();
        Facebook face = null;
        File[] files = new File(directoryPath).listFiles();
        if (files == null) return null;

        try {
            for (File file : files) {
                FileReader fr = null;
                try {
                    if (file.isFile()) {
                        fr = new FileReader(file);
                        face = gson.fromJson(fr, Facebook.class);
                        res.getProfiles().add(face);
                    }
                } finally {
                    if (fr != null) fr.close();
                }
            }
        } catch (IOException | JsonIOException e) {
            return null;
        }
        return res;
    }

    /**
     * Zwraca obiekt reprezentujący profil Facebooka na podstawie id
     * lub null jeśli nie został znaleziony
     * możemy przeszukać binarnie bo lista jest posortowana wg id
     *     * w czasie logarytmicznym
     */
    public Facebook findById(String id) throws NotFoundException {
        int startIndex = 0, finishIndex = getProfiles().size() - 1;
        while (finishIndex >= startIndex) {
            int middleIndex = (startIndex + finishIndex) / 2;
            Facebook res = getProfiles().get(middleIndex);
            int comp = res.getId().compareTo(id);
            if (comp == 0) {
                return res;
            } else if (comp < 0) {
                startIndex = middleIndex + 1;
            } else {
                finishIndex = middleIndex - 1;
            }
        }
        throw new NotFoundException();
    }

    /**
     * Zwraca mapę której kluczem jest słowo a wartością liczba jego
     * wystąpień - pod uwagę brane są wszystkie posty
     */
    public Map<String, Long> findMostCommonWords() {
        Map<String, Long> res = new HashMap<>();

        for (Facebook profile : getProfiles()) {
            for (Facebook.PostsBean post : profile.getPosts()) {
                String[] words = post.getMessage().split(",|\\.| |!|\\n|\\(|\\)|:");
                for (String s : words) {
                    if (res.containsKey(s)) {
                        res.put(s, res.get(s) + 1);
                    } else {
                        res.put(s, 1L);
                    }
                }
            }
        }

        //!!!w tym przypadku pętla foreach jest o wiele bardziej czytelna, więc ją zostawiłem!!!

//        getProfiles().forEach(profile->profile.getPosts().
//                forEach(post-> Arrays.stream(post.getMessage().split(",|\\.| |!|\\n|\\(|\\)|:")).
//                        forEach(word -> {
//                            if(res.containsKey(word))
//                                res.put(word, res.get(word) + 1);
//                            else
//                                res.put(word,1L);
//                        })));

        return res;
    }


    /**
     * Zwraca zbiór id Postów zawierających słowo word
     */
    public Set<String> findPostIdsByKeyword(String word) {
        Set<String> res = new HashSet<>();

        getProfiles().forEach((profile) ->
                profile.getPosts().stream().filter(post -> post.getMessage().
                        contains(word)).forEach(post -> res.add(post.getId()))
        );

//        for(Facebook profile:getProfiles()) {
//            for (Facebook.PostsBean post : profile.getPosts()) {
//                if(post.getMessage().contains(word)){
//                    res.add(post.getId());
//                }
//            }
//        }
        return res;
    }

    /**
     *      * Zwraca zbiór obiektów reprezentujących profile Facebooka
     * posortowane po firstname, lastname
     * Treeset przy dodawaniu elementu używa compareTo,który
     * odpowiednio zaimplementowałem
     */
    public Set<Facebook> findAll() {
        return new TreeSet<Facebook>(getProfiles());
    }
}
