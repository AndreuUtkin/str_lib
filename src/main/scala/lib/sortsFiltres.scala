package lib
//quicksort для списка Int
def myQuickSort(lst: List[Int]): List[Int] = {
  if (lst==List.empty) lst
  else {
    val pivot = lst(recursiveLength(lst) / 2)
    myQuickSort(myFilter(lst,(_ < pivot)) ++
      myFilter(lst,(_ == pivot)) ++
      myQuickSort(myFilter(lst,(_ > pivot))))
  }
}
//моя реализация фильтра
def myFilter[T](list: List[T],option: ((T)=>Boolean) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(head)) List(list.head) ++ myFilter(list.tail,option) else myFilter(list.tail,option)
  }
}
//фильтр которые фильтрует элементы списка в зависимости от результата возвращаемой функции
def filterBy[T](list: List[T],option: ((Int)=>Boolean),lambda: (T=>Int) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(lambda(head))) List(list.head) ++ filterBy(list.tail,option,lambda) else filterBy(list.tail,option,lambda)
  }
}
//сортировка в зависимости от результатов возвращаемой функции
def sortBy[T](lst: List[T],lambda:(T=>Int)): List[T] = {
  if (lst==List.empty) lst
  else {
    val pivot = lambda(lst(recursiveLength(lst) / 2))
    sortBy(filterBy(lst,(_ < pivot),lambda),lambda) ++
      filterBy(lst,(_ == pivot),lambda) ++
      sortBy(filterBy(lst,(_ > pivot),lambda),lambda)
  }
}
 
