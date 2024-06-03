package org.example;

public class Cars {
        private String model;
        private int issueYear;
        private int mileage;

    @Override
    public String toString() {
        return "Cars{" +
                "model='" + model + '\'' +
                ", issueYear=" + issueYear +
                ", mileage=" + mileage +
                '}';
    }

    public Cars(String model, int issueYear, int mileage) {
            this.model = model;
            this.issueYear = issueYear;
            this.mileage = mileage;
        }

        public String getModel() {
            return model;
        }

        public int getIssueYear() {
            return issueYear;
        }

        public int getMileage() {
            return mileage;
        }
}
