package developers.sastapp.viphotdog.Class

class User {
    //    Table
    var tableImage: Int? = null
    var tableName: String? = null
    var tableTime: String? = null
    var tableDate: String? = null

    //    Menu
    var menuImage: Int? = null
    var menuName: String? = null
    var menuPrice: String? = null

    //    Selectable
    var selectableName: String? = null
    var selectablePrice: String? = null
    var selectableCount: String? = null

    //    Arxiv
    var arxivName: String? = null
    var arxivPrice: String? = null
    var arxivCount: String? = null

    //    DataModel
    var dataModelTitle: String? = null

    constructor(tableImage: Int?, tableName: String?, tableTime: String?, tableDate: String?) {
        this.tableImage = tableImage
        this.tableName = tableName
        this.tableTime = tableTime
        this.tableDate = tableDate
    }

    constructor(menuImage: Int?, menuName: String?, menuPrice: String?) {
        this.menuImage = menuImage
        this.menuName = menuName
        this.menuPrice = menuPrice
    }

    constructor(selectableName: String?, selectablePrice: String?, selectableCount: String?) {
        this.selectableName = selectableName
        this.selectablePrice = selectablePrice
        this.selectableCount = selectableCount
    }

    constructor(dataModelTitle: String?) {
        this.dataModelTitle = dataModelTitle
    }
}