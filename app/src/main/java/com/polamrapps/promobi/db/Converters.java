package com.polamrapps.promobi.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.polamrapps.promobi.model.Link;
import com.polamrapps.promobi.model.MostPopular;
import com.polamrapps.promobi.model.MovieReview;
import com.polamrapps.promobi.model.MovieReviewMultiMedia;
import com.polamrapps.promobi.model.TopStory;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Converters {

    private Converters() {}

    @TypeConverter
    public static String toStringFromMovieReview(List<MovieReview> response) {
        if (response == null) {
            return null;
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    @TypeConverter
    public static List<MovieReview> fromMovieResponse(String stg) {
        if (stg == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<MovieReview>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(stg, listType);
    }

    @TypeConverter
    public static String toStringFromMostPopular(List<MostPopular> response) {
        if (response == null) {
            return null;
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    @TypeConverter
    public static List<MostPopular> fromMostPopularResponse(String stg) {
        if (stg == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<MostPopular>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(stg, listType);
    }

    @TypeConverter
    public static String toStringFromTopStory(List<TopStory> response) {
        if (response == null) {
            return null;
        }
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    @TypeConverter
    public static List<TopStory> fromTopStoryResponse(String stg) {
        if (stg == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<TopStory>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(stg, listType);
    }

    @TypeConverter
    public static String toStringFromMedia(MovieReviewMultiMedia media) {
        if (media == null) {
            return null;
        }
        return media.getImageSrc();
    }

    @TypeConverter
    public static MovieReviewMultiMedia toMedia(String string) {
        if (string == null) {
            return null;
        }
        MovieReviewMultiMedia media = new MovieReviewMultiMedia();
        media.setImageSrc(string);
        return media;
    }

    @TypeConverter
    public static String toStringFromLink(Link link) {
        if (link == null) {
            return null;
        }
        return String.format(Locale.getDefault(), "%s,%s", link.getUrl(), link.getTitle());
    }

    @TypeConverter
    public static Link toLink(String string) {
        if (string == null) {
            return null;
        }
        String[] stg = string.split(",");
        Link link = new Link();
        link.setTitle(stg[0]);
        link.setUrl(stg[1]);
        return link;
    }
}
