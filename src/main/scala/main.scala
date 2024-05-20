import lib.{*}
@main
def main(): Unit = {
  // Функции обработки строк в файле lib.functions
val str="one two three four five six seven eight nine ten"
  println("Строка :"+str)
  //lenght_string считает длинну строки
  println("Длинна строки ="+lenghtString(str))
  //count_in_str считает появления символа
  println("Символ 'o' встречается: "+count_in_str(str,'o'))
  //word_cut возвращает список слов
  println("Спиок слов :"+wordCutStr(str))
//shortest_word возвращает первое слово в списке слов отсортированном по длинне в порядке возрастания
println("Самое короткое слово: "+shortestWord(str))
//longest_word возвращает последнее слово в списке слов по возрастанию
  println("Самое длинное слово: "+longestWord(str))
  //сам список
  println("Слова по возрастанию длинны: "+ sortWords(str))
  //Find_word отмечает указанное слово капсом если оно есть
  println("Слово 'five' :" +findWord(str,"five"))
//str_alfabet_sort сортирует слова по алфовиту
println("Сортировка по алфовиту : "+strAlfabetSort(str))

}
