package org.grails.guides

class HomeController {

    def index() {
        respond([name: session.name ?: 'User', vehicleList: Vehicle.list(), vehicleTotal: Vehicle.count()])

    }


    def updateName(String name) {
        session.name = params.name

        flash.message = 'Name has been updated'
        def res = elasticSearch.search("${params.query}")

        redirect action: 'index'
    }

}
