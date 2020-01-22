package id.aldiansyah.themovie.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private int image;
    private int cover;
    private String title;
    private String genre;
    private String rating;
    private String description;
    private String runtime;
    private String release;

    public TvShow() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    protected TvShow(Parcel in) {
        image = in.readInt();
        cover = in.readInt();
        title = in.readString();
        genre = in.readString();
        rating = in.readString();
        description = in.readString();
        runtime = in.readString();
        release = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeInt(cover);
        parcel.writeString(title);
        parcel.writeString(genre);
        parcel.writeString(rating);
        parcel.writeString(description);
        parcel.writeString(runtime);
        parcel.writeString(release);
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
