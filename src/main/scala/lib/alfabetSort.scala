package lib
//сравнивает два списка символов кто из них алфавитнее
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
def alfaMaxb(left: List[Char], right: List[Char]): List[Char] = {
  left match {
    case Nil=>{ right match{
     case Nil => List.empty
     case head::tail => left}
  } 
    case head :: tail =>{ right match{
      case Nil=> right
      case head::tail=>{
        if(left.head.toInt < right.head.toInt) left
        else if(left.head.toInt > right.head.toInt) right
        else alfaMax(left.tail,right.tail)
      }
    }}
  }
}
//Сортировка по алфавиту
def alfaSort(lst: List[List[Char]]): List[List[Char]] = {
  if (lst == List.empty) lst
  else {
    val pivot = lst(recursiveLength(lst) / 2)
    alfaSort(myFiltre(lst,(x=>if(alfaMax(x,pivot)==x)true else false))) ++
      myFiltre(lst,(x=>if(alfaMax(x,pivot)==List.empty)true else false)) ++
        myFiltre(lst, (x => if (alfaMax(x, pivot) == pivot) true else false))
  }
}

 