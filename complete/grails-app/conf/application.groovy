elasticSearch {
	date.formats = ["yyyy-MM-dd'T'HH:mm:ss'Z'"]
	defaultExcludedProperties = ["password", "username", "reportedBySignature", "customerThumbprint", "customerSignature", "image"]
	disableAutoIndex = false
	index.compound_format = true
	datastoreImpl = 'hibernateDatastore'
	unmarshallComponents = true
	searchableProperty.name = 'searchable'
	includeTransients = false
	bulkIndexOnStartup = false
}



environments {
	
	development {
		server.port =  8070
		
		grails.plugin.springsecurity.portMapper.httpPort = 8070
		grails.plugin.springsecurity.portMapper.httpsPort = 8543
		
		elasticSearch {
			// default ES
			// client.mode = 'local'
			client.mode = 'transport'
			client.transport.sniff = true
			// index.store.type = 'mmapfs'
			// client.mode
			
			// elasticsearch additional config
			bulkIndexOnStartup = false
			maxBulkRequest = 500
			// bootstrap.config.file = 'elasticsearch-local.yml'
			client.hosts = [
				[host:'localhost', port:9300]
			]
		}
		
		dataSources {
			dataSource {
				dbCreate = "create-drop"
				url = "jdbc:h2:./prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
				pooled = true
				jmxExport = true
				driverClassName = "org.h2.Driver"
				// dialect = "org.hibernate.dialect.Oracle10gDialect"
				username = "sa"
				password = ""
				// logSql = false
				logSql = true
				properties {
					jmxEnabled = true
					initialSize = 5
					maxActive = 50
					minIdle = 5
					maxIdle = 25
					maxWait = 10000
					maxAge = 10 * 60000
					timeBetweenEvictionRunsMillis = 5000
					minEvictableIdleTimeMillis = 60000
					// validationQuery = "SELECT 1"
					validationQuery = "SELECT 1"
					validationQueryTimeout = 3
					validationInterval = 15000
					testOnBorrow = true
					testWhileIdle = true
					testOnReturn = false
					jdbcInterceptors = "ConnectionState"
					defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
				}
			}
		}
		
	}
}