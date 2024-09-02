package fr.maxime.exo_multi_route.repository;


import fr.maxime.exo_multi_route.entity.Chien;

public class ChienRepository extends BaseRepository<Chien> {
    public ChienRepository() {
        super(Chien.class);
    }
}
