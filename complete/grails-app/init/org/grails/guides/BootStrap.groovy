package org.grails.guides
import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    def init = { servletContext ->

        def nissan = new Make(name: 'Nissan', address: "2 main").save()
        def ford = new Make(name: 'Ford', address: "2 broadway").save()

        def titan = new Model(name: 'Titan', make: nissan).save()
        def leaf = new Model(name: 'Leaf', make: nissan).save()
        def windstar = new Model(name: 'Windstar', make: ford).save()



        def v1 = new Vehicle(name: 'Pickup',  make: nissan, model: titan, year: 2012).save()
        def v2 = new Vehicle(name: 'Economy', make: nissan, model: leaf, year: 2014).save()
        def v3 = new Vehicle(name: 'Minivan', make: ford, model: windstar, year: 1990).save()

        def o1 = new Owners(firstName: 'John', lastName: "murphy", age: 52)
        .addToVehicle(v1)
        .addToVehicle(v2)
        .save()



    }
    def destroy = {
    }
}

