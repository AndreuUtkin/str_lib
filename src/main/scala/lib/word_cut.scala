package lib
// делим строку на слова
def wordcut(list: List[Char], list2:List[String], list3: List[Char] ):List[String]  = {
  list match {
    case Nil => list2
    case head :: tail => { if (list.head == ' ')
    {
      wordcut(list.tail,list2++List(list3.mkString),List.empty)
    }
    else
    {
      wordcut(list.tail,list2,list3++List(list.head))
    }
    }
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
