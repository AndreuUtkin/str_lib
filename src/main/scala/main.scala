import lib.{*}
@main
def main(): Unit = {
  //Дана строка. Если она начинается на 'abc', то заменить их на 'www',
  // иначе добавить в конец строки 'zzz'.
  val str="abcdef"
  println(if(mySubString(str,0,3)=="abc")"www"++mySubString(str,3,lenghtString(str)) else str++"zzz")
  //Замените в строке все вхождения 'word' на 'letter'.
  val word="listen to my word"
  println(spacer(myMap(wordCutStr(word),(x=>if(x=="word")"letter" else x))).mkString)
  //Дана строка. Определить, содержит ли строка только символы 'a', 'b', 'c' или нет.
  val abac="abac"
  val abaList=abac.toList
  println(if(myCount(abaList,(x=>if(x=='a'|| x=='b' || x=='c') true else false))==lenghtString(abac)) true else false)
  //Найдите количество вхождения 'aba' в строку.
  val aba="ababaka"
  val subAba="aba"
  println(mySum(myMap(mySliding(aba,lenghtString(subAba)), (x=>if(x=="aba")1 else 0))))
  //Напечатать все слова, которые состоят из тех же букв что и последнее слово текста
  val txt="cab bac lol abc"
  val txtWords=wordCutStr(txt)
  println(myFilter(txtWords,x=>if(sortBy(x.toList,x=>x.toInt)==sortBy(txtWords.last.toList,x=>x.toInt))true else false))
  //Напечатать самое длинное слово на букву 'a'
  val longA="allocate ale cucumbers"
  val wordsLongA=wordCutStr(longA)
  val filtredLonga=myFilter(wordsLongA,x=>if(x.toList.head=='a')true else false)
  val resultLonga=sortBy(filtredLonga,lenghtString).last
  println(resultLonga)

}
