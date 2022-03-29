package main;

import java.util.ArrayList;
import java.util.Random;

public class main {

    public static void main(String[] args){

        List list = new List();

        list.manualList(10);
        list.manualList(5);
        list.manualList(90);
        list.manualList(100);
        list.manualList(150);
        list.manualList(0);
        list.manualList(50);

        list.printList();

        list.bubbleSorter();

        list.printList();

        list.manualList(200);
        list.manualList(650);
        list.manualList(550);

        list.printList();

        list.selectionSort();

        list.printList();


    }
}

class List{

    private ArrayList<Double> list = new ArrayList<>();
    private Random rand;

    public void fullAutoList(int countNumber){
        for (int i = 0; i < countNumber; i++){
            list.add(rand.nextDouble());
        }
    }

    public boolean manualList(double number){
        return list.add(number);
    }

    public ArrayList<Double> getList() {
        return list;
    }

    public void setList(ArrayList<Double> list) {
        this.list = list;
    }

    public double getElemList(int indexElement){
        try {
            return list.get(indexElement);
        } catch (Exception e) {
            System.out.println("Нет такого элемента по такому индексу");
            System.out.print("Индекс последнего элемента: ");
            return (list.size()-1);
        }
    }

    public void setIndexElemList(int indexElemList, double elem){
        list.set(indexElemList,elem);
    }

    public void removeElemList(int indexElement){
        try {
            list.remove(indexElement);
        } catch (Exception E){
            System.out.println("Нет такого элемента по такому индексу");
            System.out.print("Индекс последнего элемента: " + (list.size()-1));
        }
    }

    public void bubbleSorter(){
        for(int out = list.size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(list.get(in) > list.get(in + 1)){
                    toSwap(in, in + 1);
                }
            }
        }
    }

    private void toSwap(int firstElem, int secondElem){
        double nn = list.get(firstElem);
        list.set(firstElem,list.get(secondElem));
        list.set(secondElem, nn);
    }

    public void printList(){
        for (double d: list
             ) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

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
