package developers.sastapp.viphotdog.Class

class User {
    var id: Int? = null
    var tableId: Int? = null
    var name: String? = null
    var price: String? = null
    var count: String? = null

    constructor(id: Int?, tableId: Int?, name: String?, price: String?, count: String?) {
        this.id = id
        this.tableId = tableId
        this.name = name
        this.price = price
        this.count = count
    }

    constructor(tableId: Int?, name: String?, price: String?, count: String?) {
        this.tableId = tableId
        this.name = name
        this.price = price
        this.count = count
    }
}