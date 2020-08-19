package org.grails.guides


import grails.plugins.elasticsearch.ElasticSearchService
import groovy.transform.CompileStatic

@CompileStatic
class blogsSearchService {
    ElasticSearchService elasticSearchService

    Map search(String query) {
        elasticSearchService.search(query, [indices: Blogs, types: Blogs, score: true]) as Map
    }
}