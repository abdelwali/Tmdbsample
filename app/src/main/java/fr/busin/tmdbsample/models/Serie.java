package fr.busin.tmdbsample.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jose on 10/6/15.
 */
public class Serie implements Parcelable {

    private String title;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String description;
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("release_date")
    private String releaseDate;
 private String original_name ;


    @SerializedName("id")
    private int id;


    public Serie() {
    }

    protected Serie(Parcel in) {
        title = in.readString();
        poster = in.readString();
        id = in.readInt();
        description = in.readString();
        rating = in.readString();
        backdrop = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return original_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getOriginal_name() {
        return original_name;
    }

    public void getOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getPoster() {
        if (poster != null) {
            return "http://image.tmdb.org/t/p/w500" + poster;
        }
        return null;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBackdrop() {
        if (backdrop != null) {
            return "http://image.tmdb.org/t/p/original" + backdrop;
        }
        return null;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster);
        parcel.writeString(description);
        parcel.writeString(rating);
        parcel.writeInt(id);
        parcel.writeString(backdrop);
        parcel.writeString(releaseDate);
    }

    public class SerieResult {
        private List<Serie> results;

        public List<Serie> getResults() {
            return results;
        }
    }
}
