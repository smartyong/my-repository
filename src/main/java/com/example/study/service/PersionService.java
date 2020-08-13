package com.example.study.service;

import com.example.study.domain.Persion;

import java.util.List;

/**
 * Created by Administrator on 2020/8/13 0013.
 */

public interface PersionService {

    public void addPersion(Persion persion);

    public Persion findPersion(int id);

    public List<Persion> getAllPersion();

    public void deletePersion(Integer id);

    public void updatePersion(Persion persion);
}
