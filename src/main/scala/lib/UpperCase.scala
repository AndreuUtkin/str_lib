package lib
//функция возвращающая заглавную букву в ответ на строчную
def Upper(ch:Char):Char={
  ch match {
    case 'a' => 'A'
    case 'b' => 'B'
    case 'c' => 'C'
    case 'd' => 'D'
    case 'e' => 'E'
    case 'f' => 'F'
    case 'g' => 'G'
    case 'h' => 'H'
    case 'i' => 'I'
    case 'j' => 'J'
    case 'k' => 'K'
    case 'l' => 'L'
    case 'm' => 'M'
    case 'n' => 'N'
    case 'o' => 'O'
    case 'p' => 'P'
    case 'q' => 'Q'
    case 'r' => 'R'
    case 's' => 'S'
    case 't' => 'T'
    case 'u' => 'U'
    case 'v' => 'V'
    case 'w' => 'W'
    case 'x' => 'X'
    case 'y' => 'Y'
    case 'z' => 'Z'
    case 'а' => 'А'
    case 'б' => 'Б'
    case 'в' => 'В'
    case 'г' => 'Г'
    case 'д' => 'Д'
    case 'е' => 'Е'
    case 'ё' => 'Ё'
    case 'ж' => 'Ж'
    case 'з' => 'З'
    case 'и' => 'И'
    case 'й' => 'Й'
    case 'к' => 'К'
    case 'л' => 'Л'
    case 'м' => 'М'
    case 'н' => 'Н'
    case 'о' => 'О'
    case 'п' => 'П'
    case 'р' => 'Р'
    case 'с' => 'С'
    case 'т' => 'Т'
    case 'у' => 'У'
    case 'ф' => 'ф'
    case 'х' => 'Х'
    case 'ц' => 'Ц'
    case 'ч' => 'Ч'
    case 'ш' => 'Ш'
    case 'щ' => 'Щ'
    case 'ы' => 'Ы'
    case 'ь' => 'Ь'
    case 'ъ' => 'Ъ'
    case 'э' => 'Э'
    case 'ю' => 'Ю'
    case 'я' => 'Я'
    case x => x
  }
}
//функция преобразовывающая список строчных букв в список Заглавных букв
def UpperList(lst:List[Char]):List[Char] ={
  lst match {
    case Nil => List.empty
    case head :: tail => List(Upper(lst.head))++UpperList(lst.tail)
  }
}

