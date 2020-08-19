package org.grails.guides

import capss.*

class BootStrap {

    def init = { servletContext ->

        def nissan = new Make(name: 'Nissan', address: "2 main").save()
        def ford = new Make(name: 'Ford', address: "2 broadway").save()

        def titan = new Model(name: 'Titan', make: nissan).save()
        def leaf = new Model(name: 'Leaf', make: nissan).save()
        def windstar = new Model(name: 'Windstar', make: ford).save()

        new Vehicle(name: 'Pickup',  make: nissan, model: titan, year: 2012).save()
        new Vehicle(name: 'Economy', make: nissan, model: leaf, year: 2014).save()
        new Vehicle(name: 'Minivan', make: ford, model: windstar, year: 1990).save()
		
		PropertyTransaction pt1
		PropertyTransactionItem pti1, pti2
		pti1 = new PropertyTransactionItem(articleName: 'watch', amount: 350, sequenceNumber: 0)
		pti2 = new PropertyTransactionItem(articleName: 'ring', amount: 450, sequenceNumber: 1)
		pt1 = new PropertyTransaction(customerName: 'Bob', customerCity: 'Atlanta')
		pt1.addToItems(pti1)
		pt1.addToItems(pti2)
		pt1.save()
    }
    def destroy = {
    }
}
