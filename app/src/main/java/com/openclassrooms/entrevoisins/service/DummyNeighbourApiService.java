package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    // Liste favoris

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteList = new ArrayList<>();
        for (Neighbour list : neighbours) {
            if (list.isFavoris()) {
                favoriteList.add(list);
            }
        }
        return favoriteList;
    }

    /**
     * methode de services pour changer le statut favoris
     * @param neighbour to update
     */
    @Override
    public void toggleFavoriteNeighbour(Neighbour neighbour) {
        neighbours.get(neighbours.indexOf(neighbour)).setFavoris(!neighbour.isFavoris());
        neighbour.setFavoris(!neighbour.isFavoris());

    }
}


