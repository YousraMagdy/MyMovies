package com.thenewboston.mymovies;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      //  final String OWM_DESCRIPTION = "rFLNqWI.jpg";

         String[] eatFoodyImages = {
               "http://i.imgur.com/rFLNqWI.jpg",
                "http://i.imgur.com/C9pBVt7.jpg",
                "http://i.imgur.com/rT5vXE1.jpg",
                "http://i.imgur.com/aIy5R2k.jpg",
                "http://i.imgur.com/MoJs9pT.jpg",
                "http://i.imgur.com/S963yEM.jpg",
                "http://i.imgur.com/rLR2cyc.jpg",
                "http://i.imgur.com/SEPdUIx.jpg",
                "http://i.imgur.com/aC9OjaM.jpg",
                "http://i.imgur.com/76Jfv9b.jpg",
                "http://i.imgur.com/fUX7EIB.jpg",
                "http://i.imgur.com/syELajx.jpg",
                "http://i.imgur.com/COzBnru.jpg",
                "http://i.imgur.com/Z3QjilA.jpg",
        };




        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

        gridView.setAdapter(new ImageListAdapter(getActivity(), eatFoodyImages));
        return rootView;
    }




    public class ImageListAdapter extends ArrayAdapter {
        private Context context;
        private LayoutInflater inflater;

        private String[] imageUrls;

        public ImageListAdapter(Context context, String[] imageUrls) {
            super(context, R.layout.gridview_item, imageUrls);

            this.context = context;
            this.imageUrls = imageUrls;

            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.gridview_item, parent, false);
            }

            Picasso
                    .with(context)
                    .load(imageUrls[position])
                    .fit() // will explain later
                    .into((ImageView) convertView);

            return convertView;
        }
    }
}
