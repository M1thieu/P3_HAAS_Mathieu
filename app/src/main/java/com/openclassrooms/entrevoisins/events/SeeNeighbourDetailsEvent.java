package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class SeeNeighbourDetailsEvent {


    /**
     * Neighbour to show
     */

    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */

    public SeeNeighbourDetailsEvent (Neighbour neighbour) {
        this.neighbour = neighbour;
    }

}
