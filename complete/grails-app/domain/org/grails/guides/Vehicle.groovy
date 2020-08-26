package org.grails.guides

@SuppressWarnings('GrailsDomainReservedSqlKeywordName')
class Vehicle {

    Integer year

    String name
    Model model
    Make make
    //static belongsTo = [Owners]
    static constraints = {
        year min: 1900
        name maxSize: 255
    }
    static searchable = {
        only = ['name','model','make']
        name boost: 3.0

    }
}
