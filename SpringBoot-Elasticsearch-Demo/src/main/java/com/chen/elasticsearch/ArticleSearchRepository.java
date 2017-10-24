package com.chen.elasticsearch;

import com.chen.elasticsearch.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索类
 * @author 陈梓平
 * @date 2017/10/19.
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
