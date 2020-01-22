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

import id.aldiansyah.themovie.Activity.DetailTvShowActivity;
import id.aldiansyah.themovie.Model.TvShow;
import id.aldiansyah.themovie.R;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<TvShow> listTvShow;

    public TvShowAdapter(ArrayList<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tv_show, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        TvShow tvShow = listTvShow.get(position);

        holder.tvTitle.setText(tvShow.getTitle());
        holder.tvGenre.setText(tvShow.getGenre());
        holder.tvRating.setText(tvShow.getRating());
        holder.tvDescription.setText(tvShow.getDescription());

        Glide.with(context)
                .load(tvShow.getImage())
                .apply(new RequestOptions()).centerCrop()
                .into(holder.imgPoster);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TvShow tvShow = listTvShow.get(position);
                tvShow.setCover(tvShow.getCover());
                tvShow.setImage(tvShow.getImage());
                tvShow.setTitle(tvShow.getTitle());
                tvShow.setGenre(tvShow.getGenre());
                tvShow.setRating(tvShow.getRating());
                tvShow.setDescription(tvShow.getDescription());

                Intent intent = new Intent(context, DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_MOVIE, tvShow);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPoster;
        TextView tvTitle, tvGenre, tvDescription, tvRating;
        ConstraintLayout constraintLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPoster = itemView.findViewById(R.id.img_poster_tvShow);
            tvTitle = itemView.findViewById(R.id.tv_judul_tvShow);
            tvGenre = itemView.findViewById(R.id.tv_genre_tvShow);
            tvDescription = itemView.findViewById(R.id.tv_description_tvShow);
            tvRating = itemView.findViewById(R.id.tv_rating_tvShow);
            constraintLayout = itemView.findViewById(R.id.constraint_tvShow);
            context = itemView.getContext();
        }
    }
}
