class Bank {

    fun save(account: Account, money: Int) {
        if (money >= 0) account.balance += money
        else println("마이너스는 예금 불가능")
    }

    fun withdraw(account: Account, money: Int) {
        if (account.checkBalance() >= money) account.balance -= money
        else println("잔액부족")
    }
}

class Account(val initBalance: Int = 0) {
    var balance: Int = 0



    init {
        this.balance = initBalance
    }

    fun checkBalance(): Int {
        return balance
    }
}

val account = Account(1000)
val bank = Bank()

println(account.checkBalance())

bank.save(account, 1000)

println(account.checkBalance())

/////////////////////////////////////////////////////////
class Bank2 {
    fun save(account: Account2, money: Int) {
        if (money >= 0) account.balance += money
        else println("마이너스는 예금할 수 없습니다.")
    }

    fun withdraw(account: Account2, money: Int) {
        if (money <= account.balance) account.balance -= money
        else println("잔액부족")
    }
}

class Account2 {
    var balance: Int = 0

    fun checkBalance() : Int{
        return balance
    }
}

val user2 = Account2()
println(user2.checkBalance())

val bank2 = Bank2()
bank2.save(user2, 333)
println(user2.checkBalance())

bank2.withdraw(user2, 222)

println(user2.checkBalance())