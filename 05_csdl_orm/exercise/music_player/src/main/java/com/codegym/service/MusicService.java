package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void remove(int id) {
        musicRepository.remove( id);
    }

    @Override
    public void update(Music music) {
        musicRepository.update(music);
    }

    @Override
    public Music findOne(int id) {
        return musicRepository.findOne(id);
    }

}

