package com.ogunladetaiye.udux.ui.udux_discover.featured_albums_slider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ogunladetaiye.udux.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    private final List<SliderData> mSliderItems;

    public SliderAdapter(Context context, ArrayList<SliderData> sliderDataArrayList) {
        this.mSliderItems = sliderDataArrayList;
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_release_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        final SliderData sliderItem = mSliderItems.get(position);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                .fitCenter()
                .into(viewHolder.featuredReleaseImage);
        viewHolder.featuredReleaseArtistName.setText(sliderItem.getArtistName());
        viewHolder.featuredReleaseTitle.setText(sliderItem.getAlbumTitle());
    }


    @Override
    public int getCount() {
        return mSliderItems.size();
    }


    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView featuredReleaseImage;
        TextView featuredReleaseArtistName;
        TextView featuredReleaseTitle;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            featuredReleaseImage = itemView.findViewById(R.id.featured_release_image);
            featuredReleaseTitle = itemView.findViewById(R.id.featured_release_title);
            featuredReleaseArtistName = itemView.findViewById(R.id.featured_release_artist_name);
            this.itemView = itemView;
        }
    }
}
