package com.hellowd.core.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * Created by Helloworld
 * User : hiyoon
 * Date : 2016-07-14
 * Time : 오후 4:59
 * 해당 클래스에 대한 기능 설명
 */
public class DatetimeUtils {

    public static String getStrToday() {
        return new SimpleDateFormat("yyMMdd").format(new Date());
    }

    public static Date getDate(int year, int month) {
        return getDate(year, month, false);
    }

    public static Date getDate(int year, int month, boolean truncate) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);

        if( truncate ) {
            cal = DateUtils.truncate(cal, Calendar.MONTH);
        }

        return cal.getTime();
    }

    public static Date getDate(int year, int month, int date, boolean truncate) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, date);

        if( truncate ) {
            cal = DateUtils.truncate(cal, Calendar.DATE);
        }

        return cal.getTime();
    }


    /**
     * 1년 후의 날을 구한다.
     */
    public static Date getNextYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.YEAR, 1);

        return cal.getTime();
    }

    /**
     * 1년 전의 날을 구한다.
     */
    public static Date getPreviousYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.YEAR, -1);

        return cal.getTime();
    }

    /**
     * 한달 후의 날을 구한다.
     */
    public static Date getNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.MONTH, 1);

        return cal.getTime();
    }

    /**
     * 한달 전의 날을 구한다.
     */
    public static Date getPreviousMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.MONTH, -1);

        return cal.getTime();
    }

    /**
     * 7일 후의 날을 구한다.
     */
    public static Date getNextWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, 7);

        return cal.getTime();
    }

    /**
     * 90일 후의 날(체험판 기간 만료일)을 구한다.
     */
    public static Date getTrialExpiredDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, 90);

        return cal.getTime();
    }

    /**
     * 7일전의 날을 구한다.
     */
    public static Date getPreviousWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, -7);

        return cal.getTime();
    }

    /**
     * 다음 날을 구한다.
     */
    public static Date getNextDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, 1);

        return cal.getTime();
    }

    /**
     * 하루 전 날을 구한다.
     */
    public static Date getPreviousDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DATE, -1);

        return cal.getTime();
    }

    /**
     * 해당 주의 첫번째 날을 구한다.
     */
    public static Date getFirstDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, (dayOfWeek-1)*-1);

        return cal.getTime();
    }

    /**
     * 해당 달을 주간으로 분리한다. date 배열은 분할된 각 주의 첫째날이다.
     */
    public static Date[] divideWeeks(Date date, boolean boundMonth) {
        Date firstDate = getFirstDateOfMonth(date);
        Date lastDate  = getLastDateOfMonth(date);

        Date firstWeek = getFirstDateOfWeek(firstDate);
        Date lastWeek  = getLastDateOfWeek(firstWeek);

        if( boundMonth && firstWeek.before(firstDate) )
            firstWeek = firstDate;

        List<Date> result = new ArrayList<Date>();

        result.add(minimized(firstWeek));
        result.add(maximize(lastWeek));

        while( lastDate.after(lastWeek) ) {
            firstWeek = getNextDate(lastWeek);
            result.add(minimized(firstWeek));
            lastWeek = getLastDateOfWeek(firstWeek);

            if( boundMonth && lastWeek.after(lastDate) )
                lastWeek = lastDate;

            result.add(maximize(lastWeek));
        }

        Date[] array = new Date[result.size()];
        result.toArray(array);
        return array;
    }

    /**
     * 해당 주의 마지막 날을 구한다.
     */
    public static Date getLastDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 7-dayOfWeek);

        return cal.getTime();
    }

    /**
     * 해당 연도 달의 첫번째 날을 구한다.
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 해당 연도 달의 첫번째 날을 구한다.
     */
    public static Date getFirstDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));

        return minimized(cal.getTime());
    }

    /**
     * 해당 연도 달의 마지막 날을 구한다.
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 해당 연도 달의 마지막 날을 구한다.
     */
    public static Date getLastDateOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        return maximize(cal.getTime());
    }

    /**
     * 지정된 범위안에 날짜가 들어 있는지 확인한다.
     */
    public static boolean between(Date startdate, Date enddate, Date date) {
        int startCompate = startdate.compareTo(date);
        int endCompate   = enddate.compareTo(date);

        if( startCompate <= 0 && endCompate >= 0 ) return true;

        return false;
    }

    /**
     * 두 날짜 사이의 경과시간을 구한다.
     */
    public static long getDiff(int field , Date startdate, Date enddate) {
        long diff  = enddate.getTime() - startdate.getTime();

        if( field == Calendar.DATE )   return diff/(1000*60*60*24);
        if( field == Calendar.HOUR )   return diff/(1000*60*60);
        if( field == Calendar.MINUTE ) return diff/(1000*60);
        if( field == Calendar.SECOND ) return diff/(1000);

        return -1;
    }

    /**
     * 시,분,초를 모두 최소치로 초기화한다.
     */
    public static Date minimized(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

    /**
     * 시,분,초를 모두 최대치로 초기화한다.
     */
    public static Date maximize(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }


    /**
     * 시작일부터 종료일까지 사이의 날짜를 배열에 담아 리턴 ( 시작일과 종료일을 모두 포함한다 )
     *
     * @param fromDate
     * yyyy-MM-dd 형식의 시작일
     * @param toDate
     * yyyy-MM-dd 형식의 종료일
     * @return yyyy-MM-dd 형식의 날짜가 담긴 배열
     */
    public static String[] getDiffDays(String fromDate, String toDate) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calDiff = Calendar.getInstance();
            calDiff.setTime(sdf.parse(fromDate));

            //두 날자 사이의 일수
            int iDTCnt = (int)((sdf.parse(toDate).getTime() - sdf.parse(fromDate).getTime()) / 1000 / 60 / 60 / 24);

            // 시작일부터
            calDiff.add(Calendar.DATE, -1);

            // 데이터 저장
            ArrayList<String> list = new ArrayList<String>();

            for (int i = 0; i <= iDTCnt; i++) {
                calDiff.add(Calendar.DATE, 1);
                list.add(sdf.format(calDiff.getTime()));
            }

            String[] result = new String[list.size()];

            list.toArray(result);
            //return sdf.parse(fromDate).toString();

            return result;
        }
        catch (Exception ex)
        {
            //return ex.toString();
            return null;
        }
    }
}
