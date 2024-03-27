package org.example;

import java.util.ArrayList;

public class MontiHoll {
    public MontiHoll(int amt) {
        int countWinFirst = 0;
        int buf = amt;
        while (0 < buf) {
            ArrayList<Integer> doors = new ArrayList<>(3);
            doors.add(0);
            doors.add(1);
            doors.add(2);
            ArrayList<Integer> closeDoors = new ArrayList<>();
            closeDoors.addAll(doors);

            int result = doors.get((int) (Math.random() * (doors.size()-1)));//Правильный ответ
            int choise = doors.get((int) (Math.random() * (doors.size()-1)));//Ваш выбор

            //Убираем для открытия двери и для смены выбора
            if (choise!=result) {
                closeDoors.remove(closeDoors.indexOf(result));
            }
            System.out.println("Выбор: " + choise + " результат: " + result);

            closeDoors.remove(closeDoors.indexOf(choise));
            doors.remove(doors.indexOf(choise));

            System.out.println(doors);
            System.out.println(closeDoors);

            //Открываем дверь, которую не выбрали и не результат
            int open = closeDoors.get((int) (Math.random() * (closeDoors.size()-1)));
            System.out.println("Ваш ответ: " + choise + " открваем дверь под номером " + open);

            doors.remove(doors.indexOf(open));

            System.out.println(doors);
            System.out.println(closeDoors);

            //Смена выбора
            for(int i : doors){
                if(i!=choise) {
                    choise = i;
                    break;
                }
            }

            System.out.println("Меняем результат на дверь под номером: " + choise);
            System.out.println("Результат: " + result);

            buf--;
            if(choise==result){
                countWinFirst++;
            }
            System.out.println();
        }
        int countWinSecond = 0;
        buf=amt;
        while (0 < buf) {
            ArrayList<Integer> doors = new ArrayList<>(3);
            doors.add(0);
            doors.add(1);
            doors.add(2);
            ArrayList<Integer> closeDoors = new ArrayList<>();
            closeDoors.addAll(doors);

            int result = doors.get((int) (Math.random() * (doors.size()-1)));//Правильный ответ
            int choise = doors.get((int) (Math.random() * (doors.size()-1)));//Ваш выбор

            //Убираем для открытия двери и для смены выбора
            if (choise!=result) {
                closeDoors.remove(doors.indexOf(result));
            }
            System.out.println("Выбор: " + choise + " результат: " + result);

            closeDoors.remove(doors.indexOf(choise));
            doors.remove(doors.indexOf(choise));

            System.out.println(doors);
            System.out.println(closeDoors);

            //Открываем дверь, которую не выбрали и не результат
            int open = doors.get((int) (Math.random() * (closeDoors.size()-1)));
            System.out.println("Ваш ответ: " + choise + " открваем дверь под номером " + open);

            doors.remove(doors.indexOf(open));

            System.out.println(doors);
            System.out.println(closeDoors);

            System.out.println("Результат: " + result);

            buf--;
            if(choise==result){
                countWinSecond++;
            }
            System.out.println();
        }
        System.out.println("При замене ответа вероятность верного решения: " + ((double)countWinFirst/amt)*100 + " %");
        System.out.println("Без замены ответа вероятность верного решения: " + ((double)countWinSecond/amt)*100 + " %");
    }
}
