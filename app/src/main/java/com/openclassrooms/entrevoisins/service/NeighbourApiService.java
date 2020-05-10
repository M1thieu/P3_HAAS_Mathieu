package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get all Favoris Neighbours
     */
    List<Neighbour> getFavoriteNeighbours(); //appelle méthode de l'API qui retourne les voisins favoris ou non.

    /**
     * Supprimer un neighbour
     *
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Modifier ou changer le statut favoris
     * @param neighbour neighbour a ajouter ou a enlever de la liste favoris
     */
    /**
     * Create a neighbour
     *
     * @param neighbour
     */

    void createNeighbour(Neighbour neighbour);

    // Ajouter un utilisateur en favoris

    void toggleFavoriteNeighbour(Neighbour neighbour);
}

