package SOLID


// high lvl module ((should not )) depend on low lvl modules
// both dep --> abstraction
//here : UserService depends on the Database interface, not a concrete MySQLDatabase,
//        making it easy to swap implementations.

interface Database {
    fun save(data: String)
}

class MySQLDatabase : Database {
    override fun save(data: String) = println("Saved to MySQL: $data")
}

class UserService(private val db: Database) { // Depends on abstraction
    fun saveUser(name: String) = db.save(name)
}

fun main() {
    val db = MySQLDatabase()
    val service = UserService(db)
    service.saveUser("Alice")
}