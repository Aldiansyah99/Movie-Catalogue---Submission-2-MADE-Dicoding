package id.aldiansyah.themovie.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.aldiansyah.themovie.Model.TvShow;
import id.aldiansyah.themovie.R;

public class DetailTvShowActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle, tvGenre, tvRating, tvDesc, tvRuntime;
    ImageView imgPoster, imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvTitle = findViewById(R.id.tv_detail_title_tvShow);
        tvGenre = findViewById(R.id.tv_detail_genre_tvShow);
        tvRating = findViewById(R.id.tv_detail_rating_tvShow);
        tvDesc = findViewById(R.id.tv_detail_description_tvShow);
        imgPoster = findViewById(R.id.img_detail_photo_tvShow);
        imgCover = findViewById(R.id.img_detail_cover_tvShow);
        tvRuntime = findViewById(R.id.tv_runtime_tvShow);

        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvTitle.setText(tvShow.getTitle());
        tvGenre.setText(tvShow.getGenre());
        tvRating.setText(tvShow.getRating());
        tvDesc.setText(tvShow.getDescription());
        tvRuntime.setText(tvShow.getRuntime());

        Glide.with(this)
                .load(tvShow.getImage())
                .apply(new RequestOptions()).centerCrop()
                .into(imgPoster);

        Glide.with(this)
                .load(tvShow.getCover())
                .apply(new RequestOptions()).centerCrop()
                .into(imgCover);
    }
}
