package lib
//сравнивает два списка символов кто из них алфавитнее
def which_alfabetter(left:List[Char],right:List[Char]):Char= {
  if((left==List.empty)&&(right!=List.empty)) 'l'
  else if((left!=List.empty)&&(right==List.empty)) 'r'
  else if((left==List.empty)&&(right==List.empty)) 'e'
  else if(left.head.toInt < right.head.toInt)'l'//чем раньше буква в ASCII тем меньше её номер
  else if(left.head.toInt > right.head.toInt)'r'
  else if(left.head.toInt == right.head.toInt) which_alfabetter(left.tail,right.tail)
  else '?'
}
//модификация my_filtre для функции which_alfabetter см lib.SorsFiltres
def filtre_by_alfabet(list: List[List[Char]],option: Char,pivot:List[Char]):List[List[Char]]={
  list match {
    case Nil => List.empty
    case head :: tail => if(which_alfabetter(head,pivot)==option) List(list.head) ++ filtre_by_alfabet(list.tail,option,pivot) else filtre_by_alfabet(list.tail,option,pivot)
  }
}
//переделанный sort_by для filtre_by_alfabet см. lib.SorsFiltres
def sort_by_alfabet(lst: List[List[Char]]): List[List[Char]] = {
  if (lst==List.empty) lst
  else {
    val pivot = lst(recursive_length(lst) / 2)
    sort_by_alfabet(filtre_by_alfabet(lst,'l',pivot)) ++
      filtre_by_alfabet(lst,'e',pivot) ++
      sort_by_alfabet(filtre_by_alfabet(lst,'r',pivot))
  }
}
 