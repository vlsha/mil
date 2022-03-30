package main;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        List firstList = new List();
        List secondList = new List();

        firstList.manualList(50);
        firstList.manualList(10);
        firstList.manualList(1000);
        firstList.manualList(55);

        firstList.printList();
        firstList.selectionSort();
        firstList.printList();

        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();

        secondList.fullAutoList(4);
        secondList.printList();
        secondList.bubbleSorter();
        secondList.printList();

    }
}

class List{

    private ArrayList<Double> list = new ArrayList<>();
    private Random rand = new Random();

//  автоматическое заполнение листа на опредленное количества элемента
    public void fullAutoList(int countNumber){
        for (int i = 0; i < countNumber; i++){
            list.add(rand.nextDouble()+rand.nextInt());
        }
    }
//  ручное добавление элемента в конец списка
    public boolean manualList(double number){
        return list.add(number);
    }

    public void setList(ArrayList<Double> list) {
        this.list = list;
    }

//  получение элемента списка
    public double getElemList(int indexElement){
        try {
            return list.get(indexElement);
        } catch (Exception e) {
            System.out.println("Нет такого элемента по такому индексу");
            System.out.print("Индекс последнего элемента: ");
            return (list.size()-1);
        }
    }

//    добавлние элемента по индексу
    public void setIndexElemList(int indexElemList, double elem){
        list.set(indexElemList,elem);
    }

    //метод для удаления элемента по индексу
    public void removeElemList(int indexElement){
        try {
            list.remove(indexElement);
        } catch (Exception E){
            System.out.println("Нет такого элемента по такому индексу");
            System.out.print("Индекс последнего элемента: " + (list.size()-1));
        }
    }
//  сортировка пузырком
    public void bubbleSorter(){
        for(int out = list.size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(list.get(in) > list.get(in + 1)){
                    toSwap(in, in + 1);
                }
            }
        }
    }
//  метод, который менят элементы списка местами
    private void toSwap(int firstElem, int secondElem){
        double nn = list.get(firstElem);
        list.set(firstElem,list.get(secondElem));
        list.set(secondElem, nn);
    }

//  вывод списка
    public void printList(){
        for (double d: list
             ) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

//    сортировка отбором
    public void selectionSort(){
        for (int i = 0; i < list.size(); i++){
            double min = list.get(i);
            int minId = i;
            for (int j = i+1;j < list.size(); j++){
                if (list.get(j) < min){
                    min = list.get(j);
                    minId = j;
                }
            }
            double nn = list.get(i);
            list.set(i, min);
            list.set(minId, nn);
        }
    }
}
