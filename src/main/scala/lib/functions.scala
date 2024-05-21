package lib
//своя длинна строки см lib.support
def lenghtString(str:String):Int=recursiveLength(str.toList)
//посчитать символ в строке см li.support
def count_in_str(str:String,ch:Char):Int={
  myCount(str.toList,(_==ch))
}
//делим строку на слова см lib.word_cut
def wordCutStr(str:String): List[String] = {
  myMap(wordCut(str.toList),(x=>x.mkString))
}
//функция находящая уникальные слова в строке см lib.word_cut
def wordCutUnigue(str:String):List[String]={
  antiDublicate(wordCutStr(str))
}
//самое короткое слово см lib.SorsFiltres
def shortestWord(str:String):String={
  sortBy(wordCutStr(str),lenghtString).head
}
//самое длинное слово см lib.SorsFiltres
def longestWord(str:String):String={
  myReverse(sortBy(wordCutStr(str),lenghtString)).head
}
//см lib.SorsFiltres
def sortWords(str:String):List[String]={
  sortBy(wordCutStr(str),lenghtString)
}
//Делает строку капса см lib.UpperCase
def upperString(str:String):String={
  otherList(str.toList).mkString
}
//Выделяет капсом нужное слово см lib.UpperCase
def findWord(str:String,charector:String):String={
  spacer(myMap(wordCutStr(str),(x=>if(x==charector)upperString(x) else x))).mkString
}
//Сортирует строку по алфавиту см lib.Alfabet_sort
def strAlfabetSort(str:String):List[String]={
  myMap(alfaSort(myMap(wordCutStr(str), (x: String) => x.toList)),(x: List[Char]) => x.mkString)
}
def strMap(list: String,lambda: (Char=>Any) ):List[Any]={
  myMap(list.toList,lambda)
}
def mySubString(str:String,start:Int,stop:Int):String={
  mySubList(str.toList,start,stop).mkString
}
def mySliding(str:String,num:Int):List[String]={
  myMap(mySlidingList(str.toList,num),(x=>x.mkString))
}
