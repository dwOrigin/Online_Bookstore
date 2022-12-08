package com.springboot.service.impl;

import com.springboot.entity.Search;
import com.springboot.mapper.SearchMapper;
import com.springboot.service.ISearchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
