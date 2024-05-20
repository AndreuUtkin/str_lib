package lib
//quicksort для списка Int
def myQuickSort(lst: List[Int]): List[Int] = {
  if (lst==List.empty) lst
  else {
    val pivot = lst(recursiveLength(lst) / 2)
    myQuickSort(myFiltre(lst,(_ < pivot)) ++
      myFiltre(lst,(_ == pivot)) ++
      myQuickSort(myFiltre(lst,(_ > pivot))))
  }
}
//моя реализация фильтра
def myFiltre[T](list: List[T],option: ((T)=>Boolean) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(head)) List(list.head) ++ myFiltre(list.tail,option) else myFiltre(list.tail,option)
  }
}
//фильтр которые фильтрует элементы списка в зависимости от результата возвращаемой функции
def filtreBy[T](list: List[T],option: ((Int)=>Boolean),lambda: (T=>Int) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(lambda(head))) List(list.head) ++ filtreBy(list.tail,option,lambda) else filtreBy(list.tail,option,lambda)
  }
}
//сортировка в зависимости от результатов возвращаемой функции
def sortBy[T](lst: List[T],lambda:(T=>Int)): List[T] = {
  if (lst==List.empty) lst
  else {
    val pivot = lambda(lst(recursiveLength(lst) / 2))
    sortBy(filtreBy(lst,(_ < pivot),lambda),lambda) ++
      filtreBy(lst,(_ == pivot),lambda) ++
      sortBy(filtreBy(lst,(_ > pivot),lambda),lambda)
  }
}
 
