public abstract class Date {
    protected int year;
    protected int month;
    protected int day;

    protected int[] daysNormalYear = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    protected int[] daysLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMonth(){
        return this.month;
    }

    public int getYear() {
        return year;
    }

    public int getDayOfMonth(){
        return this.day;
    }

    public String getMonthName() {

        if (this.month == 1) {
            return "January";
        }
        if (this.month == 2) {
            return "February";
        }
        if (this.month == 3) {
            return "March";
        }
        if (this.month == 4) {
            return "April";
        }
        if (this.month == 5) {
            return "May";
        }
        if (this.month == 6) {
            return "June";
        }
        if (this.month == 7) {
            return "July";
        }
        if (this.month == 8) {
            return "August";
        }
        if (this.month == 9) {
            return "September";
        }
        if (this.month == 10) {
            return "October";
        }
        if (this.month == 11) {
            return "November";
        } else {
            return "December";
        }
    }

    public void printShortDate(){
        System.out.println(this.getMonthName() + " " + this.getDayOfMonth() + " " + this.getYear());
    }

    public void printLongDate() {
        System.out.println(this.getMonthName() + " " + this.getDayOfMonth() + " " + this.getYear());
    }

    public int numberOfDaysInMonth() {
        if (this.isLeapYear()) {
            return this.daysLeapYear[this.month];
        } else {
            return this.daysNormalYear[this.month];
        }
    }

    public void addDays(int increment) {
        for (int i = 0; i < increment; i++) {
            int numberOfDays = this.numberOfDaysInMonth();
            this.day = this.day + 1;

            if (this.day > numberOfDays) {
                this.day = 1;
                this.month = this.month + 1;
            }

            if (this.month == 13) {
                this.month = 1;
                this.year = this.year + 1;
            }
            ;
        }
    }

    public void subtractDays(int increment){
        for(int i = 0; i < increment; i++){

            this.day = this.day - 1;

            if(this.day == 0){
                this.month = this.month - 1;

                if(this.month == 0){
                    this.month = 12;
                    this.year = this.year - 1;
                };

                int numberOfDays = this.numberOfDaysInMonth();
                this.day = numberOfDays;
            }
        }
    }

    public abstract boolean isLeapYear();
}
