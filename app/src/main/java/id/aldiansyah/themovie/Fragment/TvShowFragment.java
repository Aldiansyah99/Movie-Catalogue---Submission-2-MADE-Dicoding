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

import id.aldiansyah.themovie.Adapter.TvShowAdapter;
import id.aldiansyah.themovie.Model.TvShow;
import id.aldiansyah.themovie.R;

public class TvShowFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<TvShow> list = new ArrayList<>();
    public String[] dataTitle;
    public String[] dataGenre;
    public String[] dataRating;
    public String[] dataDescription;
    public String[] dataRuntime;
    public TypedArray dataPoster;
    public TypedArray dataCover;


    public TvShowFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_tvShow);
        list.addAll(getListTvShow());
        showRecyclerViewList();
        return view;
    }

    private ArrayList<TvShow> getListTvShow() {
        dataTitle = getResources().getStringArray(R.array.data_title_tvShow);
        dataGenre = getResources().getStringArray(R.array.data_genre_tvShow);
        dataRating = getResources().getStringArray(R.array.data_rating_tvShow);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_tvShow);
        dataDescription = getResources().getStringArray(R.array.data_description_tvShow);
        dataPoster = getResources().obtainTypedArray(R.array.data_imgPoster_tvShow);
        dataCover = getResources().obtainTypedArray(R.array.data_imgCover_tvShow);

        ArrayList<TvShow> listTvShow = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setImage(dataPoster.getResourceId(i, -1));
            tvShow.setCover(dataCover.getResourceId(i, -1));
            tvShow.setTitle(dataTitle[i]);
            tvShow.setGenre(dataGenre[i]);
            tvShow.setRating(dataRating[i]);
            tvShow.setDescription(dataDescription[i]);
            tvShow.setRuntime(dataRuntime[i]);

            listTvShow.add(tvShow);
        }
        return listTvShow;
    }

    private void showRecyclerViewList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TvShowAdapter tvShowAdapter = new TvShowAdapter(list);
        recyclerView.setAdapter(tvShowAdapter);
    }

}
