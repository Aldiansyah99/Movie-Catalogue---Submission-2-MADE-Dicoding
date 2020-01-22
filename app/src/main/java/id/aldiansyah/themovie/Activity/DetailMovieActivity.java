package id.aldiansyah.themovie.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import id.aldiansyah.themovie.Model.Movies;
import id.aldiansyah.themovie.R;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle, tvGenre, tvRating, tvDesc, tvRuntime;
    ImageView imgPoster, imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvTitle = findViewById(R.id.tv_detail_title);
        tvGenre = findViewById(R.id.tv_detail_genre);
        tvRating = findViewById(R.id.tv_detail_rating);
        tvDesc = findViewById(R.id.tv_detail_description);
        imgPoster = findViewById(R.id.img_detail_photo);
        imgCover = findViewById(R.id.img_detail_cover);
        tvRuntime = findViewById(R.id.tv_runtime);

        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movies.getTitle());
        tvGenre.setText(movies.getGenre());
        tvRating.setText(movies.getRating());
        tvDesc.setText(movies.getDescription());
        tvRuntime.setText(movies.getRuntime());

        Glide.with(this)
                .load(movies.getImage())
                .apply(new RequestOptions()).centerCrop()
                .into(imgPoster);

        Glide.with(this)
                .load(movies.getCover())
                .apply(new RequestOptions()).centerCrop()
                .into(imgCover);

    }
}
