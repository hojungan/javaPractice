import java.time.LocalDate;

public class Calendar {

    private static int[] lastDateOfMon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29};
    private static String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};

    public static int getMonth(String mon) {
        if(mon.matches("[0-9]*")) {
            int mth =  Integer.parseInt(mon);
            if(mth >= 1 && mth <= 12) {
                return mth;
            } else {
                return -1;
            }
        } else if(mon.matches("[a-zA-Z]*")) {
            return convertMonth(mon);
        } else {
            return -1;
        }
    }

    public static int convertMonth(String m) {
        for(int i = 0; i < months.length; i++) {
            if(m.toLowerCase() == months[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int getYear(String yyyy) {
        if(yyyy.length() == 4) {
            if(yyyy.matches("[0-9]*")) {
                return Integer.parseInt(yyyy);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static int lastDate(int yyyy, int month) {
        if(yyyy != -1 && month != -1) {
            if(yyyy % 4 == 0 && month == 2) {
                return lastDateOfMon[12];
            } else {
                return lastDateOfMon[month-1];
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int year = getYear(args[1]);
        int month = getMonth(args[0]);
        int lastDate = lastDate(year, month);
        String space = "";
        int weekEnd = 0;
        LocalDate localdate = LocalDate.now();

        if(year == -1 || month == -1) {
            System.out.println("Year or Month is not in correct format");
        } else {
            switch(localdate.withYear(year).withMonth(month).withDayOfMonth(1).getDayOfWeek()) {
                case MONDAY:
                    space = String.format("%4S", " ");
                    weekEnd = 7;
                    break;
                case TUESDAY:
                    space = String.format("%8S", " ");
                    weekEnd = 6;
                    break;
                case WEDNESDAY:
                    space = String.format("%12S", " ");
                    weekEnd = 5;
                    break;
                case THURSDAY:
                    space = String.format("%16S", " ");
                    weekEnd = 4;
                    break;
                case FRIDAY:
                    space = String.format("%20S", " ");
                    weekEnd = 3;
                    break;
                case SATURDAY:
                    space = String.format("%24S", " ");
                    weekEnd = 2;
                    break;
                case SUNDAY:
                    weekEnd = 8;
                    break;
            }

            System.out.println("       " + months[month-1].toUpperCase() + ", " + year);
            System.out.println("---------------------------");
            System.out.println("SUN MON TUE WED THU FRI SAT");
            System.out.print(space);

            for(int i = 1; i <= lastDate; i++) {
                if(i == weekEnd) {
                    System.out.println();
                    weekEnd+=7;
                }
                System.out.print(String.format("%3d", i) + " ");
            }
        }

    }
}
