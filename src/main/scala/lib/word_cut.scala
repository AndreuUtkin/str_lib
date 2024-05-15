package lib
//функция сохраняет список пока option==true
def myTakeWhile[T](lst:List[T],option: T=>Boolean):List[T]={
  lst match {
    case Nil => List.empty
    case head :: tail => if(option(lst.head)) List(lst.head)++myTakeWhile(lst.tail,option) else List.empty
  }
}
//функция обратная предыдущей
def myDropWhile[T](lst: List[T], option: T => Boolean): List[T] = {
  lst match {
    case Nil => List.empty
    case head :: tail => if (option(lst.head)) myDropWhile(lst.tail, option) else lst.tail
  }
}
//делим строку на слова
def wordCut(lst:List[Char]):List[List[Char]]={
  lst match {
    case Nil => List.empty
    case head :: tail => List(myTakeWhile(lst,(_!=' ')))++wordCut(myDropWhile(lst,(_!=' ')))
  }
}
// функция находящая элемент в массиве
def ifexist(list:List[_],character: Any):Boolean= {
  list match {
    case Nil => false
    case head :: tail => {
      if (list.head == character) true else ifexist(list.tail, character)
    }
  }
}

//функция удаляющая дубликаты из массива
def anti_dublicate[T](list:List[T]):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if (ifexist(list.tail,list.head)) list.tail else List(list.head) ++ list.tail
  }
}
//вставляет пробелы
def Spacer(lst:List[String]):List[String]= {
  lst match {
    case Nil => lst
    case head :: tail => {
      List(lst.head, " ") ++ Spacer(lst.tail)
    }
  }
}
