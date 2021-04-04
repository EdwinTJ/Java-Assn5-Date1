class GregorianDate{
    private int day;
    private int month;
    private int year;

    private int startingYear = 1970;
    private int startingMonth = 1;

    public GregorianDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;
        long currentTimeMillis = System.currentTimeMillis();
        long currentDays = 0;
        currentDays =  currentTimeMillis / (1000 * 60 * 60 *24);
        this.addDays((int)currentDays);
    }

    public GregorianDate(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int getDayOfMonth(){
        return this.day;
    }

    public void printShortDate(){
        System.out.println(this.getMonth() + "/" + this.getDayOfMonth() + "/" + this.getYear() + "/");
    }

    public void printLongDate(){
        System.out.println(this.getMonthName() + " " + this.getDayOfMonth() + " " + this.getYear() + " ");
    }

    public void addDays(int increment) {
        int days = this.getDays() + increment;
        this.calculateDayMonthYear(days);
    }

    public void subtractDays(int increment){
        int days = this.getDays() - increment;
        this.calculateDayMonthYear(days);
    }

    public int getDays() {
        int temp = calculateMonthDays(this.month, this.year);
        int days = calculateYearDays(this.year);
        days += temp;
        return days + this.day;
    }

    public boolean isLeapYear(){
        if (((this.year % 4 == 0) && (this.year % 100!= 0)) || (this.year%400 == 0))
            return  true;
        else
            return  false;
    }

    private void calculateDayMonthYear(int days)
    {
        int decrement = daysInYear(this.startingYear);
        while (days > decrement) {
            days -= decrement;
            decrement = daysInYear(++this.startingYear);
        }

        int month = 1;
        decrement = daysInMonth(month, this.startingYear);
        while (days > decrement) {
            days -= decrement;
            decrement = daysInMonth(++month, this.startingYear);
        }

        this.month = month;
        this.day = days;
        this.year = this.startingYear;
    }

    private int daysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2) {
            if (daysInYear(year) > 365) {
                return days[month - 1] + 1;
            }
        }

        return days[month - 1];
    }

    private int daysInYear(int year) {
        int days = 365;

        if ((year % 4) == 0) {
            if ((year % 100) == 0) {
                if ((year % 400) == 0) {
                    days++;
                }
            } else {
                days++;
            }
        }

        return days;
    }

    private int calculateYearDays(int year) {
        int days = 0;

        for (int i = this.startingYear; i < year; i++) {
            days += daysInYear(i);
        }

        return days;
    }

    private int calculateMonthDays(int month, int year) {
        int days = 0;

        for (int i = this.startingMonth; i < month; i++) {
            days += daysInMonth(i, year);
        }

        return days;
    }

    public String getMonthName(){

        if (this.month == 1) {
            return "January";
        }
        if (this.month== 2) {
            return "February";
        }
        if (this.month == 3) {
            return "March";
        }
        if (this.month== 4) {
            return "April";
        }
        if (this.month== 5) {
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
        if (this.month== 11) {
            return "November";
        }
        else {
            return "December";
        }
    }
}