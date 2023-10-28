//задача 2.3
// Имеется массив из символов русского алфавита (все 33 символа, могут быть не по порядку).
// Символы алфавита нумеруются от 1 до 33. Каждое число используется только один раз.
// Сообщение шифруется с помощью ключевого слова, задаваемого пользователем.
// Номер символа ключевого слова показывает, на сколько нужно сдвинуться по массиву из символов русского алфавита.
// Составить программу шифровки и дешифровки строкового выражения (то есть программа спрашивает - зашифровать или расшифровать текст и ключевое слово).
// Первый массив считать закольцованным. Регистр букв не имеет значения.
val alphabets = ('а'..'я').toMutableList()

fun main() {


    print("Данная программа шифрует и расшифровывает слова ")
    val number = UserInput()
    if(number==1){
        print("Введите ключевое слово:")
        val key= readln().lowercase()

        print("Введите исходное слово:")
        val text= readln().lowercase()
        val encryptedText=Encrypt(key,text)
        print("Зашифрованное сообщение: $encryptedText")
    }
    else{
        print("Введите ключевое слово:")
        val key= readln().lowercase()

        print("Введите зашифрованное слово, которое хотите расшифровать:")
        val text= readln().lowercase()
        val cryptedText= Crypts(key,text)
        print("Зашифрованное сообщение: $cryptedText")
    }
}

fun UserInput(): Int {
    while(true){
        print("Выберете действие:\n" +
                " 1.Зашифровать\n" +
                " 2.Расшифровать\n")
        val number = readln()
        if (number.toString()=="1" || number.toString()=="2")
            return number.toInt()
        else println("Неправильный ввод! Попробуйте еще раз!")
    }
}
fun Encrypt(key:String, text:String):String{
    val msg=text
    var result = ""
    var i = 0
    var j = 0
    alphabets += 'ё'
    while (j < msg.length) {
        result += alphabets[(alphabets.indexOf(msg[j]) + alphabets.indexOf(key[i])) % (alphabets.size)]
        j++
        i = (i + 1) % key.length
    }
    return result
}

fun Crypts(key:String, text:String):String{
    val msg=text
    var result = ""
    var i = 0
    var j = 0
    alphabets += 'ё'
    while (j < msg.length) {
        result += alphabets[(alphabets.indexOf(msg[j]) - alphabets.indexOf(key[i])+alphabets.size) % alphabets.size]
        j++
        i = (i + 1) % key.length
    }
    return result
}