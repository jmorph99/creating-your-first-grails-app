package org.grails.guides
import grails.plugins.elasticsearch.ElasticSearchService
import grails.plugins.elasticsearch.ElasticSearchResult
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.search.aggregations.Aggregation
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms
import org.elasticsearch.search.aggregations.bucket.terms.ParsedTerms

//import grails.plugins.elasticsearch.
class HomeController {

    def index() {
        respond([name: session.name ?: 'User', vehicleList: Vehicle.list(), vehicleTotal: Vehicle.count()])

    }
    ElasticSearchService elasticSearchService
    AggregationBuilders aggregationBuilders

    def updateName(String name) {
        session.name = params.name
        String sname = params.name
        flash.message = 'Name has been updated'

        ElasticSearchResult res = elasticSearchService.search(
                {
                    bool {
                    must {
                        nested {
                            path = "vehicle"
                            query {

                                        term("vehicle.name": sname)

                            }
                        }
                    }
                    }
                },
                [indices:'org.grails.guides.owners_read'])

        response.setHeader("Content-Type", "text/html")
        response.outputStream << "<h3>Titles</h3>"
        res.searchResults.each {
            response.outputStream << it["firstName"].toString() + " " + it["lastName"].toString() + " " + it["age"].toString()+ "<br/>"
        }
        ArrayList<Aggregation> aggs = []
        aggs << AggregationBuilders.terms('Authors').field('author.keyword')

        ElasticSearchResult res2 = elasticSearchService.search(
                "test",
                null as Closure,
                {

                    "names" {
                        terms(field: 'author.keyword')
                    }

                },
                [ indices: 'blogs', type: "_doc" ])
                response.outputStream << "<br/><br/><h3>Authors Aggregation</h3>"

                res2.getAggregations().get('names').buckets.each {
                    println it.key.toString()
                    response.outputStream << it.docCount.toString() + " " + it.key.toString() + "<br/>"
                }



    }

}
