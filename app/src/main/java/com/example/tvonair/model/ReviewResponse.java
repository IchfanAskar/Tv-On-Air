package com.example.tvonair.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {


    /**
     * id : 1399
     * page : 1
     * results : [{"author":"lmao7","content":"I started watching when it came out as I heard that fans of LOTR also liked this. I stopped watching after Season 1 as I was devastated lol kinda. Only 2015 I decided to continue watching and got addicted like it seemed complicated at first, too many stories and characters. I even used a guide from internet like family tree per house while watching or GOT wiki so I can have more background on the characters. For a TV series, this show can really take you to a different world and never knowing what will happen. It is very daring that any time anybody can just die (I learned not to be attached and have accepted that they will all die so I won't be devastated hehe). I have never read the books but the show is entertaining and you will really root for your faves and really hate on those you hate. \r\n\r\nFantasy, action, drama, comedy, love...and lots of surprises!","id":"58aa82f09251416f92006a3a","url":"https://www.themoviedb.org/review/58aa82f09251416f92006a3a"},{"author":"Vlad Ulbricht","content":"Cruel, bloody, vulgar, Machiavellian, unrepentant. And that is just the writing. The camera angles, the score, the pacing mesh together for grand storytelling: a mix of horror, swords and sorcery, and endless treachery. \r\n\r\nAnd all of that would be somewhat squandered if it wasn't for the best casting I've ever seen. From Lena Headey as soft spoken Cersei to Peter Vaughan as ancient Maester Aemon, each character pulses with depth and believability. Peter Dinklage may have sacrificed a virgin princess to get this role; I've never seen a better fit, not in size (though there is that) but in the way his eyes convey shrewd arrogance coupled with unabashed debauchery.","id":"5913e02fc3a3683a93004984","url":"https://www.themoviedb.org/review/5913e02fc3a3683a93004984"},{"author":"tmdb92828292","content":"LOTR meets House of Cards. Imagine a fantasy novel if all of the beasts and mythologies were transported to the real world. There's no such thing as a happy ending, or an ending for that matter (unless you're dead). So as you watch the show make predictions, draw conspiracy theories, and watch them blow up in your face. This show is that kind of a ride!","id":"5b7f57499251416c89002511","url":"https://www.themoviedb.org/review/5b7f57499251416c89002511"}]
     * total_pages : 1
     * total_results : 3
     */

    @SerializedName("id")
    private int id;
    @SerializedName("page")
    private int page;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("results")
    private List<ResultsTrailer> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ResultsTrailer> getResults() {
        return results;
    }

    public void setResults(List<ResultsTrailer> results) {
        this.results = results;
    }

    public static class ResultsTrailer {
        /**
         * author : lmao7
         * content : I started watching when it came out as I heard that fans of LOTR also liked this. I stopped watching after Season 1 as I was devastated lol kinda. Only 2015 I decided to continue watching and got addicted like it seemed complicated at first, too many stories and characters. I even used a guide from internet like family tree per house while watching or GOT wiki so I can have more background on the characters. For a TV series, this show can really take you to a different world and never knowing what will happen. It is very daring that any time anybody can just die (I learned not to be attached and have accepted that they will all die so I won't be devastated hehe). I have never read the books but the show is entertaining and you will really root for your faves and really hate on those you hate.

         Fantasy, action, drama, comedy, love...and lots of surprises!
         * id : 58aa82f09251416f92006a3a
         * url : https://www.themoviedb.org/review/58aa82f09251416f92006a3a
         */

        @SerializedName("author")
        private String author;
        @SerializedName("content")
        private String content;
        @SerializedName("id")
        private String id;
        @SerializedName("url")
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
