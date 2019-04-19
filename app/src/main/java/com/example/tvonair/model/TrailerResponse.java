package com.example.tvonair.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerResponse {


    /**
     * id : 1399
     * results : [{"id":"5b5b91c2925141523700502c","iso_639_1":"en","iso_3166_1":"US","key":"bjqEWgDVPe0","name":"GAME OF THRONES - SEASON 1- TRAILER","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5c9295200e0a267cd8168bd8","iso_639_1":"en","iso_3166_1":"US","key":"BpJYNVhGf1s","name":"Game Of Thrones \"The Game Begins\" Preview (HBO)","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5c92c2519251412b51773135","iso_639_1":"en","iso_3166_1":"US","key":"f3MUpuRF6Ck","name":"Inside Game of Thrones: A Story in Prosthetics \u2013 BTS (HBO)","site":"YouTube","size":1080,"type":"Behind the Scenes"},{"id":"5c999b48c3a36863b73b9d42","iso_639_1":"en","iso_3166_1":"US","key":"y2ZJ3lTaREY","name":"Inside Game of Thrones: A Story in Camera Work \u2013 BTS (HBO)","site":"YouTube","size":1080,"type":"Behind the Scenes"}]
     */

    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private List<ResultsTrailer> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsTrailer> getResults() {
        return results;
    }

    public void setResults(List<ResultsTrailer> results) {
        this.results = results;
    }

    public static class ResultsTrailer {
        /**
         * id : 5b5b91c2925141523700502c
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : bjqEWgDVPe0
         * name : GAME OF THRONES - SEASON 1- TRAILER
         * site : YouTube
         * size : 1080
         * type : Trailer
         */

        @SerializedName("id")
        private String id;
        @SerializedName("iso_639_1")
        private String iso6391;
        @SerializedName("iso_3166_1")
        private String iso31661;
        @SerializedName("key")
        private String key;
        @SerializedName("name")
        private String name;
        @SerializedName("site")
        private String site;
        @SerializedName("size")
        private int size;
        @SerializedName("type")
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
