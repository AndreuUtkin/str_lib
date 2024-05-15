package lib
//своя длинна строки см lib.support
def lenght_string(str:String):Int=recursive_length(str.toList)
//посчитать символ в строке см li.support
def count_in_str(str:String,ch:Char):Int={
  my_count(str.toList,(_==ch))
}
//делим строку на слова см lib.word_cut
def word_cut(str:String): List[String] = {
  my_map(wordCut(str.toList),(x=>x.mkString))
}
//функция находящая уникальные слова в строке см lib.word_cut
def word_cut_unigue(str:String):List[String]={
  anti_dublicate(word_cut(str))
}
//самое короткое слово см lib.SorsFiltres
def shortest_word(str:String):String={
  sort_by(word_cut(str),lenght_string).head
}
//самое длинное слово см lib.SorsFiltres
def longest_word(str:String):String={
  my_reverse(sort_by(word_cut(str),lenght_string)).head
}
//см lib.SorsFiltres
def sort_words(str:String):List[String]={
  sort_by(word_cut(str),lenght_string)
}
//Делает строку капса см lib.UpperCase
def UpperString(str:String):String={
  UpperList(str.toList).mkString
}
//Выделяет капсом нужное слово см lib.UpperCase
def Find_word(str:String,charector:String):String={
  Spacer(my_map(word_cut(str),(x=>if(x==charector)UpperString(x) else x))).mkString
}
//Сортирует строку по алфавиту см lib.Alfabet_sort
def str_alfabet_sort(str:String):List[String]={
  my_map(alfaSort(my_map(word_cut(str), (x: String) => x.toList)),(x: List[Char]) => x.mkString)
}


