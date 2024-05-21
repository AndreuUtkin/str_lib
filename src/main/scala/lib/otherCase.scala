package lib
def ifNumber(ch:Char):Boolean={
  if (ch.toInt > 47 && ch.toInt < 58) true else false
}
def ifUpperEng(ch:Char):Boolean={
  if(ch.toInt>64 && ch.toInt<91) true else false
}
def ifLowerEng(ch: Char): Boolean = {
  if (ch.toInt > 96 && ch.toInt < 123) true else false
}
def ifUpperRus(ch: Char): Boolean = {
  if (ch.toInt > 1039 && ch.toInt < 1072) true else false
}
def ifLowerRus(ch: Char): Boolean = {
  if (ch.toInt > 1071 && ch.toInt < 1104) true else false
}
def otherCase(ch: Char):Char={
 if(ifUpperEng(ch)||ifUpperRus(ch)) (ch.toInt+32).toChar else 
  if (ifLowerEng(ch) || ifLowerRus(ch)) (ch.toInt - 32).toChar else ch
  
}

//функция преобразовывающая список строчных букв в список Заглавных букв
def otherList(lst:List[Char]):List[Char] ={
  lst match {
    case Nil => List.empty
    case head :: tail => List(otherCase(lst.head))++otherList(lst.tail)
  }
}

