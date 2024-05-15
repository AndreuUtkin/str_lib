package lib
//длинна массива
def recursive_length(lst: List[_]):Int= {
  lst match {
    case Nil => 0
    case head :: tail => 1+recursive_length(lst.tail)
  }
}
//сумма в массиве Int
def my_sum(lst: List[Int]):Int={
  lst match {
    case Nil => 0
    case head :: tail => lst.head + recursive_length(lst.tail)
  }
}
//сделаем свой рекурсивный map
def my_map[T,U](list: List[T],lambda: (T=>U) ):List[U]={
  list match {
    case Nil => List.empty
    case head :: tail => List(lambda(list.head)) ++ my_map(list.tail,lambda)
  }
}
//reverse инвертируем список
def my_reverse[T](list: List[T]):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => my_reverse(list.tail)++List(list.head)
  }
}
//свой рекурсивный count
def my_count[T,U](list: List[T],option: ((T)=>Boolean) ):Int={
  list match {
    case Nil => 0
    case head :: tail => if(option(head)) 1 + my_count(list.tail,option) else my_count(list.tail,option)
  }
}
 
