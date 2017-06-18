package chudy1997;

import java.util.List;

/**
 * Facebook - class representing facebook profile
 * read from prepared json files-examples in directory 'Jsons'
 * Created by Karol on 2017-06-17.
 */

public class Facebook implements Comparable<Facebook> {
    private String id;
    private long birthday;
    private String firstname;
    private String lastname;
    private String occupation;
    private String gender;
    private CityBean city;
    private String work;
    private String school;
    private String location;
    private String relationship;
    private List<String> friends;
    private List<PostsBean> posts;

    public int compareTo(Facebook otherProfile) {
        if (this.getFirstname().compareTo(otherProfile.getFirstname()) == 0) {
            return this.getLastname().compareTo(otherProfile.getLastname());
        }
        return this.getFirstname().compareTo(otherProfile.getFirstname());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class CityBean {

        public CityBean(String countryName, String cityName, String stateName, CoordsBean coords) {
            this.countryName = countryName;
            this.cityName = cityName;
            this.stateName = stateName;
            this.coords = coords;
        }

        private String countryName;
        private String cityName;
        private String stateName;
        private CoordsBean coords;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public CoordsBean getCoords() {
            return coords;
        }

        public void setCoords(CoordsBean coords) {
            this.coords = coords;
        }

        public static class CoordsBean {

            public CoordsBean(double lon, double lat) {
                this.lon = lon;
                this.lat = lat;
            }

            private double lon;
            private double lat;

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }
    }

    public static class PostsBean {

        public PostsBean(String id, String message) {
            this.id = id;
            this.message = message;
        }

        private String id;
        private String message;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
