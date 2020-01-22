package id.aldiansyah.themovie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.aldiansyah.themovie.Activity.DetailMovieActivity;
import id.aldiansyah.themovie.Model.Movies;
import id.aldiansyah.themovie.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Movies> listData;

    public MoviesAdapter(ArrayList<Movies> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movies, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Movies movies = listData.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movies.getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPoster);

        holder.tvJudul.setText(movies.getTitle());
        holder.tvGenre.setText(movies.getGenre());
        holder.tvRating.setText(movies.getRating());
        holder.tvDescription.setText(movies.getDescription());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Movies movies = listData.get(position);
                movies.setCover(movies.getCover());
                movies.setImage(movies.getImage());
                movies.setTitle(movies.getTitle());
                movies.setGenre(movies.getGenre());
                movies.setRating(movies.getRating());
                movies.setDescription(movies.getDescription());

                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvJudul, tvGenre, tvRating, tvDescription;
        ConstraintLayout constraintLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvJudul = itemView.findViewById(R.id.tv_judul_film);
            tvGenre = itemView.findViewById(R.id.tv_genre_film);
            tvRating = itemView.findViewById(R.id.tv_rating_film);
            tvDescription = itemView.findViewById(R.id.tv_description_film);
            constraintLayout = itemView.findViewById(R.id.constraint);
            context = itemView.getContext();
        }
    }
}
