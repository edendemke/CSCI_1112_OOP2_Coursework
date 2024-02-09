import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
    private Line hLine = new Line();
    private Line mLine = new Line();
    private Line sLine = new Line();

    public ClockPane() {
        setCurrentTime();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        createClock();
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        createClock();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);

        createClock();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);

        createClock();
    }

    private void createClock() {
        double clockRadius = Math.min(this.getWidth(), this.getHeight()) * 0.8 * 0.5;
        double centerX = this.getWidth() / 2;
        double centerY = this.getHeight() / 2;

        Circle clockCircle = new Circle(centerX, centerY, clockRadius);
        clockCircle.setFill(Color.WHITE);
        clockCircle.setStroke(Color.BLACK);

        Text text12 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text text9 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text text3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text text6 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        sLine.setStartX(centerX);
        sLine.setStartY(centerY);
        sLine.setEndX(secondX);
        sLine.setEndY(secondY);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        mLine.setStartX(centerX);
        mLine.setStartY(centerY);
        mLine.setEndX(xMinute);
        mLine.setEndY(minuteY);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        hLine.setStartX(centerX);
        hLine.setStartY(centerY);
        hLine.setEndX(hourX);
        hLine.setEndY(hourY);

        getChildren().clear();
        getChildren().addAll(clockCircle, text12, text9, text3, text6, sLine, mLine, hLine);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        createClock();
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        createClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        createClock();
    }
    
    public Line getHLine() {
    	return hLine;
    }
    
    public Line getMLine() {
    	return mLine;
    }
    
    public Line getSLine() {
    	return sLine;
    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    //add part that makes hour hand translucent
    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;

        if (!hourHandVisible) {
            getHLine().setStroke(Color.WHITE);
        } else {
        	 getHLine().setStroke(Color.GREEN);
        }
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    //add part that makes minute hand translucent
    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        
        if (!minuteHandVisible) {
            getMLine().setStroke(Color.WHITE);
        } else {
        	 getMLine().setStroke(Color.BLUE);
        }
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    //add part that makes second hand translucent
    public void setSecondHandVisible(boolean secondHandVisible) {
       this.secondHandVisible = secondHandVisible;
       
       if (!secondHandVisible) {
           getSLine().setStroke(Color.WHITE);
       } else {
       	 getSLine().setStroke(Color.RED);
       }
    }
}
