package org.grails.guides

import grails.plugins.elasticsearch.ElasticSearchService

class Blogs {

    static constraints = {
    }
    String content
    String title


    //
    // def res = ElasticSearchService.search('test')
}
