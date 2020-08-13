package com.example.study.dao;

import com.example.study.domain.Persion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2020/8/13 0013.
 */
@Mapper
public interface PersionDao {

    public void  insertPersion(Persion persion);

    public Persion findOne(int id);

    public List<Persion>  persionList();

    public void  delete(Integer id);

    public void  update(Persion persion);
}
