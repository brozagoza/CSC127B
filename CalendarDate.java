/*=======================================================================================================================================
 |   Assignment:  Program #1: The CalendarDate Class
 |       Author:  Alejandro Zaragoza
 |       Course:  CSC 127B
 |
 |       TA/SL :  Ben Gaska
 |   Instructor:  L. McCann
 |     Due Date:  September 3, 2015 9:00pm
 |
 |  Description:  This program is simply a class, with a constructor, and a few instance methods. Several of the methods perform various
 |                tasks such as displaying the year, month, etc. 
 |                
 | Operational :  
 | Requirements   
 |
 | Deficencies :  none
 |                
 *=====================================================================================================================================*/
public class CalendarDate {
    public int year;
    public int month;
    public int day;
    
    /*===================================================================================================================================
     |  Constructor CalendarDate
     |
     |        Purpose: Creates a CalendarDate object that represents the given date.
     |
     |     Parameters: int year - the year of the date
     |                 int month - the month of the date
     |                 int day - the day of the date
     |
     |        Returns:  (void)
     *=================================================================================================================================*/    
    public CalendarDate (int year, int month, int day) {
        boolean leap;
        
        
        if (year % 4 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0)           // checks to see if year is a leap year
            leap = true;
        else
            leap = false;
        
        
        if (month < 1)           // sets the month to one if out of range
        {
            this.month = 1;
            month = this.month;
        }
        else if (month > 12)          // sets month to 12 if out of range
        {
            this.month = 12;
            month = this.month;
        }
        else
            this.month = month;
        
        
        
        if (day < 1)             // sets day to 1 if out of range
        {
            this.day = 1;
            day = this.day;
        }
        else
            this.day = day;
        
        if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
                         month == 10 || month == 12))           // sets day to 31 if out of range
        {
            this.day = 31;
            day = this.day;
        }
        else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))  // sets day to 30 if out range
        {
            this.day = 30;
            day = this.day;
        }
        else
            this.day = day;
        
        if (day > 28 && month == 2 && !(leap)) // sets day to 28 if month is Feb
        {
            this.day = 28;
            day = this.day;
        }
         else if (day > 29 && month == 2 && leap)    // sets day to 29 if month is Feb
         {
            this.day = 29;
            day = this.day;
         }
         else
             this.day = day;
        
        if (year < 1753)
        {
            this.year = 1753;
            year = this.year;
        }
        else
            this.year = year;
        
        
    } // end constructor
    
    
    
    /*===================================================================================================================================
     |  Method setDate
     |
     |        Purpose: Resets the object's date to fulfill the parameters outlined.
     |
     |     Parameters: Font title - the font to be used with the title
     |                 double radius - the radius constatnt that is used globally
     |
     |        Returns:  (void)
     *=================================================================================================================================*/
    public void setDate (int year, int month, int day) {
       boolean leap;
        
        
        if (year % 4 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0)           // checks to see if year is a leap year
            leap = true;
        else
            leap = false;
        
        
        if (month < 1)           // sets the month to one if out of range
        {
            this.month = 1;
            month = this.month;
        }
        else if (month > 12)          // sets month to 12 if out of range
        {
            this.month = 12;
            month = this.month;
        }
        else
            this.month = month;
        
        
        
        if (day < 1)             // sets day to 1 if out of range
        {
            this.day = 1;
            day = this.day;
        }
        else
            this.day = day;
        
        if (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
                         month == 10 || month == 12))           // sets day to 31 if out of range
        {
            this.day = 31;
            day = this.day;
        }
        else if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11))  // sets day to 30 if out range
        {
            this.day = 30;
            day = this.day;
        }
        else
            this.day = day;
        
        if (day > 28 && month == 2 && !(leap)) // sets day to 28 if month is Feb
        {
            this.day = 28;
            day = this.day;
        }
         else if (day > 29 && month == 2 && leap)    // sets day to 29 if month is Feb
         {
            this.day = 29;
            day = this.day;
         }
         else
             this.day = day;
        
        if (year < 1753)
        {
            this.year = 1753;
            year = this.year;
        }
        else
            this.year = year;
        
    } // end setDate
    
    
    
    /*===================================================================================================================================
     |  Method getYear
     |
     |        Purpose: Returns the year.
     |
     |     Parameters: none
     |
     |        Returns: year - the year of the CalendarDate
     *=================================================================================================================================*/
    public int getYear(){
        
        return year;
    } // ends getYear
    
    
    
    /*===================================================================================================================================
     |  Method getMonth
     |
     |        Purpose: Returns the month.
     |
     |     Parameters: none
     |
     |        Returns: month - the month of the CalendarDate
     *=================================================================================================================================*/
    public int getMonth(){
        
        return month;
    } // ends getMonth
    
    
    
    /*===================================================================================================================================
     |  Method getDay
     |
     |        Purpose: Returns the day.
     |
     |     Parameters: none
     |
     |        Returns: day - the day of the CalendarDate
     *=================================================================================================================================*/
    public int getDay(){
        
        return day;
    } // ends getDay
    
    
    
    
    /*===================================================================================================================================
     |  Method getMonthAsString
     |
     |        Purpose: Returns the month as a String.
     |
     |     Parameters: none
     |
     |        Returns: monthString - the month in string form
     *=================================================================================================================================*/
    public String getMonthAsString() {
        String monthString = new String("");
        
        switch (month) {
            case 1:  
                monthString = monthString + "January";
                break;
            case 2:  
                monthString = monthString + "February";
                break;
            case 3:  
                monthString = monthString + "March";
                break;
            case 4:  
                monthString = monthString + "April";
                break;
            case 5:  
                monthString = monthString + "May";
                break;
            case 6:  
                monthString = monthString + "June";
                break;
            case 7:  
                monthString = monthString + "July";
                break;
            case 8:  
                monthString = monthString + "August";
                break;
            case 9:  
                monthString = monthString + "September";
                break;
            case 10: 
                monthString = monthString + "October";
                break;
            case 11: 
                monthString = monthString + "November";
                break;
            case 12: 
                monthString = monthString + "December";
                break;
            default: 
                break;
        } // end switch
        
        return monthString;
    } // end getMonthAsString
    
    
    /*===================================================================================================================================
     |  Method toString
     |
     |        Purpose: Returns the date as a String.
     |
     |     Parameters: none
     |
     |        Returns: finalString - the entire date in string form (ex: August 22, 1996)
     *=================================================================================================================================*/
    public String toString()
    {
        String finalString = new String("");
        
        
        switch (month) {
            case 1:  
                finalString = "January";
                break;
            case 2:  
                finalString = "February";
                break;
            case 3:  
                finalString = "March";
                break;
            case 4:  
                finalString = "April";
                break;
            case 5:  
                finalString = "May";
                break;
            case 6:  
                finalString = "June";
                break;
            case 7:  
                finalString = "July";
                break;
            case 8:  
                finalString = "August";
                break;
            case 9:  
                finalString = "September";
                break;
            case 10: 
                finalString = "October";
                break;
            case 11: 
                finalString = "November";
                break;
            case 12: 
                finalString = "December";
                break;
            default: 
                break;
        } // end switch
        
        finalString = finalString + " " + day + ", " + year;    // puts month day, year in string form
        
        return finalString;
    } // end toString
    
    
    /*===================================================================================================================================
     |  Method equals
     |
     |        Purpose: Returns true if this object and CalendarDate both represent the same date.
     |
     |     Parameters: CalendarDate otherDate - the other date to compare to
     |
     |        Returns: true/false
     *=================================================================================================================================*/
    public boolean equals (CalendarDate otherDate) {
        
        if (this.year == otherDate.year && this.month == otherDate.month && this.day == otherDate.day)
            return true;
        else
            return false;
        
    } // end equals
    
    
    
    /*===================================================================================================================================
     |  Method tomorrow
     |
     |        Purpose: Returns the following date from this object's date.
     |
     |     Parameters: 
     |
     |        Returns: CalendarDate tomorrow
     *=================================================================================================================================*/
    public CalendarDate tomorrow() {
        boolean leap;
        CalendarDate nextDate = new CalendarDate(year, month, day);
        
        
        if (year % 4 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0)           // checks to see if year is a leap year
            leap = true;
        else
            leap = false;
        
        
        if (this.day >= 31 && (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 ||
                               this. month == 10 || this.month == 12)) // for months with 31 days
        {
            if (this.day == 31)                             // if at the end of the month start new month and reset the day
            {
                nextDate.day = 1;
                nextDate.month = ++this.month;
            } // end if
            
            else 
                nextDate.day = ++this.day;                // increment the day
            
            
            
            if (this.month == 13)
            {
                nextDate.month = 1;                         // resets month to '1' and starts a new year if after dec
                nextDate.year = this.year + 1;
            } // end month if
            
        } // end if
        
        
        
        if (this.day >= 30 && (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)) // for months with 30 days
        {
            if (this.day == 30)                            // reset the day and start new month
            {
                nextDate.day = 1;
                nextDate.month = ++this.month;
            } // end if
            else
                nextDate.day = ++this.day;
            
            if (this.month == 13)
            {
                nextDate.month = 1;                         // resets month to '1' and starts a new year if after dec
                nextDate.year = this.year + 1;
            } // end month if
            
        } // end if
        
        
        if (this.month == 2)                               // if it is the month of FEB
        {
            if (leap && this.day == 28)                    // leap year false, so goes to 1
                nextDate.day = ++this.day;
            
            else if (leap && this.day == 29)                    // leap year true, so goes to 29 & new month
            {
                nextDate.day = 1;
                nextDate.month = ++this.month;
            } // end if
            
            else if (!(leap) && this.day == 28)                  // leap year false, so goes to 1 & new month
            {
                nextDate.day = 1;
                nextDate.month = ++this.month;
            } // end if
            else                                            // nutin speeeeecial so yah
                nextDate.day = ++this.day;
            
        } // end feb month if
        
        
        
        return nextDate;
    } // end CalendarDate
    
    
    
} // ends class