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
def alfaMax(left:List[Char],right:List[Char]):List[Char]={
  left match {
    case Nil if(right==List.empty) => List.empty
    case Nil if(right!=List.empty) =>left
    case head::tail if(right==List.empty) => right
    case head::tail if(right!=List.empty)=>{
      if(left.head.toInt < right.head.toInt) left
      else if(left.head.toInt > right.head.toInt) right
      else alfaMax(left.tail,right.tail)
    }
  }
}

def alfaSort(lst: List[List[Char]]): List[List[Char]] = {
  if (lst == List.empty) lst
  else {
    val pivot = lst(recursive_length(lst) / 2)
    alfaSort(my_filtre(lst,(x=>if(alfaMax(x,pivot)==x)true else false))) ++
      my_filtre(lst,(x=>if(alfaMax(x,pivot)==List.empty)true else false)) ++
        my_filtre(lst, (x => if (alfaMax(x, pivot) == pivot) true else false))
  }
}

 