class JulianDate extends Date{


    private int startingYear = 1;
    private int startingMonth = 1;


    public JulianDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1;

        this.addDays(719164);

        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillisOffset = java.util.TimeZone.getDefault().getRawOffset();

        long currentDays = 0;
        currentDays = (currentTimeMillis) / (1000 * 60 * 60 * 24);
        this.addDays((int) currentDays);

        currentDays = (currentTimeMillisOffset) / (1000 * 60 * 60 * 24);
        this.addDays((int) currentDays);
    }

    public JulianDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean isLeapYear() {
        if (this.year % 4 == 0)
            return true;
        else
            return false;
    }


}