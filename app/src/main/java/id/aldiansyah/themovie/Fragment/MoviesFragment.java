package id.aldiansyah.themovie.Fragment;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.aldiansyah.themovie.Adapter.MoviesAdapter;
import id.aldiansyah.themovie.Model.Movies;
import id.aldiansyah.themovie.R;

public class MoviesFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Movies> list = new ArrayList<>();
    public String[] dataTitle;
    public String[] dataGenre;
    public String[] dataRating;
    public String[] dataDescription;
    public String[] dataRuntime;
    public TypedArray dataPoster;
    public TypedArray dataCover;

    public MoviesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        list.addAll(getListMovies());
        showRecyclerViewList();
        return view;
    }

    private ArrayList<Movies> getListMovies() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_image);
        dataCover = getResources().obtainTypedArray(R.array.data_imageCover);

        ArrayList<Movies> listMovies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movies movies = new Movies();
            movies.setImage(dataPoster.getResourceId(i, -1));
            movies.setCover(dataCover.getResourceId(i, -1));
            movies.setTitle(dataTitle[i]);
            movies.setGenre(dataGenre[i]);
            movies.setRating(dataRating[i]);
            movies.setDescription(dataDescription[i]);
            movies.setRuntime(dataRuntime[i]);

            listMovies.add(movies);
        }
        return listMovies;
    }

    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MoviesAdapter moviesAdapter = new MoviesAdapter(list);
        recyclerView.setAdapter(moviesAdapter);
    }

}
