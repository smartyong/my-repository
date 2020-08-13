package com.example.study.service;

import com.example.study.dao.PersionDao;
import com.example.study.domain.Persion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/8/13 0013.
 */
@Service
public class PersionServiceImpl implements PersionService {

    @Autowired
    PersionDao persionDao;

    @Override
    public void addPersion(Persion persion) {
        persionDao.insertPersion(persion);
    }

    @Override
    public Persion findPersion(int id) {
        return persionDao.findOne(id);
    }

    @Override
    public List<Persion> getAllPersion() {
        return persionDao.persionList();
    }

    @Override
    public void deletePersion(Integer id) {
        persionDao.delete(id);
    }

    @Override
    public void updatePersion(Persion persion) {
        persionDao.update(persion);
    }
}
