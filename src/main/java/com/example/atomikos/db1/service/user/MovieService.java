package com.example.atomikos.db1.service.user;
import com.example.atomikos.db1.dao.user.MovieMapper;
import com.example.atomikos.db1.model.user.Movie;
import org.springframework.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @ClassName: MovieService
* @Description:
* @author tangliangdong
* @date 2019-12-6
*/
@Service("movieService")
public class MovieService{
    @Autowired
    private MovieMapper movieMapper;

    //---------增删改查基础部分S--------
    //保存
    public Integer save(Movie movie){
        return movieMapper.insert(movie);
    }
    //根据id删除条目
    public Integer deleteById(String  uuid){
        Movie movie = new Movie();
        movie.setName(uuid);
        return movieMapper.delete(movie);
    }
    //根据主键查询
    public Movie selectByUuid(String uuid){
        if(!StringUtils.hasText(uuid)){
        return null;
        }
        Movie movie = new Movie();
        movie.setName(uuid);
        return movieMapper.selectOne(movie);
    }
    //根据传入条件查询列表
    public List<Movie> selectByService(Movie movie){
        return movieMapper.select(movie);
    }
    //根据传入值更新，空则不变
    public Integer updateByIdSelective(Movie movie){
        return movieMapper.updateByPrimaryKeySelective(movie);
    }
    //更新所有信息
    public Integer updateById(Movie movie){
        return movieMapper.updateByPrimaryKey(movie);
    }
    //---------增删改查基础部分E--------
}