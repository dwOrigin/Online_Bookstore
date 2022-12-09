package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.common.Result;
import com.springboot.entity.Search;
import com.springboot.mapper.SearchMapper;
import com.springboot.service.ISearchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.springboot.common.Constants.CODE_400;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author book_store
 * @since 2022-12-08
 */
@Service
public class SearchServiceImpl extends ServiceImpl<SearchMapper, Search> implements ISearchService {
    @Resource
    private SearchMapper searchMapper;
    @Override
    public Result searchByName(String bookName) {
        QueryWrapper<Search> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("search_book_name",bookName);
        Search search = searchMapper.selectOne(queryWrapper);
        if (search!=null)
            return Result.success(search);
        else
            return Result.error(CODE_400,"名称错误");
    }

    @Override
    public Result searchByISBN(int ISBN) {
        Search search = searchMapper.selectById(ISBN);
        if (search!=null)
            return Result.success(search);
        else
            return Result.error(CODE_400,"名称错误");
    }

    @Override
    public Result searchByAuthor(String bookAuthor) {
        QueryWrapper<Search> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("search_book_author",bookAuthor);
        List<Search> searchList = searchMapper.selectList(queryWrapper);
        if (searchList!=null)
            return Result.success(searchList);
        else
            return Result.error();
    }

    @Override
    public Result userSearchHistory(int user_id) {
        QueryWrapper<Search> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("search_user_id",user_id);
        List<Search> searchList = searchMapper.selectList(queryWrapper);
        if (searchList!=null)
            return Result.success(searchList);
        else
            return Result.error();

    }
}
