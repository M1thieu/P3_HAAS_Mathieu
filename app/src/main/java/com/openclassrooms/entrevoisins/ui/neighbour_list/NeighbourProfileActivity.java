package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourProfileActivity extends AppCompatActivity {

    Neighbour myNeighbour; //import neighbour

    @BindView(R.id.cardview_name)
    TextView myNeighbourName;

    @BindView(R.id.neighbour_image)
    ImageView myNeighbourAvatarUrl;

    @BindView(R.id.return_Button)
    ImageButton return_Button;

    @BindView(R.id.neighbour_favorite_btn)
    FloatingActionButton myNeighbourFavoriteButton;

    @BindView(R.id.cardview_location)
    TextView cardview_location;

    @BindView(R.id.cardview_phone_number)
    TextView cardview_phone_number;

    @BindView(R.id.cardview_network)
    TextView cardview_network;
    @BindView(R.id.neighbour_details)
    TextView neighbour_details;


    private NeighbourApiService myApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_profile);
        ButterKnife.bind(this);
        myApiService = DI.getNeighbourApiService();



        myNeighbour = (Neighbour) getIntent().getExtras().getParcelable("neighbour");
        myNeighbourName.setText(myNeighbour.getName());
        cardview_location.setText(myNeighbour.getAddress());
        cardview_phone_number.setText(myNeighbour.getPhoneNumber());
        cardview_network.setText("www.facebook.fr/"+myNeighbour.getName());
        neighbour_details.setText(myNeighbour.getAboutMe());
        Glide.with(this).
                load(myNeighbour.getAvatarUrl())
                .into(myNeighbourAvatarUrl);
        defineStarColor();
        return_Button.setOnClickListener(v -> finish());
        myNeighbourFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApiService.toggleFavoriteNeighbour(myNeighbour);
                //myNeighbour.setFavoris(!myNeighbour.isFavoris());
                defineStarColor();
            }
        });
    }
    private void defineStarColor() {
        if (myNeighbour.isFavoris()){
            myNeighbourFavoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        }
        else {myNeighbourFavoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);}
    }
}
