package capss

class PropertyTransactionItem implements Comparable {
	static belongsTo = [transaction: PropertyTransaction]
	String articleName
	BigDecimal amount                //pennies
	Integer sequenceNumber = 0
	
	static searchable = {
		only = ['articleName',
			'id',
			 'amount'
			 ]
	}
	
	int compareTo(other) {
		sequenceNumber.compareTo(other.sequenceNumber)
	}
}