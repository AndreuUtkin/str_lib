package lib
//quicksort для списка Int
def my_quickSort(lst: List[Int]): List[Int] = {
  if (lst==List.empty) lst
  else {
    val pivot = lst(recursive_length(lst) / 2)
    my_quickSort(my_filtre(lst,(_ < pivot)) ++
      my_filtre(lst,(_ == pivot)) ++
      my_quickSort(my_filtre(lst,(_ > pivot))))
  }
}
//моя реализация фильтра
def my_filtre[T](list: List[T],option: ((T)=>Boolean) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(head)) List(list.head) ++ my_filtre(list.tail,option) else my_filtre(list.tail,option)
  }
}
//фильтр которые фильтрует элементы списка в зависимости от результата возвращаемой функции
def filtre_by[T](list: List[T],option: ((Int)=>Boolean),lambda: (T=>Int) ):List[T]={
  list match {
    case Nil => List.empty
    case head :: tail => if(option(lambda(head))) List(list.head) ++ filtre_by(list.tail,option,lambda) else filtre_by(list.tail,option,lambda)
  }
}
//сортировка в зависимости от результатов возвращаемой функции
def sort_by[T](lst: List[T],lambda:(T=>Int)): List[T] = {
  if (lst==List.empty) lst
  else {
    val pivot = lambda(lst(recursive_length(lst) / 2))
    sort_by(filtre_by(lst,(_ < pivot),lambda),lambda) ++
      filtre_by(lst,(_ == pivot),lambda) ++
      sort_by(filtre_by(lst,(_ > pivot),lambda),lambda)
  }
}
 
