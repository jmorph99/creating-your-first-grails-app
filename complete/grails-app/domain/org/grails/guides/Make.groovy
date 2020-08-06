package org.grails.guides

class Make {

    String name
	String address

    static constraints = {
    }

    String toString() {
        name
    }
	
	static searchable = {
		only = ['name', 'address']
		name boost: 3.0
		address boost: 3.0
	}
	
	
}
