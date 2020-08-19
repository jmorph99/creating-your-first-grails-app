package org.grails.guides

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BlogsSpec extends Specification implements DomainUnitTest<Blogs> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
