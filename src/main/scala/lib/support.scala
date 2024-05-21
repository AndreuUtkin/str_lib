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
    case head :: tail => lst.head + mySum(lst.tail)
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
def mySubList[T](lst:List[T],start:Int,stop:Int):List[T]={
  val lenght=recursiveLength(lst)
  if(start<0 || stop<0 || start> lenght||stop> lenght|| stop<start) throw new ArithmeticException("Illegal")
  myTake(myDrop(lst,start),stop-start)
}
def myDrop[T](lst:List[T],it:Int):List[T]={
  lst match {
    case Nil => List.empty
    case head :: tail => if(it==0) lst else myDrop(lst.tail,it-1)
  }
}
def myTake[T](lst:List[T],it:Int):List[T]={
  lst match {
    case Nil => List.empty
    case head :: tail => if(it==0) List.empty else lst.head::myTake(lst.tail,it-1)
  }
}
def mySlidingList[T](lst:List[T],num:Int):List[List[T]]={
  lst match {
    case Nil => List.empty
    case head :: tail => if(recursiveLength(lst.tail)>=num) List(lst.head::mySubList(lst.tail,0,num-1))++mySlidingList(lst.tail,num) else List.empty
  }
}
 
