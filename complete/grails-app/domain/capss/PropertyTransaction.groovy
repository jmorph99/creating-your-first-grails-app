
package capss

class PropertyTransaction {
	static hasMany = [items: PropertyTransactionItem]
	static belongsTo = PropertyTransactionItem
	
	String customerName
	String customerCity
	SortedSet items = new TreeSet()
	
	static searchable = {
		only = ['customerName',
			'id',
			 'customerCity'
			 ]
			 // items parent:false, component: true
			 items component: true
	}
	
	
	
}

