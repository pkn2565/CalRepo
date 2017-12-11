public class Cal {
    private String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private String name;

    public Cal() {
        super();
        this.name = "no day selected";
    }
    public Cal(String name) {
        //super();
        this.name = name;
    }

    public String getDay(String name) {
        Cal dayName = new Cal(name);
        for (int i = 0; i < day.length; i++) {
            if (name.equalsIgnoreCase(day[i])) {
                this.name = day[i];
            } else {
                continue;
            }
        }
        return this.name;
    }

    public String getDay() {
        for (int i = 0; i < day.length; i++) {
            if (name.equalsIgnoreCase(day[i])) {
                this.name = day[i];
            } else {
                continue;
            }
        }
        return this.name;
    }

    public void setDay(String name) {
        this.name = name;
    }

    private int getIdx(String name) {
        for (int i = 0; i < day.length; i++) {
            if (day[i] == name) {
                return i;
            }
        }
        return -1;
    }

    public String findDay(int numberOfDays) {
        String message = "";
        int dayIdx = getIdx(this.name);
        if ((dayIdx != -1) && (numberOfDays >= 0)) {
            message = day[(dayIdx + numberOfDays) % 7];
        } else if ((dayIdx != -1) && (numberOfDays < 0)){
            message = day[7 - ((Math.abs(numberOfDays) - dayIdx) % 7)];
        } else {
            message = "invalid day";
        }
        return message;
    }

    public String getNextDay() {
        return findDay(1);
    }
    public String getPreviousDay() {
        return findDay(-1);
    }

    @Override
    public String toString() {
        return "The name of the day is: " + name;
    }


}
