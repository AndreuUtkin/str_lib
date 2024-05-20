package lib
//длинна массива
def recursiveLength(lst: List[_]):Int= {
  lst match {
    case Nil => 0
    case head :: tail => 1+recursiveLength(lst.tail)
  }
}
//сумма в массиве Int
def mySum(lst: List[Int]):Int={
  lst match {
    case Nil => 0
    case head :: tail => lst.head + recursiveLength(lst.tail)
  }
}
//сделаем свой рекурсивный map
def myMap[T,U](list: List[T],lambda: (T=>U) ):List[U]={
  list match {
    case Nil => List.empty
    case head :: tail => List(lambda(list.head)) ++ myMap(list.tail,lambda)
  }
}
//reverse инвертируем список
def myReverse[T](list: List[T]):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => myReverse(list.tail)++List(list.head)
  }
}
//свой рекурсивный count
def myCount[T,U](list: List[T],option: ((T)=>Boolean) ):Int={
  list match {
    case Nil => 0
    case head :: tail => if(option(head)) 1 + myCount(list.tail,option) else myCount(list.tail,option)
  }
}
 
