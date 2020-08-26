package org.grails.guides

class Owners {
    String firstName
    String lastName
    Integer age
    List<Vehicle> vehicle


    //static embedded  = [vehicle: Vehicle]
    static hasMany = [vehicle: Vehicle]

    static searchable = {
        vehicle component:true
    }
}
