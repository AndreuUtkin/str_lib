package lib
//сравнивает два списка символов кто из них алфавитнее
def alfaMax(left: List[Char], right: List[Char]): List[Char] = {
  (left, right) match {
    case (Nil, Nil) => List.empty
    case (Nil,h::t)=>left
    case(h::t,Nil)=>right
    case (lh::lt, rh::rt) if (lh.toInt < rh.toInt) => left
    case (lh :: lt, rh :: rt) if (lh.toInt > rh.toInt) => right
    case (lh :: lt, rh :: rt) => lh::alfaMax(lt, rt)
  }
}

//Сортировка по алфавиту
def alfaSort(lst: List[List[Char]]): List[List[Char]] = {
  if (lst == List.empty) lst
  else {
    val pivot = lst(recursiveLength(lst) / 2)
    alfaSort(myFilter(lst,(x=>if(alfaMax(x,pivot)==x && x!=pivot)true else false))) ++
      myFilter(lst,(x=>if(x==pivot)true else false)) ++
       alfaSort( myFilter(lst, (x => if (alfaMax(x, pivot) == pivot && x!=pivot) true else false)))
  }
}

 