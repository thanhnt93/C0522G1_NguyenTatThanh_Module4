package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public MusicRepository() {

    }

    @Override
    public List<Music> findAll() {

        TypedQuery<Music> query = entityManager
                .createQuery("SELECT s FROM Music as s", Music.class);
        return query.getResultList();

    }

    @Override
    @Modifying
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    @Modifying
    public void remove(int id) {
//        music.setId(id);
//        System.out.println(music.getId());
        Music music1 = findOne(id);
        entityManager.remove(music1);
//        entityManager.merge(entityManager.merge(music));
    }

    @Override
    @Modifying
    public void update(Music music) {

        entityManager.merge(music);

    }

    @Override
    public Music findOne(int id) {


        Music music = entityManager.
                createQuery("select m from Music m where m.id =:id", Music.class).setParameter("id", id).getSingleResult();
        return music;
    }

}
