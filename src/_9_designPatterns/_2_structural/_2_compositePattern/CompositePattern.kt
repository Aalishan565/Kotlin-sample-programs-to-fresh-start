package _9_designPatterns._2_structural._2_compositePattern

/**
 * CompositePattern.kt
 * Composes objects into tree structures to represent part-whole hierarchies.
 */
fun main() {
    println("--- Composite Pattern ---")

    val eng: Employee = Engineer("Aalishan", 101, "Engineering")
    val sales: Employee = SalesMan("Santosh", 102, "Sales")
    val hr: Employee = HRs("Alice", 103, "Human Resources")

    val employees = listOf(eng, sales, hr)

    println("Employee Directory:")
    for (e in employees) {
        println(" -> ${e.getEmployeeDetails()}")
    }
}

interface Employee {
    fun getEmployeeDetails(): String
}

class Engineer(val name: String, val id: Int, val department: String) : Employee {
    override fun getEmployeeDetails(): String {
        return "Engineer [Name: $name, ID: $id, Dept: $department]"
    }
}

class SalesMan(val name: String, val id: Int, val department: String) : Employee {
    override fun getEmployeeDetails(): String {
        return "SalesMan [Name: $name, ID: $id, Dept: $department]"
    }
}

class HRs(val name: String, val id: Int, val department: String) : Employee {
    override fun getEmployeeDetails(): String {
        return "HR [Name: $name, ID: $id, Dept: $department]"
    }
}
