package developers.sastapp.viphotdog.Class

class User {
    var id: Int? = null
    var name: String? = null
    var price: String? = null
    var count: String? = null
    var date: String? = null
    var number: Int? = null
    var select: Int? = null

    constructor(
        id: Int?,
        name: String?,
        price: String?,
        count: String?,
        date: String?,
        number: Int?,
        select: Int?
    ) {
        this.id = id
        this.name = name
        this.price = price
        this.count = count
        this.date = date
        this.number = number
        this.select = select
    }

    constructor(
        name: String?,
        price: String?,
        count: String?,
        date: String?,
        number: Int?,
        select: Int?
    ) {
        this.name = name
        this.price = price
        this.count = count
        this.date = date
        this.number = number
        this.select = select
    }
}