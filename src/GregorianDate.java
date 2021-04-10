class GregorianDate extends Date{

    private int startingYear = 1970;
    private int startingMonth = 1;

    public GregorianDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1970;

        long currentTimeMillis = System.currentTimeMillis();
        long currentDays = 0;
        long currentTimeMillisOffset = java.util.TimeZone.getDefault().getRawOffset();
        currentDays = Math.round((currentTimeMillis + currentTimeMillisOffset) / (1000 * 60 * 60 * 24));
        System.out.println(currentDays);
        this.addDays((int) currentDays);
    }

    public GregorianDate(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean isLeapYear(){
        if (((this.year % 4 == 0) && (this.year % 100!= 0)) || (this.year%400 == 0))
            return  true;
        else
            return  false;
    }

}