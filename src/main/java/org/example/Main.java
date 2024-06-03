package org.example;
public class Main {
    public static void main(String[] args) {
            Cars firstCar = new Cars("Honda", 2015, 162);
            Cars secondCar = new Cars("BMW", 2023, 15);

            Cars[] cars = {firstCar, secondCar};

            for (int i=0; i<cars.length; i++){
                if (cars[i].getIssueYear()<2020) {
                    System.out.print(cars[i]);
                }
            }
        }
    }