package com.algoritms.p;

public class PrimeNumberCheck {

    // функция проверяет - простое ли число n
    public boolean isPrime(int n)
    {
        // если n > 1
        if (n > 1)
        {
            // в цикле перебираем числа от 2 до n - 1
            for (int i = 2; i < n; i++)
                if (n % i == 0) // если n делится без остатка на i - возвращаем false (число не простое)
                    return false;

            // если программа дошла до данного оператора, то возвращаем true (число простое) - проверка пройдена
            return true;
        }
        else // иначе возвращаем false (число не простое)
            return false;
    }
}
